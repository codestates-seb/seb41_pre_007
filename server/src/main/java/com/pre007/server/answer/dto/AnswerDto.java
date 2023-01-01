package com.pre007.server.answer.dto;

import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class AnswerDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private String answerContent;
        private Long memberId;
        private Long questionId;
        public Member getMember() {
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }

        public Question getQuestion() {
            Question question = new Question();
            question.setQuestionId(questionId);
            return question;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long answerId;
        private String answerContent;
        private Boolean answerCheck;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long answerId;
        private String answerContent;
        private Boolean answerCheck;
        private String memberName;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private Long memberId;
        private Long questionId;
        public void setMember(Member member) {
            this.memberId = member.getMemberId();
        }

        public void setQuestion(Question question) {
            this.questionId = question.getQuestionId();
        }

    }
}
