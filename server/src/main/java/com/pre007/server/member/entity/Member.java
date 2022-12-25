package com.pre007.server.member.entity;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.AnswerComment.AnswerComment;
import com.pre007.server.comment.QuestionComment.QuestionComment;
import com.pre007.server.question.entity.Question;
import com.pre007.server.vote.AnswerVote.AnswerVote;
import com.pre007.server.vote.QuestionVote.QuestionVote;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Slf4j
public class Member extends Auditable {
    /*
    TODO
    1. image type 수정 및 기본값 설정
    2. image update 방식 설정(물리적 or 경로)
     */
    //기본 Entity 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; // patch, response|
    private String loginId; // post, response|
    private String password; // post, patch, response|
    private String email; // post, response|
    private String address; // post, patch, response|
    private String profileImage = "No Image"; // patch, response| 기본값을 어떻게 설정해야할까? => `No Image`라는 Image 로 설정
    private String nickname; // post, patch, response|
    private String name; // post, patch, response|
    private int age; // post, patch, response|
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE; // patch, response|

    public Member() {}

    public Member(String profileImage, String nickname, String name, int age) {
        this.profileImage = profileImage;
        this.nickname = nickname;
        this.name = name;
        this.age = age;
    }

    //Foreign Key 필드
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<QuestionComment> questionComments = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<AnswerComment> answerComments = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<AnswerVote> answerVotes = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<QuestionVote> questionVotes = new ArrayList<>();

    public void addAnswer(Answer answer) {
        this.answers.add(answer);

        if (answer.getMember() != this) {
            answer.setMember(this);
        }
    }

    public void addQuestion(Question question) {
        this.questions.add(question);

        if (question.getMember() != this) {
            question.setMember(this);
        }
    }

    public void addQuestionComment(QuestionComment questionComment) {
        this.questionComments.add(questionComment);

        if (questionComment.getMember() != this) {
            questionComment.setMember(this);
        }
    }
    public void addAnswerComment(AnswerComment answerComment) {
        this.answerComments.add(answerComment);

        if (answerComment.getMember() != this) {
            answerComment.setMember(this);
        }
    }

    public void addAnswerVote(AnswerVote answerVote) {
        this.answerVotes.add(answerVote);

        if (answerVote.getMember() != this) {
            answerVote.setMember(this);
        }
    }

    public void addQuestionVote(QuestionVote questionVote) {
        this.questionVotes.add(questionVote);

        if (questionVote.getMember() != this) {
            questionVote.setMember(this);
        }
    }

    public void setPassword(String name) {
    }


    //Member(회원)의 상태 목록
    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
