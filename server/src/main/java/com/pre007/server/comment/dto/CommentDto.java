package com.pre007.server.comment.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CommentDto {

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Post {

        @NotBlank
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static  class Patch {

        @NotBlank
        private String content;
    }

    @Getter
    public static class Response {
        private Long commentId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private long memberId;

        @Builder
        public Response(Long commentId, String content, LocalDateTime createdAt, LocalDateTime modifiedAt, long memberId) {
            this.commentId = commentId;
            this.content = content;
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
            this.memberId = memberId;
        }
    }
}
