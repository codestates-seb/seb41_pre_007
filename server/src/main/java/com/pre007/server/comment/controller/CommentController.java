package com.pre007.server.comment.controller;

import com.pre007.server.comment.dto.CommentDto;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.comment.mapper.CommentMapper;
import com.pre007.server.comment.service.CommentService;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/answer/{answer-id}/comments")
@AllArgsConstructor
@Validated
@Slf4j
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    // 코멘트 등록
    @PostMapping
    public ResponseEntity<SingleResponseDto<CommentDto.Response>> postComment(
            @Valid @RequestBody CommentDto.Post requestBody) {
        Comment comment = commentMapper.commentPostToComment(requestBody);
        Comment createdComment = commentService.createComment(comment);
        CommentDto.Response response = commentMapper.commentToCommentResponse(createdComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    // 코멘트 수정
    @PatchMapping("/{comment-id}")
    public ResponseEntity<SingleResponseDto<CommentDto.Response>> patchComment(
            @PathVariable("comment-id") @Positive long commentId,
            @Valid @RequestBody CommentDto.Patch requestBody) {
        Comment updatedComment = commentService.updateComment(
                commentMapper.commentPatchToComment(commentId, requestBody));
        CommentDto.Response response = commentMapper.commentToCommentResponse(updatedComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    // 특정 코멘트 삭제
    @DeleteMapping("/{comment-id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("comment-id") @Positive long commentId) {
        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
