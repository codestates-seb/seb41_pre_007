package com.pre007.server.config;

import com.pre007.server.auth.filter.JwtAuthenticationFilter;
import com.pre007.server.auth.filter.JwtVerificationFilter;
import com.pre007.server.auth.handler.MemberAccessDeniedHandler;
import com.pre007.server.auth.handler.MemberAuthenticationEntryPoint;
import com.pre007.server.auth.handler.MemberAuthenticationFailureHandler;
import com.pre007.server.auth.handler.MemberAuthenticationSuccessHandler;
import com.pre007.server.auth.jwt.JwtTokenizer;
import com.pre007.server.auth.utils.authority.CustomAuthorityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())  // 추가
                .accessDeniedHandler(new MemberAccessDeniedHandler())            // 추가
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
                .authorizeHttpRequests(authorize -> authorize

                                /*.antMatchers("/members", "/members/login", "/docs/*").permitAll()
                                .antMatchers(HttpMethod.GET, "/questions/**", "/questions", "/answers/**").permitAll()
//*/
//                        .antMatchers(POST, "/members/login").permitAll()
//                        .antMatchers(POST, "/members").permitAll()
//                        .antMatchers(GET, "/members/profile").hasRole("USER")
//                        .antMatchers(GET, "/members/*").permitAll()
//                        .antMatchers(POST, "/questions").hasRole("USER")
//                        .antMatchers(GET, "/questions").permitAll()
//                        .antMatchers(GET, "/questions/*").permitAll()
//                        .antMatchers(PATCH, "/questions/").hasRole("USER")
//                        .antMatchers(PATCH, "/questions/*").hasRole("USER")
//                        .antMatchers(DELETE, "/questions/*").hasRole("USER")
//                        .antMatchers(POST, "/questions/*/answers").hasRole("USER")
//                        .antMatchers(DELETE, "/answers/*").hasRole("USER")
//                        .antMatchers(PATCH, "/answers/*").hasRole("USER")
//                        .anyRequest().denyAll()
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/members/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);

            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);
        }
    }

}

/*
# 전체 개요
## SecurityConfiguration
1. FilterChain 설정
2. PasswordEncoder 사용
3. CorsConfigurationSource 제공

- (0)
: (10)의 클래스 내부 메서드에서 사용되기 위하여 DI

- (1)

- (2)

- (3)
: CORS(Cross-Origin Resource Sharing)
: 애플리케이션 간 출처(Origin)가 다를 경우 스크립트 기반의 HTTP 통신을 통한 리소스 접근이 제한된다. 이때 이 제한을 선택적으로 풀어주는게 CORS.
: CORS 를 가장 쉽게 사용하는 방법은 CORSFilter 를 사용하는 방법이다.
: `withDefaults()`를 사용할 경우, `corsConfigurationSource`라는 빈 객체를 제공하면 CorsFilter를 적용할 수 있다.
: (8)으로 `corsConfigurationSource`를 빈 객체로 만들예정.

- (4)
: SSR 방식의 애플리케이션에서 Spring Security 을 사용할 때, 주로 사용하는 인증 방식인 폼 로그인 인증 방식을 비활성화함.
: 해당 인증과 관련된 Security Filter(UsernamePasswordAuthenticationFilter)가 비활성화된다.

- (5)
: HTTP Basic 인증이란, Request 를 전송할 때 마다 HTTP header 부분에 Username/Password 정보를 실어서 인증하는 방식.
: 해당 인증과 관련된 Security Filter(BasicAuthenticationFilter)가 비활성화된다.

- (6)
: 이후 수정할테지만, 우선적으로 모든 URL 에 접근 가능하도록 권한을 설정한 부분

- (7)
: `PasswordEncoder`를 사용하기 위해 Bean 객체로 등록하는 부분

- (8)
: `corsConfigurationSource`라는 빈 객체를 제공하는 부분
: (3)에서 사용한 메서드로 `CORSFilter`를 사용하기 위해서 해당 객체를 빈으로 등록
//(8-1) : `CorsConfiguration`이라는 객체를 통해 어떤 출처(Origin)와 어떤 HTTP Methods 를 허용할 것인지 규칙 설정
//(8-2) : 모든 출처(Origin)을 허락한다는 의미
//(8-3) : POST, PATCH, GET, DELETE HTTP METHODS 허용
//(8-4) : 반환값인 'CorsConfigurationSource'의 구현체, URL 과 Configuration 을 묶어서 객체로 생성.
//(8-5) : 모든 URL 에 (8-1)의 규칙을 적용

- (9)
: apply() 메서드를 통해 커스터마이징한 Configuration 을 filter chain 에 추가할 수 있음.
: (10)에서 설정한 Configuration 을 추가함.

- (10)
: `JwtAuthenticationFilter`를 Filter Chain 에 등록하는 역할을 하는 Configuration
: `AbstractHttpConfigurer`을 상속해야 커스텀 가능. 제네릭의 인자로 `AbstractHttpConfigurer`를 상속하는 타입과 `HttpSecurityBuilder`을 상속하는 타입을 제공
: (10-1)과 같이 getSharedObject(AuthenticationManager.class)를 통해 AuthenticationManager 의 객체를 얻을 수 있음. getSharedObject() 를 통해서 Spring Security의 설정을 구성하는 SecurityConfigurer 간에 공유되는 객체를 얻을 수 있음
: (10-2)에서 JwtAuthenticationFilter 를 생성하면서 JwtAuthenticationFilter에서 사용되는 AuthenticationManager 와 JwtTokenizer 를 DI
: (10-3)에서 setFilterProcessesUrl() 메서드를 통해 디폴트 request URL 인 “/login”을 “/v11/auth/login”으로 변경. 인자로 제공하는 URL 로 변경
: (10-4)에서 addFilter() 메서드를 통해 JwtAuthenticationFilter 를 Spring Security Filter Chain 에 추가
 */
