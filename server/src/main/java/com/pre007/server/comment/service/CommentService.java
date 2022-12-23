package com.pre007.server.comment.service;

import com.pre007.server.comment.entity.Comment;
import com.pre007.server.comment.repository.CommentRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 코멘트 생성
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // 코멘트 수정
    public Comment updateComment(Comment comment) {
        Comment findComment = findComment(comment.getCommentId());
        Optional.ofNullable(comment.getContent())
                .ifPresent(findComment::setContent);
        return commentRepository.save(findComment);
    }

    // 특정 코멘트 삭제
    public void deleteComment(long commentId) {
        Comment findComment = findComment(commentId);
        commentRepository.delete(findComment);
    }

    // 특정 코멘트 조회
    private Comment findComment(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        return optionalComment.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.TODOS_NOT_FOUND)); // Exception 뱐경 및 코드 수정 필요
    }
}
