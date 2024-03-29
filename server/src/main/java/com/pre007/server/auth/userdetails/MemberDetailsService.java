package com.pre007.server.auth.userdetails;

import com.pre007.server.auth.utils.authority.CustomAuthorityUtils;
import com.pre007.server.exception.BusinessLogicException;
import com.pre007.server.exception.ExceptionCode;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.repository.MemberRepository;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
@Data
@Component
public class MemberDetailsService implements UserDetailsService { //(1)
    //(2)
    private final MemberRepository memberRepository; //(2-1)
    private final CustomAuthorityUtils authorityUtils; //(2-2)

    public MemberDetailsService(MemberRepository memberRepository, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.authorityUtils = authorityUtils;
    }

    //(3)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(username);
        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return new MemberDetails(findMember);
    }

    //(4)
    private final class MemberDetails extends Member implements UserDetails {
        //(4-1)
        MemberDetails(Member member){
            setMemberId(member.getMemberId());
            setEmail(member.getEmail());
            setPassword(member.getPassword());
            setRoles(member.getRoles());
        }
        //(4-2)
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities(){
            return authorityUtils.createAuthorities(this.getRoles());
        }
        //(4-3)
        @Override
        public String getUsername(){
            return getEmail();
        }
        //(4-4)
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}

/*
# 전체 개요

## 부분 설명
- (1)
: UserDetailsService 를 그대로 이용하지 않고 Custom 하기 위해서 `implements`키워드 사용.
: 추상 메서드를 필수로 구현해야함. (3)에서 진행

- (2)
: DB 조회를 위한 Repository 와 조회한 사용자 정보에 권한을 생성하기 위한 AuthorityUtils(Custom) DI

- (3)
: 필수 추상 메서드(loadUserByUsername)를 구현하는 부분
: 크리덴셜(name => email)을 이용하여 DB 에서 사용자 정보를 조회하고 UserDetails(MemberDetails)형태로 반환
: UserDetails(MemberDetails)는 (4)에서 내부 클래스로 구현 예정.

- (4)
: `Custom UserDetails`역할을 하는 내부 클래스
: `Member`클래스를 상속받기 때문에 Member 객체를 사용할 수 있음. (생성자, Getter, Setter 등)
: `UserDetails`인터페이스를 구현하기 때문에 필수로 추상 메서드를 구현해야함.
: 사용자 정보에 권한을 조회하기 위한 `getAuthorities()`와 크리덴셜(name)을 조회하는 `getName()`만 구현하고, 나머진 적당히 처리(return true)

- (4-1)
: memberId(식별자), email(name), password, roles 를 인자로 하는 생성자.
: 위 4개의 정보를 담는 UserDetails 로 설정하는 부분

- (4-2)
: Member 객체의 필드인 Roles 은 List<String> 이다.
: 문자열로 저장된 필드에서, Spring Security 에서 사용될 실제 권한을 부여하는 메서드가 (4-2)이다.
: 해당 과정에서 DI 로 설정한 AuthorityUtils 를 사용한다.

- (4-3)
: Member 의 name 을 조회하는 메서드
: getEmail 을 사용할 수 있는 이유는 Member 를 상속받기 때문.

- (4-4)
: 이후에 공부
 */
