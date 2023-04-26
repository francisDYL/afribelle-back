package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.District;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DistrictSpecification implements Specification<District> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<District> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public DistrictSpecification(final Specification<District> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<District> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
