//package com.pre007.server.vote.service;
//
//import com.pre007.server.exception.BusinessLogicException;
//import com.pre007.server.exception.ExceptionCode;
//import com.pre007.server.vote.entity.Vote;
//import com.pre007.server.vote.repository.VoteRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class VoteService {
//    private VoteRepository voteRepository;
///*
//    public VoteService(VoteRepository voteRepository) {
//        this.voteRepository = voteRepository;
//    }
//
//    public Vote plusVote(Map<Long,Long> pathVarMap){
//
//        Vote findVote = findVerifiedVote(pathVarMap.get());
//        return null;
//    }
//    public Vote minusVote(Map<Long,Long> pathVarMap){}
//
//    private Vote findVerifiedVote(long memberId, long questionId) {
//        Optional<Vote> optionalMember =
//                voteRepository.findByMemberIdAndQuestionId(memberId, questionId);
//        Vote findVote =
//                optionalMember.orElseThrow(() ->
//                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)); //Code 추가
//        return findVote;
//    }*/
//}
