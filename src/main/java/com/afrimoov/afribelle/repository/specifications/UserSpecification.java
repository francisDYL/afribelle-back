package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Users;
import com.afrimoov.afribelle.domain.Users;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<Users>{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Users> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public UserSpecification(final Specification<Users> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
