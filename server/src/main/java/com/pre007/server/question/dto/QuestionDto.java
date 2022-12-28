package com.pre007.server.question.dto;

import com.pre007.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class QuestionDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private String title;
        private String content;
        private Long memberId;

        public Member getMember() {
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }
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

        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private Long memberId;

        public void setMember(Member member) {
            this.memberId = member.getMemberId();
        }
    }
}
