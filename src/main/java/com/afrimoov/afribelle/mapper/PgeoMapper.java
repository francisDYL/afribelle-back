package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Pgeo;
import com.afrimoov.afribelle.dto.PgeoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PgeoMapper extends AbstractMapper<Pgeo, PgeoDto> {

    default Pgeo fromId(Long id) {
        if(id == null) return null;

        Pgeo pgeo = new Pgeo();
        pgeo.setId(id);

        return pgeo;
    }
}
