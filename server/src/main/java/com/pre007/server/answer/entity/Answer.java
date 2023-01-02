package com.pre007.server.answer.entity;

import com.pre007.server.audit.Auditable;
import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Setter
@Slf4j
@Entity
@NoArgsConstructor
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    private String answerNickname;
    @Column(nullable = false)
    private String answerContent;

    //Todo 연관 관계 매핑 필요
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public String getMemberName() {
        return member.getName();
    }

    public long getMemberId() {
        return member.getMemberId();
    }
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public long getQuestionId() {
        return question.getQuestionId();
    }



}
