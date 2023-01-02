package com.pre007.server.question.controller;

import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.question.dto.QuestionDto;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.mapper.QuestionMapper;
import com.pre007.server.question.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Slf4j
@Validated
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    //Todo 1 : 작성하기(생성하기) -> POST

    @Secured("ROLE_USER")
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post postRequest){
        Question questionForService = questionMapper.questionPostDtoToQuestion(postRequest);
        Question questionForResponse = questionService.createQuestion(questionForService);
        QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(questionForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    //Todo 2 : 수정하기 -> PATCH

    @Secured("ROLE_USER")
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@RequestBody QuestionDto.Patch patchRequest,
                                        @PathVariable("question-id") long questionId){
        Question questionForService = questionMapper.questionPatchDtoToQuestion(patchRequest);
        questionForService.setQuestionId(questionId);
        Question questionForResponse = questionService.updateQuestion(questionForService);
        QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(questionForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 3 : 모든 질문 조회 -> GET All
    @GetMapping
    public ResponseEntity getAllQuestion(@RequestParam int page,
                                         @RequestParam int size){
        Page<Question> pageQuestion = questionService.findAllQuestion(page-1, size);
        List<Question> questionListForResponse = pageQuestion.getContent();
        //questionListForResponse.stream().forEach(question -> question.setQuestionTags(questionTagService.findverifiedQuestionTags(question)));
        List<QuestionDto.Response> responses = questionMapper.questionListToQuestionListResponseDto(questionListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(responses, pageQuestion), HttpStatus.OK);
    }

    //Todo 4 : 특정 질문 조회 -> GET One
    @GetMapping("/{question-id}")
    public ResponseEntity getOneQuestion(@PathVariable("question-id") long questionId){

        Question questionForResponse = questionService.findQuestion(questionId);
        QuestionDto.Response response  = questionMapper.questionToQuestionResponseDto(questionForResponse);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    //Todo 5 : 질문 삭제하기 -> DELETE ONE

    @Secured("ROLE_USER")
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteOneQuestion(@PathVariable("question-id") long questionId){
        questionService.deleteOneQuestion(questionId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
