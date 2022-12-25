package com.pre007.server.answer.controller;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
@Validated
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper mapper;

    // 답변 작성
    @PostMapping
    public ResponseEntity addAnswer(@RequestBody @Valid AnswerDto.Post postRequest) {
        Answer answerForService = mapper.answerPostDtoToAnswer(postRequest);
        Answer answerForResponse = answerService.createAnswer(postRequest.getMemberId(), answerForService);
        AnswerDto.Response response = mapper.answerToAnswerResponse(answerForResponse);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),HttpStatus.CREATED);
    }

    // 본인 작성 답변 수정
    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") long answerId,
                                     @Valid @RequestBody AnswerDto.Patch patchRequest) {
        patchRequest.setAnswerId(answerId);
        Answer answerForService = mapper.answerPatchDtoToAnswer(patchRequest);
        Answer answerForResponse = answerService.updateAnswer(patchRequest.getMemberId(), answerForService);
        AnswerDto.Response response = mapper.answerToAnswerResponse(answerForResponse);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response), HttpStatus.OK);
    }
/*
    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId) {
        Answer answerForResponse = answerService.findAnswer(answerId);
        AnswerDto.Response response = mapper.answerToAnswerResponse(answerForResponse);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response), HttpStatus.OK);
    }

    // ?
    @GetMapping
    public ResponseEntity getFindAnswers(@Positive @RequestParam int page,
                                         @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answerListForResponse = pageAnswers.getContent();
        List<AnswerDto.Response> responses = mapper.answerListToAnswerResponsesList(answerListForResponse);

        return new ResponseEntity<>(new MultiResponseDto<>(responses, pageAnswers), HttpStatus.OK);
    }*/

    // 삭제할 답변
    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // 채택
    @PostMapping("/{answer-id}/adopt/{question-id}")
    public ResponseEntity adoptAnswer(@PathVariable("answer-id") Long answerId, @PathVariable("question-id") Long questionId) {
        answerService.adoptAnswer(answerId, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}



















