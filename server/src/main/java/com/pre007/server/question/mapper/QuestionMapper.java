package com.pre007.server.question.mapper;

import com.pre007.server.question.dto.QuestionDto;
import com.pre007.server.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionDto.Post postRequest);
    Question questionPatchDtoToQuestion(QuestionDto.Patch patchRequest);
    QuestionDto.Response questionToQuestionResponseDto(Question question);

    List<QuestionDto.Response> questionListToQuestionListResponseDto(List<Question> questionList);
}
