package com.pre007.server.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    MEMBER_REDIRECTION_LOGIN_SUCCESS(303,"LOGIN_SUCCESS"),
    MEMBER_REDIRECTION_FIND_PASSWORD(303,"FIND_PASSWORD"),
    ANSWER_NOT_FOUND(404, "Answer not found"),
    MEMBER_DISPLAY_NAME_EXISTS(409, "MEMBER_DISPLAY_NAME_EXISTS"),
    TAG_NOT_FOUND(404, "Tag not found"),
    COMMENT_NOT_FOUND(404, "Comment not found"),
    QUESTION_NOT_FOUND(404, "Question not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
