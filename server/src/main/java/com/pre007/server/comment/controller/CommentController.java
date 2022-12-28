package com.pre007.server.comment.controller;

import com.pre007.server.comment.dto.CommentDto;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.comment.mapper.CommentMapper;
import com.pre007.server.comment.service.CommentService;
import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
//@RequestMapping("/answer/{answer-id}/comments")
@Slf4j
@Validated
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    //Todo 1 : 작성하기(생성하기) -> POST
    @PostMapping
    public ResponseEntity postComment(@RequestBody CommentDto.Post postRequest) {
        Comment commentForService = commentMapper.commentPostDtoToComment(postRequest);
        Comment commentForResponse = commentService.createComment(commentForService);
        CommentDto.Response response = commentMapper.commentToCommentResponseDto(commentForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    //Todo 2 : 수정하기 -> PATCH
    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@RequestBody CommentDto.Patch patchRequest,
                                       @PathVariable("comment-id") long commentId) {
        Comment commentForService = commentMapper.commentPatchDtoToComment(patchRequest);
        commentForService.setCommentId(commentId);
        Comment commentForResponse = commentService.updateComment(commentForService);
        CommentDto.Response response = commentMapper.commentToCommentResponseDto(commentForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 3 : 모든 질문 조회 -> GET All
    @GetMapping
    public ResponseEntity getAllComment(@RequestParam int page,
                                        @RequestParam int size) {
        Page<Comment> pageComment = commentService.findAllComment(page - 1, size);
        List<Comment> commentListForResponse = pageComment.getContent();
        List<CommentDto.Response> responses = commentMapper.commentListToCommentListResponseDto(commentListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(responses, pageComment), HttpStatus.OK);
    }

    //Todo 4 : 특정 질문 조회 -> GET One
    @GetMapping("/{comment-id}")
    public ResponseEntity getOneComment(@PathVariable("comment-id") long commentId) {
        Comment commentForResponse = commentService.findOneComment(commentId);
        CommentDto.Response response = commentMapper.commentToCommentResponseDto(commentForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 5 : 질문 삭제하기 -> DELETE ONE
    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteOneComment(@PathVariable("comment-id") long commentId) {
        commentService.deleteOneComment(commentId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
