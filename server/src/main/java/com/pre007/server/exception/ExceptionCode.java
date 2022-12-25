package com.pre007.server.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    ANSWER_NOT_FOUND(404, "답변을 찾을 수 없습니다."),
    ANSWER_DUPLICATE_ADOPT(400, "답변은 한 번만 채택할 수 있습니다."),
    ANSWER_CANNOT_POST(400, "답변은 회원만 작성할 수 있습니다."),
    ANSWER_CANNOT_DELETE(400, "채택된 답변은 삭제할 수 없습니다."),
    ANSWER_DUPLICATE_POST(400, "이미 등록한 답변이 있습니다. 기존 답변을 수정해주세요."),
    ONLY_FOR_WRITER(400, "작성자만 사용할 수 있습니다."),
    QUESTION_NOT_FOUND(404, "질문을 찾을 수 없습니다."),
    CANT_DUPLICATE_VOTE(400, "추천, 비추천은 한 번만 가능합니다."),
    COMMENT_CANNOT_EDIT(400, "작성자만 수정할 수 있습니다."),
    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다.");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
