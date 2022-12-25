/*
package com.pre007.server.tag.entity;

import com.pre007.server.audit.Auditable;
import com.pre007.server.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class QuestionTag extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

   */
/* @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private QuestionsTagStatus.QuestionsTagStatus = QuestionsTagStatus.QUESTIONS_TAG_NOT_EXIST;*//*


    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setQuestion(Question question) {
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
    @Column(nullable = false)
    private String tagName;

    public enum QuestionsTagStatus {
        QUESTIONS_TAG_NOT_EXIST("존재하지 않는 태그"),
        QUESTIONS_TAG_EXIST("존재하는 태그");

        @Getter
        private String status;
        QuestionsTagStatus(String status) {
            this.status = status;
        }
    }
}
*/
