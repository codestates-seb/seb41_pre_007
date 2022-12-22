package com.pre007.server.question.service;

import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // 질문 작성
    public Question createQuestion(Question question) {
        Question saveQuestion = questionRepository.save(question);
        return saveQuestion;
    }

    // 질문 수정
    public Question updateQuestion(Question question) {
        return null;
    }

    // 특정 질문 조회
    public Question findQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        return optionalQuestion.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.TODOS_NOT_FOUND)); // Exception 코드 수정 및 추가 필요
    }

    // 모든 질문 조회
    public Page<Question> findAllQuestion(int page, int size) {
        return questionRepository.findAll(
                PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    // 특정 질문 삭제
    public void delete(long questionId) {
        Question findQuestion = findQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    // save
    private Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

}
