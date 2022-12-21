package com.pre007.server.member.entity;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.comment.entity.Comment;
import com.pre007.server.question.entity.Question;
import com.pre007.server.vote.entity.Vote;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
@Entity
public class Member extends Auditable {
    //기본 Entity 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; // patch, response|
    private String loginId; // post, response|
    private String password; // post, patch, response|
    private String email; // post, response|
    private String address; // post, patch, response|
    private String profileImage; // patch, response| 기본값을 어떻게 설정해야할까? => `No Image`라는 Image 로 설정
    private String nickname; // post, patch, response|
    private String name; // post, patch, response|
    private String age; // post, patch, response|
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    //Foreign Key 필드
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Vote> votes = new ArrayList<>();

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
