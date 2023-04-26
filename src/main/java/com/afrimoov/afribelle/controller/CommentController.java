package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.CommentDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.impl.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
@Slf4j
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/saveCommentaires")
    public ResponseEntity<List<CommentDto>> saveComments(@RequestBody List<CommentDto> comments) {
        return ResponseEntity.ok(commentService.savesComments(comments));
    }

    @PutMapping(value = "/updateCommentaires")
    public ResponseEntity<List<CommentDto>> updateComments(@RequestBody List<CommentDto> comments) throws NotFoundException {
        return ResponseEntity.ok(commentService.updatesComments(comments));
    }

    @DeleteMapping(value = "/deleteCommentaires")
    public ResponseEntity<List<Long>> deleteComments(@RequestBody List<Long> comments) {
        return ResponseEntity.ok(commentService.deleteComments(comments));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAll(
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(commentService.getAll(pageRequest));
    }

    //TODO const val GET_COMMENTAIRES_CONTROLLER = "getCommentaires" ? à quoi sert celui-ci?
}
