package com.pre007.server.vote.QuestionVote;

import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions/{question-id}")
@RequiredArgsConstructor
public class QuestionVoteController {
    private final QuestionVoteService questionVoteService;

    @PostMapping("/up")
    public ResponseEntity upQuestion(@PathVariable("{question-id}") Long questionId) {
        return new ResponseEntity(new SingleResponseDto<>(questionVoteService.upQuestionVote(questionId)), HttpStatus.CREATED);
    }

    @PostMapping("/down")
    public ResponseEntity downQuestion(@PathVariable("{question-id}") Long questionId) {
        return new ResponseEntity<>(new SingleResponseDto<>(questionVoteService.downQuestionVote(questionId)), HttpStatus.CREATED);
    }

}
