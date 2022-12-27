package com.pre007.server.answer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pre007.server.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class AnswerDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Post {
        private String answerContent;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Patch {
        private Long answerId;
        private String answerContent;
        public void setAnswerId(Long answerId) {
            this.answerId = answerId;
        }
    }

    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    @Builder
    public static class Response {
        private Long answerId;
        private String answerNickname;
        private String answerContent;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private List<Comment> comments;

    }
}
