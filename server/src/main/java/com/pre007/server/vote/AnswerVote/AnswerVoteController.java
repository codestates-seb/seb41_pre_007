package com.pre007.server.vote.AnswerVote;

import com.pre007.server.dtoUtils.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers/{answer-id}")
@RequiredArgsConstructor
public class AnswerVoteController {
    private final AnswerVoteService answerVoteService;


    @PostMapping("/up")
    public ResponseEntity upAnswer(@PathVariable("answer-id") Long answerId){
        return new ResponseEntity(new SingleResponseDto<>(answerVoteService.upAnswerVote(answerId)),HttpStatus.CREATED);
    }
    @PostMapping("/down")
    public ResponseEntity downAnswer(@PathVariable("answer-id") Long answerId){
        return new ResponseEntity(new SingleResponseDto<>(answerVoteService.downAnswerVote(answerId)),HttpStatus.CREATED);
    }

    //TODO 이거 Question Controller에 엮는게 조금 더 편하려나...
/*    @PostMapping("/{vote-id}/{member-id}")
    public ResponseEntity upVote(@PathVariable Map<Long, Long> pathVarMap){
        Vote response = answerVoteService.plusVote(pathVarMap);

        return new ResponseEntity(response.getVoteCount(), HttpStatus.OK);
    }

    @PostMapping("/{vote-id}/{member-id}")
    public ResponseEntity downVote(@PathVariable Map<Long, Long> pathVarMap){
        Vote response = answerVoteService.minusVote(pathVarMap);

        return new ResponseEntity(response.getVoteCount(), HttpStatus.OK);
    }*/
}
