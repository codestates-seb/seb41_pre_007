package com.pre007.server.question.controller;

import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.question.dto.QuestionDto;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.mapper.QuestionMapper;
import com.pre007.server.question.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/questions")
@Validated
@AllArgsConstructor
@Slf4j
public class QuestionController {
private final QuestionService questionService;
private final QuestionMapper questionMapper;

    // 질문 등록
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody) {

        Question question = questionMapper.questionPostToQuestion(requestBody);
        Question createdQuestion = questionService.createQuestion(question, requestBody.getMemberId());

        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(createdQuestion)), HttpStatus.CREATED);
    }

    // 질문 수정
   @PatchMapping("/{question-id}")
   public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                       @Valid @RequestBody QuestionDto.Patch requestBody) {

       Question question = questionMapper.questionPatchToQuestion(requestBody);
       question.setQuestionId(questionId);

       Question updateQuestion = questionService.updateQuestion(question, requestBody.getMemberId());

       return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(updateQuestion)),HttpStatus.OK);
   }

   // 특정 질문 찾기
   @GetMapping("/{question-id}")
   public ResponseEntity getQuestion(@PathVariable("question-id") @Positive long questionId) {
       Question question = questionService.findQuestion(questionId);

       return new ResponseEntity<>(
               new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(question)),
               HttpStatus.OK);
   }

    @GetMapping("/search")
    public ResponseEntity findQuestions(@RequestParam String q, @RequestParam String sort, @RequestParam int page) {
        MultiResponseDto questions = questionService.findAllQuestion(q, sort, page - 1);
        return new ResponseEntity(questions, HttpStatus.OK);
    }

   // 모든 질문 조회
   @GetMapping
   public ResponseEntity getQuestions(@RequestParam int page,
                                      @RequestParam String sort,
                                      @RequestParam(value = "filters", required = false) String filters) {
       MultiResponseDto filterAndSortQuestions = questionService.getFilterAndSortQuestions(page - 1, sort, filters);

       return  new ResponseEntity<>(filterAndSortQuestions, HttpStatus.OK);
   }

    // 특정 질문 삭제
   @DeleteMapping("/{question-id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        questionService.delete(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}

