package com.pre007.server.question.entity;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.member.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String title;
    private String content;

    //Todo 연관 관계 매핑 필요
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    //@JsonIgnore  리스폰스로 보내지 않아도 됨
    private Member member;
//
//    @OneToMany(mappedBy = "question")
//    private List<Vote> votes = new ArrayList<>();


    //@JsonManagedReference
    // 이 엔티티를 json 으로 출력할 때 순환참조를 막기 위한 애너테이션
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();



    // dB에서 외래키로 가지고 있어서
    // 스프링 자체에서 양방향 매핑을 해주기 위함
/*
    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getQuestions().remove(this);
        }
        this.member = member;
        if (!member.getQuestions().contains(this)) {
            member.addQuestion(this);
        }
    }
*/

   /* public void addAnswer(Answer answer) {
        answers.add(answer);
        // this -> answer 자기 자신
        if (answer.getQuestion() != this) {
            answer.setQuestion(this);
        }
    }*/
    /*@OneToMany(mappedBy = "question")
    private List<QuestionTag> questionTags = new ArrayList<>();*/

  /*  public void setMember(Member member) {
        this.member = member;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
        if (answer.getQuestion() != this) {
            answer.addQuestion(this);
        }
    }
*/
 /*   public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getQuestion() != this) {
            questionTag.addQuestion(this);
        }
    }*/
}
