package com.afrimoov.afribelle.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

//TODO define COllection Strategie in subclass see https://mapstruct.org/documentation/1.3/reference/html/#updating-bean-instances
public interface AbstractMapper <E, D> {


    D toDto(E entity);

    E toEntity(D dto);

    E updateEntity(@MappingTarget E entity, D dto);

    List<D> toDto(List<E> entity);

    List<E> toEntity(List<D> dto);
}
