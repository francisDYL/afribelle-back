package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.repository.specifications.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class AbstractService<T> {

    protected Specification<T> toSpecifications(final List<SearchCriteria> criterias) {
        return toSpecifications(criterias, null);
    }

    protected Specification<T> toSpecifications(final List<SearchCriteria> criterias, final Specification<T> initialSpecifications) {
        Specification<T> specifications = initialSpecifications;

        for (final SearchCriteria criteria : criterias) {
            final GenericSpecification<T> userSpecification = new GenericSpecification<>(criteria);

            if (specifications == null) {
                specifications = Specification.where(userSpecification);
            } else {
                specifications = criteria.isOrPredicate()? specifications.or(userSpecification) : specifications.and(userSpecification);
            }
        }

        return specifications;
    }
}
