package com.pre007.server.answer.service;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.repository.AnswerRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Positive;

import static com.pre007.server.exception.ExceptionCode.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;

    public Answer createAnswer(Long memberId, Answer answer) {
        Long questionId = answer.getQuestion().getQuestionId();
        // 중복 답변 작성 확인
        verifyDuplicateWriter(memberId, questionId);

        // 작성 멤버 가져와 매핑
        Member member = verifyExistMember(memberId);
        answer.setMember(member);

        // 작성 질문 가져와 매핑
        Question question = verifyExistQuestion(questionId);
        answer.setQuestion(question);

        // 닉네임 추가
        answer.setAnswerNickname(member.getNickname());

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(@Positive Long memberId, Answer answer) {
        Long answerId = answer.getAnswerId();
        Answer findAnswer = verifyExistAnswer(answerId);

        Long postMemberId = findAnswer.getMember().getMemberId();
        verifySameWriter(postMemberId, memberId);

        Member findMember = verifyExistMember(memberId);
        Long questionId = answer.getQuestion().getQuestionId();
        Question findQuestion = verifyExistQuestion(questionId);

        findAnswer.setMember(findMember);
        findAnswer.setQuestion(findQuestion);

        findAnswer.setAnswerNickname(findMember.getNickname());
        findAnswer.setAnswerContent(answer.getAnswerContent());

        return answerRepository.save(findAnswer);
    }

    // 답변 채택 후 삭제 불가
    public void deleteAnswer(Long answerId) {
        Answer findAnswer = verifyExistAnswer(answerId);
        if (findAnswer.isAdopted()) {
            throw new BusinessLogicException(ANSWER_CANNOT_DELETE);
        }
        answerRepository.delete(findAnswer);
    }

    // 채택된 답변이 없다면 채택
    public void adoptAnswer(Long answerId, Long questionId) {
        Answer findAnswer = verifyExistAnswer(answerId);
        Question findQuestion = verifyIfAdopted(questionId);

        //Long oriMemberId = findQuestion.getMember().getMemberId();

        findAnswer.setAdopted(true);
        findQuestion.setCheckApoted(true);


        findAnswer.setQuestion(findQuestion);

        answerRepository.save(findAnswer);
    }
/*
    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId)").descending()));
    }*/


    // 이미 채택한 질문인지
    private Question verifyIfAdopted(Long questionId) {
        Question findQuestion = verifyExistQuestion(questionId);
        if (findQuestion.isCheckAdopted()) {
            throw new BusinessLogicException(ANSWER_DUPLICATE_ADOPT);
        }
        return findQuestion;
    }

    // 멤버 확인
    private Member verifyExistMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ANSWER_CANNOT_POST));
    }

    // 이미 생성된 질문인지
    private Question verifyExistQuestion(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new BusinessLogicException(QUESTION_NOT_FOUND));
    }

    // 이미 생성된 답변인지
    public Answer verifyExistAnswer(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new BusinessLogicException(ANSWER_NOT_FOUND));
    }

    // 작성자와 수정하는 사람이 같은지
    private void verifySameWriter(Long addMemberId, Long editMemberId) {
        if (!addMemberId.equals(editMemberId)) {
            throw new BusinessLogicException(ONLY_FOR_WRITER);
        }
    }

    // 중복 답변 등록 확인
    private void verifyDuplicateWriter(Long memberId, Long questionId) {
        Question findQuestion = verifyExistQuestion(questionId);
        findQuestion.getAnswers().stream()
                .filter(answer -> answer.getMember().getMemberId().equals(memberId))
                .findAny()
                .ifPresent(duplicate -> {
                    throw new BusinessLogicException(ANSWER_DUPLICATE_POST);
                });
    }



}
