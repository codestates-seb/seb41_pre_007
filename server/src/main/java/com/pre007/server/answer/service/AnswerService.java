package com.pre007.server.answer.service;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.repository.AnswerRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final MemberService memberService;
    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, MemberService memberService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.memberService = memberService;
    }

    public Answer createAnswer(Answer answer) {
        Question question = verifyExistingQuestion(answer.getQuestion());
        Member member = verifyExistingMember(answer.getMember());

        answer.setQuestion(question);
        answer.setMember(member);

        question.addAnswers(answer);
        member.addAnswer(answer);

        Answer savedAnswer = answerRepository.save(answer);

        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        Member postMember = memberService.findVerifiedMember(findAnswer.getMember().getMemberId()); // 작성자
        if(!Objects.equals(memberService.getLoginMember().getMemberId(), postMember.getMemberId())) // 로그인 유저 != 작성자
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED); // 수정 권한 없음
        Optional.ofNullable(answer.getAnswerContent())
                .ifPresent(answerContent -> findAnswer.setAnswerContent(answerContent));
       /* Optional.ofNullable(answer.getAnswerCheck())
                .ifPresent(answerCheck -> findAnswer.setAnswerCheck(answerCheck));*/
        //findAnswer.setModifiedAt(LocalDateTime.now());
        Answer savedAnswer = answerRepository.save(findAnswer);

        return savedAnswer;
    }
/* 전체 질문 조회 기능 삭제
    public Page<Answer> findAllAnswer(int page, int size) {
        Page<Answer> pageAnswers = answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending()));
        return pageAnswers;
    }*/

    public Answer findAnswer(long answerId) {
        return findVerifiedAnswer(answerId);
    }

    public List<Answer> findAnswers() {
        return answerRepository.findAll();
    }
    public void deleteOneAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);

        Member postMember = memberService.findVerifiedMember(findAnswer.getMember().getMemberId()); // 작성자
        if(!Objects.equals(memberService.getLoginMember().getMemberId(), postMember.getMemberId())) // 로그인 유저 != 작성자
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED); // 수정 권한 없음

        answerRepository.delete(findAnswer);
    }
    @Transactional(readOnly = true)
    private Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }


    private Question verifyExistingQuestion(Question question){
        return questionService.findVerifiedQuestion(question.getQuestionId());
    }
    private Member verifyExistingMember(Member member) {
        return memberService.findVerifiedMember(member.getMemberId());
    }

}
