/*
package com.pre007.server.question.service;

import com.pre007.server.question.entity.QuestionTag;
import com.pre007.server.question.repository.QuestionTagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionTagService {
    private final QuestionTagRepository questionTagRepository;

    public QuestionTagService(QuestionTagRepository questionTagRepository) {
        this.questionTagRepository = questionTagRepository;
    }

    public List<QuestionTag> createQuestionTags(List<QuestionTag> questionTags) {
        return questionTags.stream().map(questionTag -> questionTagRepository.save(questionTag)).collect(Collectors.toList());
    }

}
*/
