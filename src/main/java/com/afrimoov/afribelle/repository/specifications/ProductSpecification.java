package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Product> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public ProductSpecification(final Specification<Product> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
