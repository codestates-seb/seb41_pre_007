package com.pre007.server.member.dto;

import com.pre007.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank
        @Email
        private String email;
        private String password;
//        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String name;
        // 백엔드 협의 필요 프론트 요청
        /*private String loginId;
        private String address;
        private String nickname;
        private int age;*/
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
        //private String loginId;
//        private String password;
        private String email;
        private String address;
        private String profileImage; //image 수정
        private String nickname;
        private String name;
        private int age;
        private Member.MemberStatus memberStatus;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
