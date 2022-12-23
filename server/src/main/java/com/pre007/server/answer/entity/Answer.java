package com.pre007.server.answer.entity;

import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.member.entity.Member;
import com.pre007.server.question.entity.Question;
import com.pre007.server.vote.entity.Vote;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Slf4j
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private AnswerStatus answerStatus = AnswerStatus.ANSWER_EXIST;

    /*@Column(nullable = false)
    private int vote = 0;*/

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();



    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public enum AnswerStatus {
        ANSWER_NOT_EXIST("존재하지 않는 답변"),
        ANSWER_EXIST("존재하는 답볍");
        @Getter
        private String status;

        AnswerStatus(String status) {
            this.status = status;
        }
    }




}
