//package com.pre007.server.vote.repository;
//
//import com.pre007.server.answer.entity.Answer;
//import com.pre007.server.member.entity.Member;
//import com.pre007.server.question.entity.Question;
//import com.pre007.server.vote.entity.Vote;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface VoteRepository extends JpaRepository<Vote, Long> {
//    Optional<Vote> findByMemberIdAndQuestionId(Long memberId, Long questionId);
//
//    List<Vote> findAllByVoteAndAnswer(Member member, Answer answer);
//    List<Vote> findAllByAnswer(Answer answer);
//    List<Vote> findAllByVoterAndQuestion(Member member, Question question);
//    List<Vote> findAllQuestion(Question question);
//}
//
///*
//기본 Methods
//save() : 레코드 저장 (insert, update)
//findOne() : primary key로 레코드 한건 찾기
//findAll() : 전체 레코드 불러오기. 정렬(sort), 페이징(pageable) 가능
//count() : 레코드 갯수
//delete() : 레코드 삭제
////count()의 반환형은 Long
//
//Custom Method; 작성 요령
//findBy- : 쿼리를 요청하는 메서드
//countBy- : 쿼리 결과 레코드 수를 요청하는 메서드
// */
