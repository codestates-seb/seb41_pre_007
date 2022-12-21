package com.pre007.server.question.dto;

import com.pre007.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class QuestionDto {
    // post
    @Getter
    @Setter
    public static class Post {
        @NotBlank(message = "제목 영역은 공백이 불가합니다.")
        private String title;

        @NotBlank(message = "질문 영역은 공백이 불가합니다")
        private String content;
    }

    // patch
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        public Patch() {
        }

        private long questionId;

        @NotBlank(message = "수정할 제목 영역은 공백이 아니어야 합니다.")
        private String Title;

        @NotBlank(message = "수정할 질문 영역은 공백이 아니어야 합니다.")
        private String content;

    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long questionId;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private MemberSimple member;

        @Builder
        public Response(Long questionId, String title, String content,
                        LocalDateTime createdAt, LocalDateTime modifiedAt, Member member) {
            this.questionId = questionId;
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
            this.member = new MemberSimple(member.getMemberId(), member.getNickname());
        }

        // 작성자를 표시할 때, nickName?
        @Getter
        public static class MemberSimple {
            private Long memberId;
            private String memberNickName;

            public MemberSimple(Long memberId, String memberNickName) {
                this.memberId = memberId;
                this.memberNickName = memberNickName;
            }
        }
    }
}
