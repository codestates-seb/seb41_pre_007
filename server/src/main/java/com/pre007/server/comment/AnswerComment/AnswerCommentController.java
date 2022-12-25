package com.pre007.server.comment.AnswerComment;

import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers/{answer-id}/comments")
@AllArgsConstructor
@Slf4j
public class AnswerCommentController {
    private final AnswerCommentService answerCommentService;
    private final AnswerCommentMapper mapper;

    @PostMapping
    public ResponseEntity addAnswerComment(@RequestBody AnswerCommentDto.Post postRequest) {
        AnswerComment answerCommentForService = mapper.answerCommentPostToComment(postRequest);
        AnswerComment createAnswerComment = answerCommentService.createAnswerComment(postRequest.getMemberId(), answerCommentForService);
        AnswerCommentDto.Response response = mapper.answerCommentToCommentResponse(createAnswerComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{a-comment-id}")
    public ResponseEntity editAnswerComment(@PathVariable("/{a-comment-id}") Long AnswerCommentId,
                                    @RequestBody AnswerCommentDto.Patch PatchRequest) {
        PatchRequest.setAnswerCommentId(AnswerCommentId);

        AnswerComment answerCommentForService = mapper.answerCommentPatchToComment(PatchRequest);
        AnswerComment editedAnswerComment = answerCommentService.updateAnswerComment(PatchRequest.getMemberId(), answerCommentForService);
        AnswerCommentDto.Response response = mapper.answerCommentToCommentResponse(editedAnswerComment);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{a-comment-id}")
    public ResponseEntity deleteAnswerComment(@PathVariable("/{a-comment-id}") Long answerCommentId) {
        answerCommentService.deleteAnswerComment(answerCommentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
