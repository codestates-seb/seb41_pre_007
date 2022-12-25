package com.pre007.server.vote.QuestionVote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionVoteResponseDto {
    private int total;

    public static QuestionVoteResponseDto of(QuestionVote questionVote) {
        return QuestionVoteResponseDto.builder()
                .total(questionVote.getTotal())
                .build();
    }
}
