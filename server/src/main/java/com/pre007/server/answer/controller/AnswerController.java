package com.pre007.server.answer.controller;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/answers")
@Validated
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper mapper;


    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.Post postRequest) {
//
//        Answer answer = mapper.answerPostDtoToAnswer(postRequest);
        Answer answer = answerService.createAnswer(mapper.answerPostDtoToAnswer(postRequest));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponse(answer)),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                     @Valid @RequestBody AnswerDto.Patch patchRequest) {
        patchRequest.setAnswerId(answerId);
        Answer answer = mapper.answerPatchDtoToAnswer(patchRequest);
        Answer updatedAnswer = answerService.updateAnswer(answer);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponse(answer)), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId) {
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponse(answer)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getFindAnswers(@Positive @RequestParam int page,
                                         @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answerListForResponse = pageAnswers.getContent();
        List<AnswerDto.Response> responses = mapper.answerListToAnswerResponsesList(answerListForResponse);

        return new ResponseEntity<>(new MultiResponseDto<>(responses, pageAnswers), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}



















