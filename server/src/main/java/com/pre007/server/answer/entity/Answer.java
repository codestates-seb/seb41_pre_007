package com.pre007.server.answer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.AnswerComment.AnswerComment;
import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import com.pre007.server.vote.AnswerVote.AnswerVote;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    private String answerNickname;

    @Column(columnDefinition = "TEXT")
    private String answerContent;

    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean adopted;
    private int totalVotes;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore // json data null https://m.blog.naver.com/writer0713/221587351970
    private Member member;

    @JsonBackReference // 순환참조 방어 자식 클래스 측
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @JsonIgnore
    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<AnswerVote> answerVotes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<AnswerComment> answerComments = new ArrayList<>();

    public Answer(String answerContent/*, LocalDateTime createdAt, LocalDateTime modifiedAt*/) {
        this.answerContent = answerContent;/*
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;*/
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getAnswers().remove(this);
        }
        this.member = member;
        if (!member.getAnswers().contains(this)) {
            member.addAnswer(this);
        }
    }

    public void setQuestion(Question question) {
        if (this.question != null) {
            this.question.getAnswers().remove(this);
        }
        this.question = question;
        if (!question.getAnswers().contains(this)) {
            question.addAnswer(this);
        }
    }

    public void addAnswerComments(AnswerComment answerComment) {
        this.answerComments.add(answerComment);

        if (answerComment.getAnswer() != this) {
            answerComment.setAnswer(this);
        }
    }

    public void addAnswerVotes(AnswerVote answerVote) {
        this.answerVotes.add(answerVote);

        if (answerVote.getAnswer() != this) {
            answerVote.setAnswer(this);
        }
    }

    public void setAnswerNickname(String answerNickname) {
        this.answerNickname = answerNickname;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
/*
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }*/

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }
}
