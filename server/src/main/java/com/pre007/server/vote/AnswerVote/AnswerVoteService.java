package com.pre007.server.vote.AnswerVote;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.pre007.server.exception.ExceptionCode.CANT_DUPLICATE_VOTE;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerVoteService {
    private final AnswerVoteRepository answerVoteRepository;
    private final MemberService memberService;
    private final AnswerService answerService;

    /*public AnswerVoteService(AnswerVoteRepository answerVoteRepository) {
        this.answerVoteRepository = answerVoteRepository;
    }*/

    /*
        public Vote plusVote(Map<Long,Long> pathVarMap){

            Vote findVote = findVerifiedVote(pathVarMap.get());
        }
        public Vote minusVote(Map<Long,Long> pathVarMap){}
    */
    public AnswerVoteResponseDto upAnswerVote(Long answerId) {
        Answer findAnswer = answerService.verifyExistAnswer(answerId);

        List<AnswerVote> answerVotes = findAnswer.getAnswerVotes();
        //Long memberId = get 로그인한 아이디??
        Long memberId = null;
        Member findMember = memberService.findVerifiedMember(memberId);
        answerVotes.stream()
                .filter(answerVote -> answerVote.getMember().getMemberId().equals(memberId))
                .findAny()
                .ifPresent(duplicate -> {
                    throw new BusinessLogicException(CANT_DUPLICATE_VOTE);
                });
        int answerTotalVotes = findAnswer.getTotalVotes() + 1;
        findAnswer.setTotalVotes(answerTotalVotes);

        AnswerVote answerVote = new AnswerVote();
        answerVote.setMember(findMember);
        answerVote.setAnswer(findAnswer);
        answerVote.setTotal(answerTotalVotes);
        return AnswerVoteResponseDto.of(answerVoteRepository.save(answerVote));
    }

    public AnswerVoteResponseDto downAnswerVote(Long answerId) {
        Answer findAnswer = answerService.verifyExistAnswer(answerId);

        List<AnswerVote> answerVotes = findAnswer.getAnswerVotes();
        Long memberId = null;

        Member findMember = memberService.findVerifiedMember(memberId);
        answerVotes.stream()
                .filter(answerVote -> answerVote.getMember().getMemberId().equals(memberId))
                .findAny()
                .ifPresent(duplicate -> {
                    throw new BusinessLogicException(CANT_DUPLICATE_VOTE);
                });
        int answerTotalVotes = findAnswer.getTotalVotes() - 1;
        findAnswer.setTotalVotes(answerTotalVotes);

        AnswerVote answerVote = new AnswerVote();
        answerVote.setMember(findMember);
        answerVote.setAnswer(findAnswer);
        answerVote.setTotal(answerTotalVotes);
        return AnswerVoteResponseDto.of(answerVoteRepository.save(answerVote));

    }
/*
    private Vote findVerifiedVote(long memberId, long questionId) {
        Optional<Vote> optionalMember =
                answerVoteRepository.findByMemberIdAndQuestionId(memberId, questionId);
        Vote findVote =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)); //Code 추가
        return findVote;
    }*/
}
