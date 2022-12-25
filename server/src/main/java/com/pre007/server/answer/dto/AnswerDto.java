package com.pre007.server.answer.dto;

import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.AnswerComment.AnswerComment;
import com.pre007.server.question.entity.Question;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;


public class AnswerDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Post {
        @Positive
        private Long memberId;
        @NotNull
        private Question question;
        @NotBlank(message = "답변을 입력해주세요.")
        // @Range(max= 500)
        private String answerContent;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Patch {
        @Positive
        private Long memberId;
        @NotNull
        private Question question;
        @Positive
        private Long answerId;
        @NotBlank(message = "답변을 입력해주세요.")
        private String answerContent;

        public void setAnswerId(long answerId) {
            this.answerId = answerId;
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response extends Auditable {
        private Long answerId;
        private String answerNickname;
        private String answerContent;

        private List<AnswerComment> answerComments;

        private boolean adopted;
        private int totalVotes;

    }
}
