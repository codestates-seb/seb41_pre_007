package com.pre007.server.question.controller;

import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.question.dto.QuestionDto;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.mapper.QuestionMapper;
import com.pre007.server.question.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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
    public ResponseEntity<SingleResponseDto<QuestionDto.Response>> postQuestion(
            @Valid @RequestBody QuestionDto.Post requestBody) {
        Question question = questionMapper.questionPostToQuestion(requestBody);
        Question createdQuestion = questionService.createQuestion(question);
        QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(createdQuestion);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    // 질문 수정
   @PatchMapping("/{question-id}")
   public ResponseEntity<SingleResponseDto<QuestionDto.Response>> patchQuestion(
           @PathVariable("question-id") @Positive long questionId,
           @Valid @RequestBody QuestionDto.Patch requestBody) {
       requestBody.setQuestionId(questionId);
       Question updateQuestion =
               questionService.updateQuestion(questionMapper.questionPatchToQuestion(requestBody));
       QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(updateQuestion);

       return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
   }

   // 특정 질문 찾기
   @GetMapping("/{question-id}")
   public ResponseEntity<SingleResponseDto<QuestionDto.Response>> getQuestion(
           @PathVariable("question-id") long questionId) {
       Question question = questionService.findQuestion(questionId);

       return new ResponseEntity<>(
               new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(question)),
               HttpStatus.OK);
   }

   // 모든 질문 조회
   @GetMapping
   public ResponseEntity<MultiResponseDto<QuestionDto.Response>> getQuestions(
           @Positive @RequestParam int page,
           @Positive @RequestParam int size) {
       Page<Question> questionPage = questionService.findAllQuestion(page-1, size);
       List<QuestionDto.Response> responses =
               questionMapper.questionsToQuestionResponseDtos(questionPage.getContent());

       return  new ResponseEntity<>(new MultiResponseDto<>(responses, questionPage), HttpStatus.OK);
   }

    // 특정 질문 삭제
   @DeleteMapping("/{question-id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        questionService.delete(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}

