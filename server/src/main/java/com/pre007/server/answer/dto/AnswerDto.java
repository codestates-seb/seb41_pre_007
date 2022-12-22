package com.pre007.server.answer.dto;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.vote.entity.Vote;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;


public class AnswerDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank(message = "답변을 입력해주세요.")
        // @Range(max= 500)
        private String content;
        @Positive
        @NotNull
        private Long questionId;
        private Long memberId;
    }

    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long answerId;
        private String content;
        private Answer.AnswerStatus answerStatus;

        public void setAnswerId(long answerId) {
            this.answerId = answerId;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Response extends Auditable {
        private Long answerId;
        private Long memberId;
        private String content;

        private List<Vote> votes; // 갯수만 가져오는가? int?
        private List<Comment> comments;
        private Answer.AnswerStatus answerStatus;

    }
}
