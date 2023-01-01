package com.pre007.server.member.entity;

import com.pre007.server.answer.entity.Answer;
import com.pre007.server.audit.Auditable;
import com.pre007.server.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
@Entity
public class Member extends Auditable {
    /*
    TODO
    1. image type 수정 및 기본값 설정
    2. image update 방식 설정(물리적 or 경로)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; // patch, response|
    // private String loginId; // post, response|
    @Column(length = 100, nullable = false)
    private String name; // post, patch, response|
    @Column(nullable = false, updatable = false, unique = true)
    private String email; // post, response|
    @Column(length = 100, nullable = false)
    private String password; // post, patch, response|
    private String address = ""; // post, patch, response|
    private String profileImage = ""; // patch, response| 기본값을 어떻게 설정해야할까? => `No Image`라는 Image 로 설정
    private String nickname = ""; // post, patch, response|
    private int age = 0; // post, patch, response|
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE; // patch, response|

    // 추가
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
/*
    public Member() {}

    public Member(String profileImage, String nickname, String name, int age) {
        this.profileImage = profileImage;
        this.nickname = nickname;
        this.name = name;
        this.age = age;
    }
*/

    //Foreign Key 필드
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();


    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
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

/*
# 전체개요
## 1. User 권한 정보를 위한 테이블 생성
: JPA 를 이용하여 Table 을 생성할 예정.
: 테이블 연관 관계 (User : Authority = 1 : N)
- (1)
: `@ElementCollection`애너테이션을 사용하면, 별도로 User Authority 에 관한 엔티티를 생성하지 않아도 자동으로 생성된다.
: 1대N 관계이므로 List<>로 필드를 구현
//MEMBER_ROLES
: 자동으로 생성된 테이블의 명칭
: 해당 테이블이 갖는 Column 은 `MEMBER_MEMBER_ID`와 `ROLES`가 될 것이다.
: Member 회원 정보가 저장될 때, `MEMBER_MEMBER_ID`에는 MEMBER 테이블의 기본 키 값이 저장되고 `ROLES`에는 권한 정보가 저장될 것이다.
 */
