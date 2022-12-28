/*
package com.pre007.server.comment.service;

import com.pre007.server.comment.entity.Comment;
import com.pre007.server.comment.repository.CommentRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 코멘트 생성
    public Comment createComment(Comment comment) {
        Comment saveComment = commentRepository.save(comment);

        return saveComment;
    }

    // 코멘트 수정
    public Comment updateComment(Comment comment) {
        Comment findComment = findVerifiedComment(comment.getCommentId());

        Optional.ofNullable(comment.getCommentContent())
                .ifPresent(content -> findComment.setCommentContent(content));
        Comment saveComment = commentRepository.save(findComment);

        return saveComment;
    }

    public Page<Comment> findAllComment(int page, int size) {
        Page<Comment> pageComments = commentRepository.findAll(PageRequest.of(page, size, Sort.by("commentID").descending()));
        return pageComments;
    }

    public Comment findOneComment(long commentId) {
        Comment findComment = findVerifiedComment(commentId);

        return findComment;
    }

    // 특정 코멘트 삭제
    public void deleteOneComment(long commentId) {
        Comment findComment = findVerifiedComment(commentId);
        commentRepository.delete(findComment);
    }

    @Transactional(readOnly = true)
    private Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        return findComment;
    }
}
*/
