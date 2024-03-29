package com.pre007.server.auth.handler;

import com.google.gson.Gson;
import com.pre007.server.auth.dto.Principal;
import com.pre007.server.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MemberAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // 인증 성공 후, 로그를 기록하거나 사용자 정보를 response로 전송하는 등의 추가 작업을 할 수 있다.
        log.info("# Authenticated successfully!");
        Gson gson = new Gson();
        Member member = (Member) authentication.getPrincipal();

        Principal principal = new Principal(member.getEmail(), member.getMemberId());
        String s = gson.toJson(principal);

        response.setContentType("application/json");
        response.getWriter().write(s);
    }
}
