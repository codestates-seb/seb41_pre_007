package com.pre007.server.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class QuestionDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private String title;
        private String content;
    }
    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long questionId;
        private String title;
        private String content;
    }
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long questionId;
        private String title;
        private String content;
    }
}
