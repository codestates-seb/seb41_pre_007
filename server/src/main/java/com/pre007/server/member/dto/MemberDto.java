package com.pre007.server.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public class Post {
        private String loginId;
        private String password;
        private String email;
        private String address;
        private String nickname;
        private String name;
        private String age;
    }
    @AllArgsConstructor
    @Getter
    public class Patch {
        private Long memberId;
        private String password;
        private String address;
        private String profileImage;
        private String nickname;
        private String name;
        private String age;

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }
    @AllArgsConstructor
    @Getter
    public class Response {
        private Long memberId;
        private String loginId;
        private String password;
        private String email;
        private String address;
        private String profileImage;
        private String nickname;
        private String name;
        private String age;
    }
}
