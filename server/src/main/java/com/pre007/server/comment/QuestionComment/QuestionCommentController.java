package com.pre007.server.comment.QuestionComment;

import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions/{question-id}/comments")
@AllArgsConstructor
@Slf4j
public class QuestionCommentController {
    private final QuestionCommentService questionCommentService;
    private final QuestionCommentMapper mapper;

    @PostMapping
    public ResponseEntity addQuestionComment(@RequestBody QuestionCommentDto.Post postRequest) {
        QuestionComment questionCommentForService = mapper.questionCommentPostToComment(postRequest);
        QuestionComment createdQuestionComment = questionCommentService.createQuestionComment(postRequest.getMemberId(), questionCommentForService);
        QuestionCommentDto.Response response = mapper.questionCommentToCommentResponse(createdQuestionComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response),HttpStatus.CREATED);
    }

    @PatchMapping("/{q-comment-id}")
    public ResponseEntity editQuestionComment(@PathVariable("q-comment-id") Long questionCommentId,
                                              @RequestBody QuestionCommentDto.Patch PatchRequest) {
        PatchRequest.setQuestionCommentId(questionCommentId);

        QuestionComment questionCommentForService = mapper.questionCommentPatchToComment(PatchRequest);
        QuestionComment editedQuestionComment = questionCommentService.updateQuestionComment(PatchRequest.getMemberId(), questionCommentForService);
        QuestionCommentDto.Response response = mapper.questionCommentToCommentResponse(editedQuestionComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{q-comment-id}")
    public ResponseEntity deleteQuestionComment(@PathVariable("/{q-comment-id}") Long questionCommentId) {
        questionCommentService.deleteQuestionComment(questionCommentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
