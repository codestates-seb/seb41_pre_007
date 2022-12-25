package com.pre007.server.vote.QuestionVote;

import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionVoteId;

    private int total;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getQuestionVotes().remove(this);
        }
        this.member = member;
        if (!member.getQuestionVotes().contains(this)) {
            member.addQuestionVote(this);
        }
    }

    public void setQuestion(Question question) {
        if (this.question != null) {
            this.question.getQuestionVotes().remove(this);
        }
        this.question = question;
        if (!question.getQuestionVotes().contains(this)) {
            question.addQuestionVote(this);
        }
    }

}
