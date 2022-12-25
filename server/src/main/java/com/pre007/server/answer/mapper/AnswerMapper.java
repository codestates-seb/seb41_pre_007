package com.pre007.server.answer.mapper;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerDto.Post postRequest);

    Answer answerPatchDtoToAnswer(AnswerDto.Patch patchRequest);

    AnswerDto.Response answerToAnswerResponse(Answer answer);

    /*List<AnswerDto.Response> answerListToAnswerResponsesList(List<Answer> answers);*/

}
