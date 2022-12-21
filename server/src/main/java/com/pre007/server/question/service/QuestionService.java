package com.pre007.server.question.service;

import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        Question saveQuestion = questionRepository.save(question);
        return saveQuestion;
    }

    public Question updateQuestion(Question question) {
        return null;
    }

    // 질문 상세 조회?
    public Question findOneQuestion(long questionId) {
        return null;
    }

    public Page<Question> findAllQuestion(int page, int size) {
        return questionRepository.findAll(
                PageRequest.of(page, size, Sort.by("createdAt").descending()));
    }


    private Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

}
