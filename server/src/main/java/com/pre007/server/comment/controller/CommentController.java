package com.pre007.server.comment.controller;

import com.pre007.server.comment.dto.CommentDto;
import com.pre007.server.comment.mapper.CommentMapper;
import com.pre007.server.comment.service.CommentService;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<SingleResponseDto<CommentDto.Post>> postComment(
            @Valid @RequestBody CommentDto.Post requestBody) {

        return null;
    }

    // 코멘트 수정
    @PatchMapping("/{comment-id}")
    public ResponseEntity<SingleResponseDto<CommentDto.Patch>> patchComment(
            @PathVariable("comment-id") @Positive long commentId,
            @Valid @RequestBody CommentDto.Patch requestBody) {

        return null;
    }

    // 특정 코멘트 삭제
    @DeleteMapping("/{comment-id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("comment-id") @Positive long commentId) {

        return null;
    }

}
