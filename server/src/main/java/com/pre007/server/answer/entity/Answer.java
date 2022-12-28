package com.pre007.server.answer.entity;

import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    private String answerNickname;
    @Column(columnDefinition = "TEXT")
    private String answerContent;

    //Todo 연관 관계 매핑 필요
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
   // @JsonIgnore
    private Member member;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
    /*@OneToMany(mappedBy = "answer")
    private List<Vote> votes = new ArrayList<>();*/

    //@JsonManagedReference
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();



    //테스트용 생성자
    public Answer(String answerContent/*, LocalDateTime createdAt, LocalDateTime modifiedAt*/) {
        this.answerContent = answerContent;
        /*this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;*/
    }
    public void addMember(Member member) {
        this.member = member;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }


/*
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

    public void addComments(Comment comment) {
        this.comments.add(comment);

        if (comment.getAnswer() != this) {
            comment.setAnswer(this);
        }
    }

    public void setAnswerNickname(String answerNickname) {
        this.answerNickname = answerNickname;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

*/

    /*public void addVote(Vote vote) {
        this.votes.add(vote);
        if (vote.getAnswer() != this) {
            vote.addAnswer(this);
        }
    }
*/

}
