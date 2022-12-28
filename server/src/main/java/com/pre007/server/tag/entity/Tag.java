/*
package com.pre007.server.tag.entity;


import com.pre007.server.audit.Auditable;
import com.pre007.server.question.entity.QuestionTag;
import com.sun.xml.bind.v2.runtime.unmarshaller.TagName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Slf4j
public class Tag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String TagName;

    @OneToMany(mappedBy = "tag")
    private List<QuestionTag> questionTags = new ArrayList<>();

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    public void setQuestionTags(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
    }
}
*/
