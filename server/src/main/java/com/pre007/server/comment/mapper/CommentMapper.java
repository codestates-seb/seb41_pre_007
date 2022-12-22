package com.pre007.server.comment.mapper;

import com.pre007.server.comment.dto.CommentDto;
import com.pre007.server.comment.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment CommentPostToComment(CommentDto.Post commentPostDto);
    Comment CommentPatchToComment(CommentDto.Patch commentPatchDto);
    Comment CommentToCommentResponse(CommentDto comment);
}
