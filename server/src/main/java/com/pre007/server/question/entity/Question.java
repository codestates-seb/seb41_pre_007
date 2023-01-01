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
@NoArgsConstructor
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    //Todo 연관 관계 매핑 필요
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    public long getMemberId() {
        return member.getMemberId();
    }

    public String getName() {
        return member.getName();
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
    public void addAnswers(Answer answer) {
        answers.add(answer);
    }

    public long getAnswerCount() {
        return answers.stream().count();
    }

}
