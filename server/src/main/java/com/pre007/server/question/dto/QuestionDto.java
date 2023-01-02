package com.pre007.server.question.dto;

import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @Positive
        private Long memberId;

        public Member getMember() {
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }
    }
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Patch {
        private Long questionId;
        private String title;
        private String content;
//        public void setQuestionId(Long questionId) {this.questionId = questionId;}
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long questionId;
        private String title;
        private String content;
        private Long memberId;
        private String name;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private long answerCount;
        private List<AnswerDto.Response> answers;

/*
        public void setMember(Member member) {
            this.memberId = member.getMemberId();
        }*/
    }
}
