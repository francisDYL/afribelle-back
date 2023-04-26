package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.City;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CitySpecification  implements Specification<City> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<City> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public CitySpecification(final Specification<City> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<City> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
