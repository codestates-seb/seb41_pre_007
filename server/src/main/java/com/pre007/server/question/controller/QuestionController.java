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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Validated
@Slf4j
public class QuestionController {
private QuestionService questionService;
private QuestionMapper questionMapper;

    @PostMapping
    public ResponseEntity<SingleResponseDto<QuestionDto.Response>> postQuestion(
            @RequestBody QuestionDto.Post requestBody) {

        // service
        return new ResponseEntity(requestBody, HttpStatus.CREATED);
    }

   @PatchMapping("/{question-id}")
   public ResponseEntity<SingleResponseDto<QuestionDto.Response>> patchQuestion(
            @RequestBody QuestionDto.Patch requestBody) {
        // service
        return new ResponseEntity(requestBody, HttpStatus.OK);
   }

   @GetMapping("/{question-id}")
   public ResponseEntity<SingleResponseDto<QuestionDto.Response>> getQuestion(
           @PathVariable("question-id") Long questionId) {

        return null;
   }

   @GetMapping
   public ResponseEntity<MultiResponseDto<QuestionDto.Response>> getQuestions(
           @Positive @RequestParam int page,
           @Positive @RequestParam int size) {
       Page<Question> questionPage = questionService.findAllQuestion(page-1, size);
       List<QuestionDto.Response> responses = questionMapper
               .questionsToQuestionResponses(questionPage.getContent());
       return  new ResponseEntity<>(new MultiResponseDto<>(responses, questionPage), HttpStatus.OK);
   }

   @DeleteMapping("/{question-id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("question-id") @Positive long id) {
        return null;
   }

}

