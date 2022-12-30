//package com.pre007.server.testForAPI.memberForTest;
//
//import com.google.gson.Gson;
//import com.pre007.server.member.controller.MemberController;
//import com.pre007.server.member.dto.MemberDto;
//import com.pre007.server.member.entity.Member;
//import com.pre007.server.member.mapper.MemberMapper;
//import com.pre007.server.member.service.MemberService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static com.pre007.server.prettifyTests.ApiDocumentUtils.getRequestPreProcessor;
//import static com.pre007.server.prettifyTests.ApiDocumentUtils.getResponsePreProcessor;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(MemberController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class MemberForTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private Gson gson;
//    @MockBean
//    private MemberMapper memberMapper;
//    @MockBean
//    private MemberService memberService;
//
//    /*
//    TODO
//    1. Stub data AOP 단계별로 실천해보기
//     */
//
//    //throws Exception : MockMvc.perform() 문제 해결
//    @Test
//    public void postMemberTest() throws Exception {
//        //given
//        //1. stub post request
//        MemberDto.Post postDto = new MemberDto.Post(
//                "Login",
//                "Password",
//                "email@gmail.com",
//                "A시 B구",
//                "Hong",
//                "홍길동",
//                20
//        );
//        //2. Json 형태 변경
//        String requestToJson = gson.toJson(postDto);
//        //3. stub response
//        long memberId = 1L;
//        MemberDto.Response responseDto = new MemberDto.Response(
//                memberId,
//                "Login",
//                "Password",
//                "email@gmail.com",
//                "A시 B구",
//                "No Image",
//                "Hong",
//                "홍길동",
//                20,
//                Member.MemberStatus.MEMBER_ACTIVE);
//        //4. Mocking Methods
//        //Member serviceMember = mapper.memberPostToMember(post);
//        given(memberMapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());
//        //Member responseMember = memberService.createMember(serviceMember);
//        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());
//        //MemberDto.Response response = mapper.memberToMemberResponse(responseMember);
//        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/members")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(requestToJson)
//                );
//
//        //then
//        actions //forTest
//                .andExpect(status().isCreated())
//                //forDocs
//                .andDo(document("post-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("회원 나이")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
//                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
//                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void patchMemberTest() throws Exception{
//        //given
//        //1. stub post request
//        long memberId = 1L;
//        MemberDto.Patch patchDto = new MemberDto.Patch(
//                memberId,
//                "ChangedPassword",
//                "C시 D구",
//                "Personal Image",
//                "Soo",
//                "김철수",
//                30,
//                Member.MemberStatus.MEMBER_SLEEP);
//        //2. Json 형태 변경
//        String requestToJson = gson.toJson(patchDto);
//        //3. stub response
//        MemberDto.Response responseDto = new MemberDto.Response(
//                memberId,
//                "Login",
//                "ChangedPassword",
//                "email@gmail.com",
//                "C시 D구",
//                "Personal Image",
//                "Soo",
//                "김철수",
//                30,
//                Member.MemberStatus.MEMBER_SLEEP);
//        //4. Mocking Methods
//        given(memberMapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
//        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
//        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        patch("/members/{member-id}", memberId)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(requestToJson)
//                );
//        //then
//        actions //forTest
//                .andExpect(status().isOk())
//                //forDocs
//                .andDo(document("patch-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("member-id").description("회원 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
//                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("age").type(JsonFieldType.NUMBER).description("회원 나이"),
//                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
//                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
//                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
//                                )
//                        )
//                        ));
//    }
//    @Test
//    public void getOneMemberTest() throws Exception{
//        //given
//        //1. stub post request
//        long memberId = 1L;
//        //2. Json 형태 변경
//        //3. stub response
//        MemberDto.Response responseDto = new MemberDto.Response(
//                memberId,
//                "Login",
//                "ChangedPassword",
//                "email@gmail.com",
//                "C시 D구",
//                "Personal Image",
//                "Soo",
//                "김철수",
//                30,
//                Member.MemberStatus.MEMBER_SLEEP);
//        //4. Mocking Methods
//        given(memberService.findOneMember(Mockito.anyLong())).willReturn(new Member());
//        given(memberMapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/members/{member-id}", memberId)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//        //then
//        actions //forTest
//                .andExpect(status().isOk())
//                //forDocs
//                .andDo(document("get-one-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("member-id").description("회원 식별자")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
//                                        fieldWithPath("data.password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("data.profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.age").type(JsonFieldType.NUMBER).description("회원 나이"),
//                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원 상태")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void getAllMembersTest() throws Exception{
//        //given
//        //1. stub post request
//        //2. Json 형태 변경
//        //3. stub response
//        //Page<Member>
//        Member member1 = new Member("image_1", "Hong", "홍길동", 20);
//        Member member2 = new Member("image_2", "Soo", "김철수", 30);
//        Page<Member> pageMember = new PageImpl<>(List.of(member1, member2), PageRequest.of(0, 10, Sort.by("memberId").descending()),2);
//        //List<MemberDto.Response>
//        long memberId1 = 1L;
//        MemberDto.Response responseDto1 = new MemberDto.Response(
//                memberId1,
//                "Login",
//                "Password",
//                "email@gmail.com",
//                "A시 B구",
//                "image_1",
//                "Hong",
//                "홍길동",
//                20,
//                Member.MemberStatus.MEMBER_ACTIVE);
//        long memberId2 = 2L;
//        MemberDto.Response responseDto2 = new MemberDto.Response(
//                memberId2,
//                "Login",
//                "ChangedPassword",
//                "email@gmail.com",
//                "C시 D구",
//                "image_2",
//                "Soo",
//                "김철수",
//                30,
//                Member.MemberStatus.MEMBER_SLEEP);
//        List<MemberDto.Response> listMember = List.of(responseDto2, responseDto1);
//        //4. Mocking Methods
//        given(memberService.findAllMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(pageMember);
//        given(memberMapper.memberListToMemberResponseList(Mockito.anyList())).willReturn(listMember);
//        //when
//        ResultActions actions = mockMvc.perform(
//                get("/members")
//                        .param("page", "1")
//                        .param("size", "10")
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//        //then
//        actions.andExpect(status().isOk())
//                .andDo(document(
//                        "get-all-members",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("현재 페이지 쪽수"),
//                                        parameterWithName("size").description("한 페이지 당 데이터 갯수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data[].loginId").type(JsonFieldType.STRING).description("로그인 아이디"),
//                                        fieldWithPath("data[].password").type(JsonFieldType.STRING).description("로그인 패스워드"),
//                                        fieldWithPath("data[].email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data[].address").type(JsonFieldType.STRING).description("회원 주소"),
//                                        fieldWithPath("data[].profileImage").type(JsonFieldType.STRING).description("회원 프로필이미지"),
//                                        fieldWithPath("data[].nickname").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("data[].name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data[].age").type(JsonFieldType.NUMBER).description("회원 나이"),
//                                        fieldWithPath("data[].memberStatus").type(JsonFieldType.STRING).description("회원 상태"),
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("현재 페이지 쪽수"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("한 페이지 당 데이터 갯수"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 데이터 갯수"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void deleteOneMemberTest() throws Exception{
//        //given
//        Long memberId = 1L;
//        doNothing().when(memberService).deleteOneMember(Mockito.anyLong());
//        //when
//        ResultActions actions = mockMvc.perform(
//                delete("/members/{member-id}", memberId)
//        );
//        //then
//        actions.andExpect(status().isNoContent())
//                .andDo(document(
//                        "delete-one-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("member-id").description("회원 식별자")
//                        )
//                ));
//    }
////    @Test
////    public void deleteAllMembersTest() throws Exception{
////        //given
////        doNothing().when(memberService).deleteOneMember(Mockito.);
////        //when
////        ResultActions actions = mockMvc.perform(
////                delete("/members")
////        );
////        //then
////        actions.andExpect(status().isNoContent())
////                .andDo(document(
////                        "delete-All-members",
////                        getRequestPreProcessor(),
////                        getResponsePreProcessor()
////                ));
////    }
//}
