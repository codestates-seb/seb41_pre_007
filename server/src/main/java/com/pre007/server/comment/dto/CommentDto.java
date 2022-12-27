package com.pre007.server.comment.dto;

import lombok.*;

public class CommentDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private String commentContent;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static  class Patch {
        private Long commentId;
        private String commentContent;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long commentId;
        private String commentContent;
    }
}
