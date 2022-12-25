package com.pre007.server.comment.QuestionComment;

import com.pre007.server.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class QuestionCommentDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        @Positive
        private Long memberId;
        @NotNull
        private Question question;
        @NotBlank
        private String questionCommentContent;

    }
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {
        @Positive
        private Long memberId;
        private Long questionCommentId;
        @NotNull
        @Positive
        private Question question;
        @NotBlank
        private  String questionCommentContent;

        public void setQuestionCommentId(Long questionCommentId) {
            this.questionCommentId = questionCommentId;
        }

    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long questionCommentId;
        private String questionCommentUsername;
        private String questionCommentContent;
    }
}
