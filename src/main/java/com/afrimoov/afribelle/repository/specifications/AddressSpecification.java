package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Address;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AddressSpecification implements Specification<Address> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Address> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public AddressSpecification(final Specification<Address> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
