package com.pre007.server.answer.dto;

import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.vote.entity.Vote;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


public class AnswerDto {
    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public class post {


        @NotBlank(message = "답변을 입력해주세요.")
        private String content;
        private Long questionId;
        private Long memberId;
    }

    @AllArgsConstructor
    @Getter
    public class Patch {
        private Long answerId;
        @NotBlank(message = "답변을 입력해주세요.")
        private String content;

        public void setAnswerId(long answerId) {
            this.answerId = answerId;
        }

    }

    @AllArgsConstructor
    @Getter
    @Setter
    public class Response extends Auditable {
        private long answerId;

        private String content;

//        private LocalDateTime createdAt;
//
//        private LocalDateTime modifiedAt;

        private List<Vote> votes;
        private List<Comment> comments;

    }
}
