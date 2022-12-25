package com.pre007.server.comment.QuestionComment;

import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class QuestionCommentService {
    private final QuestionCommentRepository questionCommentRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    public QuestionComment createQuestionComment(Long memberId, QuestionComment questionComment) {
        Long questionId = questionComment.getQuestionCommentId();

        Member member = verifyMember(memberId);
        questionComment.setMember(member);

        // 질문 맵핑
        Question question = verifyExistQuestion(questionId);
        questionComment.setQuestion(question);

        questionComment.setQuestionCommentNickname(member.getNickname());

        return questionCommentRepository.save(questionComment);

    }

    public QuestionComment updateQuestionComment(Long memberId, QuestionComment questionComment) {
        Long questionCommentId = questionComment.getQuestionCommentId();
        QuestionComment findQuestionComment = verifyExistQuestionComment(questionCommentId);

        Long postMemberId = findQuestionComment.getQuestionCommentId();
        verifySameWriter(postMemberId, memberId);

        Member findMember = verifyExistMember(memberId);

        Long questionId = questionComment.getQuestion().getQuestionId();
        Question findQuestion = verifyExistQuestion(questionId);

        findQuestionComment.setMember(findMember);
        findQuestionComment.setQuestion(findQuestion);
        findQuestionComment.setQuestionCommentContent(questionComment.getQuestionCommentContent());
        findQuestionComment.setQuestionCommentNickname(findMember.getNickname());

        return questionCommentRepository.save(findQuestionComment);
    }

    public void deleteQuestionComment(Long questionCommentId) {
        QuestionComment findQuestionComment = verifyExistQuestionComment(questionCommentId);
        questionCommentRepository.delete(findQuestionComment);
    }

    private void verifySameWriter(Long addMemberId, Long editMemberId) {
        if (!addMemberId.equals(editMemberId)) {
            throw new BusinessLogicException(ExceptionCode.COMMENT_CANNOT_EDIT);
        }
    }

    private Member verifyMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private Member verifyExistMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private Question verifyExistQuestion(Long questionID) {
        return questionRepository.findById(questionID)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
    }

    private QuestionComment verifyExistQuestionComment(Long questionCommentId) {
        return questionCommentRepository.findById(questionCommentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }


}
