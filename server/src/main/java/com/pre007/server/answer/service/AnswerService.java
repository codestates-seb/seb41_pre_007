package com.pre007.server.answer.service;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.repository.AnswerRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AnswerService {
    private final AnswerRepository answerRepository;
    //private final MemberService memberService;
    public AnswerService(AnswerRepository answerRepository, MemberService memberService) {
        this.answerRepository = answerRepository;
        //this.memberService = memberService;
    }

    public Answer createAnswer(Answer answer) {
        // memberService.findOneMember(answer.getMember().getMemberId());
        Answer savedAnswer = answerRepository.save(answer);
        log.info("========test===============" + savedAnswer);
        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        Optional.ofNullable(answer.getAnswerContent())
                .ifPresent(content -> findAnswer.setAnswerContent(content));
        //findAnswer.setModifiedAt(LocalDateTime.now());
        Answer savedAnswer = answerRepository.save(findAnswer);

        return savedAnswer;
    }

    public Page<Answer> findAllAnswer(int page, int size) {
        Page<Answer> pageAnswers = answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending()));
        return pageAnswers;
    }

    public Answer findOneAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);

        return findAnswer;
    }

    public void deleteOneAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);
        answerRepository.delete(findAnswer);
    }
    @Transactional(readOnly = true)
    private Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }
}
