package com.pre007.server.comment.AnswerComment;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.repository.AnswerRepository;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final MemberRepository memberRepository;
    private final AnswerRepository answerRepository;

    public AnswerComment createAnswerComment(Long memberId, AnswerComment answerComment) {
        Long answerId = answerComment.getAnswerCommentId();

        Member member = verifyMember(memberId);
        answerComment.setMember(member);

        Answer answer = verifyxistAnswer(answerId);
        answerComment.setAnswer(answer);

        answerComment.setAnswerCommentNickname(member.getNickname());

        return answerCommentRepository.save(answerComment);
    }

    public AnswerComment updateAnswerComment(Long memberId, AnswerComment answerComment) {
        Long answerCommentId = answerComment.getAnswerCommentId();
        AnswerComment findAnswerComment = verifyExistAnswerComment(answerCommentId);

        Long postMemberId = findAnswerComment.getAnswerCommentId();
        verifySameWriter(postMemberId, memberId);

        Member findMember = verifyExistMember(memberId);

        Long answerId = answerComment.getAnswer().getAnswerId();
        Answer findAnswer = verifyxistAnswer(answerId);

        findAnswerComment.setMember(findMember);
        findAnswerComment.setAnswer(findAnswer);
        findAnswerComment.setAnswerCommentContent(answerComment.getAnswerCommentContent());
        findAnswerComment.setAnswerCommentNickname(findMember.getNickname());

        return answerCommentRepository.save(findAnswerComment);
    }

    public void deleteAnswerComment(Long answerCommentId) {
        AnswerComment findAnswerComment = verifyExistAnswerComment(answerCommentId);
        answerCommentRepository.delete(findAnswerComment);
    }

    private Member verifyMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private Member verifyExistMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private Answer verifyxistAnswer(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
    }

    private AnswerComment verifyExistAnswerComment(Long answerCommentId) {
        return answerCommentRepository.findById(answerCommentId).
                orElseThrow(()-> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    private void verifySameWriter(Long addMemberId, Long editMember) {
        if (!addMemberId.equals(editMember)) {
            throw new BusinessLogicException(ExceptionCode.COMMENT_CANNOT_EDIT);
        }
    }


}
