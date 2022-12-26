package com.pre007.server.member.service;

import com.pre007.server.auth.authority.CustomAuthorityUtils;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private MemberRepository memberRepository;
    //추가; 패스워드, 사용자 권한 관련
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    //TODO createMember
    public Member createMember(Member member){
        verifyExistsEmail(member.getEmail(), member.getPassword());
        //추가: Password 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);
        // 추가: DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);
        return savedMember;
    }
    //TODO updateMember
    public Member updateMember(Member member){
        Member findMember = findVerifiedMember(member.getMemberId());

//        Optional.ofNullable(member.getPassword())
//                .ifPresent(name -> findMember.setPassword(name));
        Optional.ofNullable(member.getAddress())
                .ifPresent(address -> findMember.setAddress(address));
        Optional.ofNullable(member.getProfileImage())
                .ifPresent(profileImage -> findMember.setProfileImage(profileImage));
        Optional.ofNullable(member.getNickname())
                .ifPresent(nickname -> findMember.setNickname(nickname));
        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getAge())
                .ifPresent(age -> findMember.setAge(age));
        Optional.ofNullable(member.getMemberStatus())
                .ifPresent(memberStatus -> findMember.setMemberStatus(memberStatus));

        return memberRepository.save(findMember);
    }
    //TODO findOneMember
    public Member findOneMember(long memberId){
        return findVerifiedMember(memberId);
    }
    //TODO findAllMembers
//    @Transactional(readOnly = true)
    public Page<Member> findAllMembers(int page, int size){
        Page<Member> pageMembers = memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
        return pageMembers;
    }
    //TODO deleteOneMember
    public void deleteOneMember(long memberId){
        Member foundMember = findVerifiedMember(memberId);
        memberRepository.delete(foundMember);
    }
//    //TODO deleteAllMembers
//    public void deleteAllMembers(){
//    }

    //validation 영역
    @Transactional(readOnly = true)
    private Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(String email, String password) {
        Optional<Member> memberByEmail = memberRepository.findByEmail(email);
        if (memberByEmail.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        Optional<Member> memberByPassword = memberRepository.findByPassword(password);
        if (memberByPassword.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
