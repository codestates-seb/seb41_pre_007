package com.pre007.server.question.service;

import antlr.StringUtils;
import com.pre007.server.dtoUtils.MultiResponseDto;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.service.MemberService;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.pre007.server.HomeController.sortQuestions;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberService memberService;

    public QuestionService(MemberService memberService, QuestionRepository questionRepository) {
        this.memberService = memberService;
        this.questionRepository = questionRepository;
    }
    // MemberService 필요
    // 파라미터에 MemberId 추가해서 question.setMember 코드 필요

    // 질문 작성
    public Question createQuestion(Question question, Long memberId) {
        Member member = memberVerifyQuestion(memberId);

        question.setMember(member);
        question.setQuestionNickname(member.getNickname());

        return questionRepository.save(question);
    }

    // 질문 수정
    public Question updateQuestion(Question question, Long memberId) {
        // 게시물 존재하는지 확인
        Question findQuestion = verifyExistQuestion(question.getQuestionId());

        Member member = memberVerifyQuestion(memberId);

        findQuestion.setMember(member);
        findQuestion.setQuestionNickname(member.getNickname());


        Optional.ofNullable(question.getTitle())
                .ifPresent(findQuestion::setTitle);
        Optional.ofNullable(question.getQuestionContent())
                .ifPresent(findQuestion::setQuestionContent);

        return questionRepository.save(findQuestion);
    }


    // 특정 질문 조회
    public Question findQuestion(long questionId) {
        Question findQuestionGet = verifyExistQuestion(questionId);
        findQuestionGet.setView(findQuestionGet.getView() +1);

        return findQuestionGet;
    }

    // 모든 질문 조회
    public MultiResponseDto findAllQuestion(String q,String sort, int page) {
        List<Question> all = questionRepository.findAll();

        if (sort.isEmpty()) {
            sort = "votes";
        }

        List<Question> findQuestions = all.stream()
                .filter(question -> question.getTitle().contains(q) || question.getQuestionContent().contains(q))
                .sorted(sortQuestions(sort))
                .collect(Collectors.toList());

        Page<Question> pageResult = getPageResult(page, findQuestions);
        return new MultiResponseDto<>(pageResult.getContent(), pageResult);
    }

    public MultiResponseDto getFilterAndSortQuestions(int page, String sort, String filters) {
        List<Question> all = questionRepository.findAll();
        List<Question> filterAndSorted = new ArrayList<>();

        if (!StringUtils.isEmpty(filters)) switch (filters) {
            case "noAdopt":
                filterAndSorted = all.stream()
                        .filter(question -> !question.isCheckAdopted())
                        .sorted(sortQuestions(sort))
                        .collect(Collectors.toList());
                break;
            case "noAnswers":
                filterAndSorted = all.stream()
                        .filter(question -> question.getAnswers().isEmpty())
                        .sorted(sortQuestions(sort))
                        .collect(Collectors.toList());
                break;
        }
        else {
            filterAndSorted = all.stream()
                    .sorted(sortQuestions(sort))
                    .collect(Collectors.toList());
        }

        Page<Question> pageResult = getPageResult(page, filterAndSorted);

        return new MultiResponseDto<>(pageResult.getContent(), pageResult);
    }

    // 특정 질문 삭제
    public void delete(long questionId) {
        Question findQuestionResult = verifyExistQuestion(questionId);
        questionRepository.delete(findQuestionResult);
    }



    // 이미 글이 존재하면 에러
    /*private void verifyExistsTitle(String title) {
        Optional<Question> question = questionRepository.findByTitle(title);
        if (question.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.QUESTION_EXISTS);
        }
    }*/

    private Page<Question> getPageResult(int page, List<Question> findQuestions) {
        Pageable pageable = PageRequest.of(page, 10);
        final int start = (int) pageable.getOffset();
        final int end = Math.min(start + pageable.getPageSize(), findQuestions.size());

        Page<Question> pageResult = new PageImpl<>(findQuestions.subList(start, end), pageable, findQuestions.size());
        return pageResult;
    }

    // 질문 작성자 회원인지
    private Member memberVerifyQuestion(Long memberId) {
        return memberService.findVerifiedMember(memberId);
    }

    // 질문 게시물이 존재하는지 questionId로 검사
    public Question verifyExistQuestion(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
    }

}
