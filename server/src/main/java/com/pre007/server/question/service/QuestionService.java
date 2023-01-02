package com.pre007.server.question.service;

import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberService memberService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
    }
    public Question createQuestion(Question question){
        Member member = verifyExistingMember(question.getMember());
        question.setMember(memberService.getLoginMember());
        member.addQuestion(question);
        return questionRepository.save(question);
    }
    public Question updateQuestion(Question question){
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        Member postMember = memberService.findVerifiedMember(findQuestion.getMember().getMemberId()); // 작성자
        if(!Objects.equals(memberService.getLoginMember().getMemberId(), postMember.getMemberId())) // 로그인 유저 != 작성자
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED); // 수정 권한 없음

        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> findQuestion.setTitle(title));
        Optional.ofNullable(question.getContent())
                .ifPresent(content -> findQuestion.setContent(content));

        Question savedQuestion = questionRepository.save(findQuestion);
        return savedQuestion;
    }
    public Page<Question> findAllQuestion(int page, int size){
        Page<Question> pageQuestions = questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
        return pageQuestions;
    }
    public Question findQuestion(long questionId) {

        return findVerifiedQuestion(questionId);
    }
    public void deleteOneQuestion(long questionId){
        Question question = findVerifiedQuestion(questionId);

        Member postMember = memberService.findVerifiedMember(question.getMember().getMemberId()); // 작성자
        if(!Objects.equals(memberService.getLoginMember().getMemberId(), postMember.getMemberId())) // 로그인 유저 != 작성자
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED); // 수정 권한 없음
        questionRepository.delete(question);
    }

    @Transactional(readOnly = true)
    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }
    private Member verifyExistingMember(Member member) {

        return memberService.findVerifiedMember(member.getMemberId());
    }
}
