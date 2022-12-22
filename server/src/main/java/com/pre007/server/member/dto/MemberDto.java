package com.pre007.server.member.dto;

import com.pre007.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private String loginId;
        private String password;
        private String email;
        private String address;
        private String nickname;
        private String name;
        private int age;
    }
    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long memberId;
        private String password;
        private String address;
        private String profileImage;
        private String nickname;
        private String name;
        private int age;
        private Member.MemberStatus memberStatus;

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long memberId;
        private String loginId;
        private String password;
        private String email;
        private String address;
        private String profileImage; //image 수정
        private String nickname;
        private String name;
        private int age;
        private Member.MemberStatus memberStatus;
    }
}
