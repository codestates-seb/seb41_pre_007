package com.pre007.server.member_미완.entity;

import com.pre007.server.audit.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Slf4j
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String loginId;
    private String password;
    private String email;
    private String address;
    private String profileImage;
    private String nickname;
    private String name;
    private String age;
}
