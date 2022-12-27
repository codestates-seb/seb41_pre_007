/*
package com.pre007.server.question.entity;

import com.pre007.server.audit.Auditable;
import com.pre007.server.question.entity.Question;
import jdk.jfr.Threshold;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Slf4j
public class QuestionTag extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private QuestionsTagStatus questionsTagStatus =
            QuestionsTagStatus.QUESTIONS_TAG_EXIST;
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    private String tagName;


    public enum QuestionsTagStatus {
        QUESTIONS_TAG_NOT_EXIST("존재하지 않는 태그"),
        QUESTIONS_TAG_EXIST("존재 태그");

        @Getter
        private String status;

        QuestionsTagStatus(String status) {
            this.status = status;
        }
    }

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getQuestionTags().contains(this)) {
            this.question.getQuestionTags().add(this);
        }
    }

}
*/
