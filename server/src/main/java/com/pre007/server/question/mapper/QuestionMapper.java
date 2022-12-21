package com.pre007.server.question.mapper;

import com.pre007.server.question.dto.QuestionDto;
import com.pre007.server.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post requestBody);

    Question questionPatchToQuestion(QuestionDto.Patch requestBody);

    default QuestionDto.Response questionToQuestionResponse(Question question) {
        return QuestionDto.Response.builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .modifiedAt(question.getModifiedAt())
                .member(question.getMember())
                .build();
    }
    default List<QuestionDto.Response> questionsToQuestionResponses(List<Question> questions) {
        return questions.stream()
                .map(this::questionToQuestionResponse)
                .collect(Collectors.toList());
    }
}
