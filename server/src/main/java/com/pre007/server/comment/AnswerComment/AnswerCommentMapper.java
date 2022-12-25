package com.pre007.server.comment.AnswerComment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerCommentMapper {
    AnswerComment answerCommentPostToComment(AnswerCommentDto.Post postRequest);

    AnswerComment answerCommentPatchToComment(AnswerCommentDto.Patch patchRequest);

    AnswerCommentDto.Response answerCommentToCommentResponse(AnswerComment answerComment);
}
