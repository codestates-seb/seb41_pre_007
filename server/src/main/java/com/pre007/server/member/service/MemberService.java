package com.pre007.server.member.service;

import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import org.springframework.data.domain.Page;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //TODO createMember
    public Member createMember(Member member){
        return null;
    }
    //TODO updateMember
    public Member updateMember(Member member){
        return null;
    }
    //TODO findOneMember
    public Member findOneMember(long memberId){
        return null;
    }
    //TODO findAllMembers
    public Page<Member> findAllMembers(int page, int size){
        return null;
    }
    //TODO deleteOneMember
    public void deleteOneMember(long memberId){
    }
    //TODO deleteAllMembers
    public void deleteAllMembers(){
    }
}
