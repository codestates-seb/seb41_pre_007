package com.pre007.server.exception;

import lombok.Getter;

public enum ExceptionCode {
    TODOS_NOT_FOUND(404, "Todos not found"),
    TODOS_EXISTS(409, "Todos exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
