package com.afrimoov.afribelle.mapper;

import com.afrimoov.afribelle.domain.Comment;
import com.afrimoov.afribelle.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper extends AbstractMapper<Comment, CommentDto> {
}
