package com.pre007.server.vote.QuestionVote;

import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionVoteService {
    private final QuestionVoteRepository questionVoteRepository;
    private final MemberService memberService;
    private final QuestionService questionService;

    public QuestionVoteResponseDto upQuestionVote(Long questionID) {
        Question findQuestion = questionService.verifyExistQuestion(questionID);

        List<QuestionVote> questionVotes = findQuestion.getQuestionVotes();
        Long memberId = null;

        verifyDuplicateVote(questionVotes, memberId);

        int totalVotes = findQuestion.getTotalVotes() + 1;

        Member findMember = memberService.findVerifiedMember(memberId);
        QuestionVote questionVote = mapRelation(findQuestion, findMember, totalVotes);

        return QuestionVoteResponseDto.of(questionVote);
    }

    public  QuestionVoteResponseDto downQuestionVote(Long questionId) {
        Question findQuestion = questionService.verifyExistQuestion(questionId);

        List<QuestionVote> questionVotes = findQuestion.getQuestionVotes();
        Long memberId = null;
        verifyDuplicateVote(questionVotes, memberId);

        int totalVotes = findQuestion.getTotalVotes() - 1;

        Member findMember = memberService.findVerifiedMember(memberId);
        QuestionVote questionVote = mapRelation(findQuestion, findMember, totalVotes);

        return QuestionVoteResponseDto.of(questionVote);

    }

    private void verifyDuplicateVote(List<QuestionVote> questionVotes, Long memberId) {
        questionVotes.stream()
                .filter(vote -> vote.getMember().getMemberId().equals(memberId))
                .findAny()
                .ifPresent(duplicate -> {
                    throw new BusinessLogicException(ExceptionCode.CANT_DUPLICATE_VOTE);
                });
    }

    private QuestionVote mapRelation(Question findQuestion, Member findMember, int totalVotes) {
        findQuestion.setTotalVotes(totalVotes);

        QuestionVote questionVote = new QuestionVote();
        questionVote.setMember(findMember);
        questionVote.setQuestion(findQuestion);
        questionVote.setTotal(totalVotes);

        return questionVoteRepository.save(questionVote);

    }

}
