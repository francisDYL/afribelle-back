package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Category;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CategorySpecification implements Specification<Category> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Category> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public CategorySpecification(final Specification<Category> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
