package com.afrimoov.afribelle.service.impl;

import com.afrimoov.afribelle.domain.Comment;
import com.afrimoov.afribelle.domain.Inspiration;
import com.afrimoov.afribelle.dto.CommentDto;
import com.afrimoov.afribelle.dto.InspirationDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.mapper.CommentMapper;
import com.afrimoov.afribelle.repository.CommentRepository;
import com.afrimoov.afribelle.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService extends AbstractService implements ICommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(@Autowired CommentRepository repository,
                          @Autowired CommentMapper mapper) {
        this.commentRepository = repository;
        this.commentMapper = mapper;
    }

    @Override
    public List<CommentDto> savesComments(List<CommentDto> comments) {
        List<Comment> toCreate = new ArrayList<>();
        for (CommentDto commentDto: comments) {
            Comment comment = commentMapper.toEntity(commentDto);
            toCreate.add(comment);
        }

        List<Comment> created = commentRepository.saveAll(toCreate);
        return commentMapper.toDto(created);
    }

    @Override
    public List<CommentDto> updatesComments(List<CommentDto> comments) throws NotFoundException {
        List<Comment> toUpdate = new ArrayList<>();
        for (CommentDto commentDto: comments) {
            Optional<Comment> optionalComment = commentRepository.findById(commentDto.getId());
            if (!optionalComment.isPresent())
                throw new NotFoundException(String.format("Comment with id %d not found",commentDto.getId()));
            Comment comment = commentMapper.updateEntity(optionalComment.get(), commentDto);
            toUpdate.add(comment);
        }

        List<Comment> updated = commentRepository.saveAll(toUpdate);
        return commentMapper.toDto(updated);
    }

    @Override
    public List<Long> deleteComments(List<Long> commentIds) {
        commentRepository.deleteAllById(commentIds);
        return commentIds;
    }

    @Override
    public Page<CommentDto> getAll(Pageable pageable) {
        Page<Comment> page = commentRepository.findAll(pageable);
        return page.map(commentMapper::toDto);
    }
}
