/*
package com.pre007.server.comment.entity;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.member.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Setter
@Slf4j
@Entity
@NoArgsConstructor
public class Comment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;
    public Comment(String commentContent) {
        this.commentContent = commentContent;
    }

 */
/*   public void addAnswer(Answer answer) {
        this.answer = answer;
        if (!this.answer.getComments().contains(this)) {
            this.answer.addComment(this);
        }
    }*//*


}
*/
