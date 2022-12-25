package com.pre007.server.comment.AnswerComment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnswerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerCommentId;
    @Column(columnDefinition = "TEXT")
    private String answerCommentContent;
    private String answerCommentNickname;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore
    private Member member;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getAnswerComments().remove(this);
        }
        this.member = member;
        if (!member.getAnswerComments().contains(this)) {
            member.addAnswerComment(this);
        }
    }

    public void setAnswer(Answer answer) {
        if (this.answer != null) {
            this.answer.getAnswerComments().remove(this);
        }
        this.answer = answer;
        if (!answer.getAnswerComments().contains(this)) {
            answer.addAnswerComments(this);
        }
    }

}
