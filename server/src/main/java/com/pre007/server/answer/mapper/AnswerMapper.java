package com.pre007.server.answer.mapper;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerDto.Post postRequest);

    Answer answerPatchDtoToAnswer(AnswerDto.Patch patchRequest);

    AnswerDto.Response answerToAnswerResponseDto(Answer answer);

    List<AnswerDto.Response> answerListToAnswerListResponseDto(List<Answer> answerList);
}
