package com.afrimoov.afribelle.repository.specifications;

import com.afrimoov.afribelle.domain.Comment;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecification implements Specification<Comment> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Specification<Comment> specification;

    /**
     * Constructor
     *
     * @param specification
     *            prebuilt specs
     */
    public CommentSpecification(final Specification<Comment> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, criteriaQuery, criteriaBuilder));
        }

        return null;
    }
}
