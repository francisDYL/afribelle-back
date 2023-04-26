package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Category;
import com.afrimoov.afribelle.domain.Country;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CountrySpecification implements Specification<Country> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Country> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public CountrySpecification(final Specification<Country> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
