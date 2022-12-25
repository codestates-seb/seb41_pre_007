package com.pre007.server.vote.AnswerVote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerVoteResponseDto {
    private int total;

    public static AnswerVoteResponseDto of(AnswerVote answerVote) {
        return AnswerVoteResponseDto.builder()
                .total(answerVote.getTotal())
                .build();
    }
}
