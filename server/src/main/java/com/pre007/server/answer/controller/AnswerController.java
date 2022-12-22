package com.pre007.server.answer.controller;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/answers")
@Valid
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper mapper;
    private final MemberService memberService;
    private final QuestionService questionService;


    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.post requestBody) {
         Member finndMember = memberService.findMember(requestBody.getMemberId());
         Question findQuestion = questionService.findQuestion(requestBody.getQuestionId());

        Answer answer = mapper.answerPostDtoToAnswer(requestBody);
         answer.setMember(finndMember);
         answer.setQuestion(findQuestion);

        Answer createAnswer = answerService.createAnswer(answer);
        AnswerDto.Response response = mapper.an(createAnswer);


        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/edit/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                     @Valid @RequestBody AnswerDto.Patch requestBody) {
        requestBody.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(mapper.answerPatchDtoToAnswer(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long answerId) {
        Answer answer = answerService.findVerifiedAnswer(answerId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.answersToAnswerResponsesDtos(answers), pageAnswers), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}



















