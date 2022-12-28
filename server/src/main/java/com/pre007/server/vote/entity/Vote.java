//package com.pre007.server.vote.entity;
//
//import com.pre007.server.answer.entity.Answer;
//import com.pre007.server.audit.Auditable;
//import com.pre007.server.member.entity.Member;
//import com.pre007.server.question.entity.Question;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.validator.constraints.Range;
//
//import javax.persistence.*;
//import java.nio.channels.Pipe;
//
//@Getter
//@Setter
//@Slf4j
//@Entity
//public class Vote extends Auditable {
//    //기본 Entity 필드
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long voteId;
//    private int voteCount; // 기본값 0으로 설정
//
//    //Foreign Key 필드
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;
//    @ManyToOne
//    @JoinColumn(name = "QUESTION_ID")
//    private Question question;
//    @ManyToOne
//    @JoinColumn(name = "ANSWER_ID")
//    private Answer answer;
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
//    /*public void addAnswer(Answer answer) {
//        this.answer = answer;
//        if (!this.answer.getVotes().contains(this)) {
//            this.answer.addVote(this);
//        }
//    }*/
//
//
//
//}
