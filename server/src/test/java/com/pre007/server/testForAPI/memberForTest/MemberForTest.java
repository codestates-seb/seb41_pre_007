package com.pre007.server.testForAPI.memberForTest;

import com.google.gson.Gson;
import com.pre007.server.member.controller.MemberController;
import com.pre007.server.member.dto.MemberDto;
import com.pre007.server.member.entity.Member;
import com.pre007.server.member.mapper.MemberMapper;
import com.pre007.server.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.pre007.server.prettifyTests.ApiDocumentUtils.getRequestPreProcessor;
import static com.pre007.server.prettifyTests.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberForTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private MemberMapper memberMapper;
    @MockBean
    private MemberService memberService;

    /*
    TODO
    1. Stub data AOP 단계별로 실천해보기
     */


    //throws Exception : MockMvc.perform() 문제 해결
    @Test
    public void postMemberTest() throws Exception {
        //given
        //1. stub post request
        MemberDto.Post postDto = new MemberDto.Post(
                "Login",
                "Password",
                "email@gmail.com",
                "A시 B구",
                "NickName",
                "홍길동",
                20
        );
        //2. Json 형태 변경
        String requestToJson = gson.toJson(postDto);
        //3. stub response
        long memberId = 1L;
        MemberDto.Response responseDto = new MemberDto.Response(
                memberId,
                "Login",
                "Password",
                "email@gmail.com",
                "A시 B구",
                "No Image",
                "NickName",
                "홍길동",
                20,
                Member.MemberStatus.MEMBER_ACTIVE);
        //4. Mocking Methods
        //Member serviceMember = mapper.memberPostToMember(post);
        given(memberMapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());
        //Member responseMember = memberService.createMember(serviceMember);
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());
        //MemberDto.Response response = mapper.memberToMemberResponse(responseMember);
        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        //when
        ResultActions actions =
                mockMvc.perform(
                        post("/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestToJson)
                );

        //then
        actions //forTest
                .andExpect(status().isCreated())
                //forDocs
                .andDo(document("post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("로그인 패스워드"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("회원 주소"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("회원 나이")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
                                )
                        )
                ));
    }
    @Test
    public void patchMemberTest() throws Exception{
        //given
        //1. stub post request
        long memberId = 1L;
        MemberDto.Patch patchDto = new MemberDto.Patch(
                memberId,
                "ChangedPassword",
                "C시 D구",
                "Personal Image",
                "ChangedNickName",
                "김철수",
                30,
                Member.MemberStatus.MEMBER_SLEEP);
        //2. Json 형태 변경
        String requestToJson = gson.toJson(patchDto);
        //3. stub response
        MemberDto.Response responseDto = new MemberDto.Response(
                memberId,
                "Login",
                "ChangedPassword",
                "email@gmail.com",
                "C시 D구",
                "Personal Image",
                "ChangedNickName",
                "김철수",
                30,
                Member.MemberStatus.MEMBER_SLEEP);
        //4. Mocking Methods
        given(memberMapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
        //when
        ResultActions actions =
                mockMvc.perform(
                        patch("/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestToJson)
                );
        //then
        actions //forTest
                .andExpect(status().isOk())
                //forDocs
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("로그인 패스워드"),
                                        fieldWithPath("address").type(JsonFieldType.STRING).description("회원 주소"),
                                        fieldWithPath("profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("회원 나이"),
                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
                                )
                        )
                        ));
    }
    @Test
    public void getOneMemberTest() throws Exception{
        //given
        //1. stub post request
        long memberId = 1L;
        //2. Json 형태 변경
        //3. stub response
        MemberDto.Response responseDto = new MemberDto.Response(
                memberId,
                "Login",
                "ChangedPassword",
                "email@gmail.com",
                "C시 D구",
                "Personal Image",
                "ChangedNickName",
                "김철수",
                30,
                Member.MemberStatus.MEMBER_SLEEP);
        //4. Mocking Methods
        given(memberService.findOneMember(Mockito.anyLong())).willReturn(new Member());
        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
        //when
        ResultActions actions =
                mockMvc.perform(
                        get("/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                );
        //then
        actions //forTest
                .andExpect(status().isOk())
                //forDocs
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
                                )
                        )
                ));
    }
//    @Test
//    public void getAllMembersTest() throws Exception{
//        //given
//        //1. stub post request
//        //2. Json 형태 변경
//        //3. stub response
//        //4. Mocking Methods
//        //when
//        //then
//    }
//    @Test
//    public void deleteOneMemberTest() throws Exception{
//        //given
//        //1. stub post request
//        //2. Json 형태 변경
//        //3. stub response
//        //4. Mocking Methods
//        //when
//        //then
//    }
//    @Test
//    public void deleteAllMembersTest() throws Exception{
//        //given
//        //1. stub post request
//        //2. Json 형태 변경
//        //3. stub response
//        //4. Mocking Methods
//        //when
//        //then
//    }
}
