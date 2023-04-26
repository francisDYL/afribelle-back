package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Config;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ConfigSpecification implements Specification<Config> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Config> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public ConfigSpecification(final Specification<Config> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Config> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
