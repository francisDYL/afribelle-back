package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.dto.SearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class GenericSpecification<T> implements Specification<T> {

    @NonNull
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()) {
            case EQUALITY:
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(root.<String> get(criteria.getKey()), criteria.getStringValue());
            case LESS_THAN:
                return criteriaBuilder.lessThan(root.<String> get(criteria.getKey()), criteria.getStringValue());
            case LIKE:
                return criteriaBuilder.like(root.<String> get(criteria.getKey()), criteria.getStringValue());
            case STARTS_WITH:
                return criteriaBuilder.like(criteriaBuilder.upper(root.<String> get(criteria.getKey())), criteria.getStringValue().toUpperCase() + "%");
            case ENDS_WITH:
                return criteriaBuilder.like(criteriaBuilder.upper(root.<String> get(criteria.getKey())), "%" + criteria.getStringValue().toUpperCase());
            case CONTAINS:
                return criteriaBuilder.like(criteriaBuilder.upper(root.<String> get(criteria.getKey())), "%" + criteria.getStringValue().toUpperCase() + "%");
            default:
                return null;
        }
    }
}
