/*
package com.pre007.server.vote.controller;
import com.pre007.server.vote.entity.Vote;
import com.pre007.server.vote.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/questions")
@Validated
@Slf4j
public class VoteController {
    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

   */
/* @PostMapping
    public ResponseEntity createVote(){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //TODO 이거 Question Controller에 엮는게 조금 더 편하려나...
    @PostMapping("/{vote-id}/{member-id}")
    public ResponseEntity upVote(@PathVariable Map<Long, Long> pathVarMap){
        Vote response = voteService.plusVote(pathVarMap);

        return new ResponseEntity(response.getVoteCount(), HttpStatus.OK);
    }

    @PostMapping("/{vote-id}/{member-id}")
    public ResponseEntity downVote(@PathVariable Map<Long, Long> pathVarMap){
        Vote response = voteService.minusVote(pathVarMap);

        return new ResponseEntity(response.getVoteCount(), HttpStatus.OK);
    }*//*

}
*/
