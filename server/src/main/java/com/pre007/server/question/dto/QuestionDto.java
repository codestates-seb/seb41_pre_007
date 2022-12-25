package com.pre007.server.question.dto;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.comment.QuestionComment.QuestionComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    // post
    @Getter
    @Setter
    public static class Post {
        private Long memberId;
        @NotBlank(message = "제목 영역은 공백이 불가합니다.")
        private String title;

        @NotBlank(message = "질문 영역은 공백이 불가합니다")
        private String questionContent;
    }

    // patch
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private Long memberId;

        private long questionId;

        @NotBlank(message = "수정할 제목 영역은 공백이 아니어야 합니다.")
        private String title;

        @NotBlank(message = "수정할 질문 영역은 공백이 아니어야 합니다.")
        private String questionContent;

    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long questionId;
        private String title;
        private String questionContent;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private int view;
        private boolean checkAdopted;

        private String questionUsername;

        private int totalVotes;

        private List<Answer> answers;

        private List<QuestionComment> questionComments;
    }
}
