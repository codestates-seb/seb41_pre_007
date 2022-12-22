package com.pre007.server.answer.mapper;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerDto.post requestBody);

    Answer answerPatchDtoToAnswer(AnswerDto.Patch requestBody);

    AnswerDto.Response answerToAnswerResponseDto(Answer answer);

    List<AnswerDto.Response> answersToAnswerResponsesDtos(List<Answer> answers);

}