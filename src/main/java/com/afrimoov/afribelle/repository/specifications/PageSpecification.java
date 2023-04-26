package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.PageEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PageSpecification implements Specification<PageEntity> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<PageEntity> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public PageSpecification(final Specification<PageEntity> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<PageEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}