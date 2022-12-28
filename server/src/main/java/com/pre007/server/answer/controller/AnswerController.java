package com.pre007.server.answer.controller;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@Slf4j
@Validated
public class AnswerController {
    private AnswerService answerService;
    private AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    //Todo 1 : 작성하기(생성하기) -> POST
    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post postRequest) {
        Answer answerForService = answerMapper.answerPostDtoToAnswer(postRequest);
        Answer answerForResponse = answerService.createAnswer(answerForService);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    //Todo 2 : 수정하기 -> PATCH
    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@RequestBody AnswerDto.Patch patchRequest,
                                      @PathVariable("answer-id") long answerId) {
        Answer answerForService = answerMapper.answerPatchDtoToAnswer(patchRequest);
        answerForService.setAnswerId(answerId);
        Answer answerForResponse = answerService.updateAnswer(answerForService);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 3 : 모든 질문 조회 -> GET All
    /* 모든 질문 조회 삭제
    @GetMapping
    public ResponseEntity getAllAnswer(@RequestParam int page,
                                       @RequestParam int size) {
        Page<Answer> pageAnswer = answerService.findAllAnswer(page - 1, size);
        List<Answer> answerListForResponse = pageAnswer.getContent();
        List<AnswerDto.Response> responses = answerMapper.answerListToAnswerListResponseDto(answerListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(responses, pageAnswer), HttpStatus.OK);
    }
*/
    //Todo 4 : 특정 질문 조회 -> GET One
    @GetMapping("/{answer-id}")
    public ResponseEntity getOneAnswer(@PathVariable("answer-id") long answerId) {
        Answer answerForResponse = answerService.findOneAnswer(answerId);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 5 : 질문 삭제하기 -> DELETE ONE
    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteOneAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteOneAnswer(answerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}



















