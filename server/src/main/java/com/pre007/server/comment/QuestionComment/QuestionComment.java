package com.pre007.server.comment.QuestionComment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionCommentId;
    @Column(columnDefinition = "TEXT")
    private String questionCommentContent;
    private String questionCommentNickname;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore
    private Member member;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getQuestionComments().remove(this);
        }
        this.member = member;
        if (!member.getQuestionComments().remove(this)) {
            member.addQuestionComment(this);
        }
    }

    public void setQuestion(Question question) {
        if (this.question != null) {
            this.question.getQuestionComments().remove(this);
        }
        this.question = question;
        if (!question.getQuestionComments().contains(this)) {
            question.addQuestionComment(this);
        }
    }

}
