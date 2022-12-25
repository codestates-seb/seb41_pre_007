package com.pre007.server.vote.AnswerVote;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnswerVote {
    //기본 Entity 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerVoteId;

    private int total;
    //private int voteCount = 0; // 기본값 0으로 설정

    //Foreign Key 필드
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public void setMember(Member member) {
        if (this.member !=null) {
            this.member.getAnswerVotes().remove(this);
        }
        this.member = member;
        if (!member.getAnswerVotes().contains(this)) {
            member.addAnswerVote(this);
        }
    }

    public void setAnswer(Answer answer) {
        if (this.answer != null) {
            this.answer.getAnswerVotes().remove(this);
        }
        this.answer = answer;
        if (!answer.getAnswerVotes().contains(this)) {
            answer.addAnswerVotes(this);
        }
    }
}
