package com.pre007.server.comment.QuestionComment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionCommentMapper {
    QuestionComment questionCommentPostToComment(QuestionCommentDto.Post postRequest);

    QuestionComment questionCommentPatchToComment(QuestionCommentDto.Patch PatchRequest);

    QuestionCommentDto.Response questionCommentToCommentResponse(QuestionComment questionComment);
}
