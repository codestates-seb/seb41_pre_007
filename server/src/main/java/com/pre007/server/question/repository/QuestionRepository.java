package com.pre007.server.question.repository;

import com.pre007.server.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Long> {
   /* Optional<Question> findByTitle(String title);

    Page<Question> findAllByQuestionStatus(Pageable pageable, Question.QuestionStatus questionStatus);
    // 삭제된 글 빼고 전체 질문글 가져옴
    @Query(value = "select * from ((select * from questions a\n" +
            "         where upper(a.body) like upper(concat('%',:keyWord,'%')) or upper(a.title) like upper(concat('%',:keyWord,'%')))\n" +
            "         union (select * from questions q2 where q2.question_id in(\n" +
            "select b.question_id from\n" +
            "             (select * from questions_tag t where t.status = 'QUESTIONS_TAG_EXIST') b\n" +
            "         where upper(b.tag_name) like upper(concat('%',:keyWord,'%'))))) final_q where final_q.status = 'QUESTION_EXIST'",
            nativeQuery = true)
    List<Question> searchQuestionsByKeyWord(@Param("keyWord") String keyWord);*/
}
