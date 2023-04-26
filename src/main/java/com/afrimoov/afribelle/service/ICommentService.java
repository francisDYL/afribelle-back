package com.afrimoov.afribelle.service;

import com.afrimoov.afribelle.dto.CommentDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    
    List<CommentDto> savesComments(List<CommentDto> comments);

    List<CommentDto> updatesComments(List<CommentDto> comments) throws NotFoundException;

    List<Long> deleteComments(List<Long> commentIds);

    Page<CommentDto> getAll(Pageable pageable);
}
