package com.pre007.server.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.QuestionComment.QuestionComment;
import com.pre007.server.member.entity.Member;
import com.pre007.server.vote.QuestionVote.QuestionVote;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
/*
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_EXIST;*/

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionContent;

    @Column
    private int view;

    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean checkAdopted;

    @Column(nullable = false)
    private String questionNickname;

    @Column
    private Integer totalVotes;

/*

    // 공통
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
*/

    // 테이블 연결관계...
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore // json data null
    private Member member;

    @JsonManagedReference
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<QuestionComment> questionComments = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<QuestionVote> questionVotes = new ArrayList<>();
/*
    public enum QuestionStatus {
        QUESTION_NOT_EXIST("존재하지 않는 질문"),
        QUESTION_EXIST("존재하는 질문");

        @Getter
        private String status;

        QuestionStatus(String status) {
            this.status = status;
        }


    }*/

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getQuestions().remove(this);
        }
        this.member = member;
        if (!member.getQuestions().contains(this)) {
            member.addQuestion(this);
        }
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        if (answer.getQuestion() != this) {
            answer.setQuestion(this);
        }

    }

    public void addQuestionComment(QuestionComment questionComment) {
        questionComments.add(questionComment);
        if (questionComment.getQuestion() != this){
            questionComment.setQuestion(this);
        }
    }

    public void addQuestionVote(QuestionVote questionVote) {
        questionVotes.add(questionVote);
        if (questionVote.getQuestion() != this) {
            questionVote.setQuestion(this);
        }
    }
}
