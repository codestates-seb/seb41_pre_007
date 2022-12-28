/*
package com.pre007.server.testForAPI.answerForTest;

import com.google.gson.Gson;
import com.pre007.server.answer.controller.AnswerController;
import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.pre007.server.prettifyTests.ApiDocumentUtils.getRequestPreProcessor;
import static com.pre007.server.prettifyTests.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnswerController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class AnswerForTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private AnswerMapper answerMapper;
    @MockBean
    private AnswerService answerService;
    @Test
    public void postAnswerTest() throws Exception {
        // given
        // 1. stub Post request
        AnswerDto.Post postDto = new AnswerDto.Post("답변 내용");

        // 2. Json 형태 변경
        String requestToJson = gson.toJson(postDto);
        // 3. stub response
        long answerId = 1L;
        AnswerDto.Response responseDto = new AnswerDto.Response(

                1L,
                "답변 내용"
        );
        //4. Mocking Methods
        //Answer answerForService = answerMapper.answerPostDtoToAnswer(postRequest);
        //Answer answerForResponse = answerService.createAnswer(answerForService);
        //AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);

        given(answerMapper.answerPostDtoToAnswer(Mockito.any(AnswerDto.Post.class))).willReturn(new Answer());
        //Member responseMember = memberService.createMember(serviceMember);
        given(answerService.createAnswer(Mockito.any(Answer.class))).willReturn(new Answer());
        //MemberDto.Response response = mapper.memberToMemberResponse(responseMember);
        given(answerMapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(responseDto);



        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/answers")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestToJson)
                );

        // then
        actions// (9) response에 대한 기대 값 검증)
                .andExpect(status().isCreated())
                .andDo(document("post-answer",
                getRequestPreProcessor(),
                getResponsePreProcessor(),
                requestFields(
                        List.of(
                                fieldWithPath("answerId").type(JsonFieldType.STRING).description("답변 아이디"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                        )
                ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("답변 내용")
                                )
                        )
                        // (10) API 문서 스펙 정보 추가
                ));
    }
    @Test
    public void patchAnswerTest() throws Exception {
        // given
        // 1. stub Post request
        long answerId = 1L;
        AnswerDto.Patch patchDto = new AnswerDto.Patch(answerId, "답변내용");

        // 2. Json 형태 변경
        String requestToJson = gson.toJson(patchDto);
        // 3. stub response
        AnswerDto.Response responseDto = new AnswerDto.Response(

                answerId,
                "답변 내용"
        );
        //4. Mocking Methods

//        Answer answerForService = answerMapper.answerPatchDtoToAnswer(patchRequest);
//        answerForService.setAnswerId(answerId);
//        Answer answerForResponse = answerService.updateAnswer(answerForService);
//        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);

        given(answerMapper.answerPatchDtoToAnswer(Mockito.any(AnswerDto.Patch.class))).willReturn(new Answer());
        given(answerService.updateAnswer(Mockito.any(Answer.class))).willReturn(new Answer());
        given(answerMapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(responseDto);



        // when
        ResultActions actions =
                mockMvc.perform(
                        patch("/answers/{answer-id}", answerId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestToJson)
                );

        // then
        actions// (9) response에 대한 기대 값 검증)
                .andExpect(status().isOk())
                .andDo(document("patch-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("답변 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("answerId").type(JsonFieldType.STRING).description("답변 아이디"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("답변 내용")
                                )
                        )
                        // (10) API 문서 스펙 정보 추가
                ));
    }

    @Test
    public void getOneAnswerTest() throws Exception {
        // given
        // 1. stub Post request
        long answerId = 1L;
        AnswerDto.Response responseDto = new AnswerDto.Response(answerId, "답변내용");

        // 2. Json 형태 변경
        String requestToJson = gson.toJson(responseDto);
        // 3. stub response
        AnswerDto.Response response = new AnswerDto.Response(

                answerId,
                "답변 내용"
        );
        //4. Mocking Methods
//        Answer answerForResponse = answerService.findOneAnswer(answerId);
//        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(answerForResponse);
        given(answerService.findOneAnswer(Mockito.anyLong())).willReturn(new Answer());
        given(answerMapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(responseDto);



        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/answers/{answer-id}", answerId)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions// (9) response에 대한 기대 값 검증)
                .andExpect(status().isOk())
                .andDo(document("get-one-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("답변 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("답변 내용")
                                )
                        )
                        // (10) API 문서 스펙 정보 추가
                ));
    }
    */
/*@Test
    public void getAllAnswersTest() throws Exception{
        //given
        //1. stub post request
        //2. Json 형태 변경
        //3. stub response
        //Page<Member>
        Answer answer1 = new Answer("답변 내용");
        Answer answer2 = new Answer("답변 내용2");
        Page<Answer> pageAnswer = new PageImpl<>(List.of(answer1, answer2), PageRequest.of(0, 10, Sort.by("answerId").descending()),2);
        //List<MemberDto.Response>
        long answerId1 = 1L;
        AnswerDto.Response responseDto1 = new AnswerDto.Response(
                answerId1,
                "답변내용1");
        long answerId2 = 2L;
        AnswerDto.Response responseDto2 = new AnswerDto.Response(
                answerId2,
                "답변내용2");
        List<AnswerDto.Response> listAnswer = List.of(responseDto2, responseDto1);
        //4. Mocking Methods
        given(answerService.findAllAnswer(Mockito.anyInt(), Mockito.anyInt())).willReturn(pageAnswer);
        given(answerMapper.answerListToAnswerListResponseDto(Mockito.anyList())).willReturn(listAnswer);
        //when
        ResultActions actions = mockMvc.perform(
                get("/answers")
                        .param("page", "1")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON)
        );
        //then
        actions.andExpect(status().isOk())
                .andDo(document(
                        "get-all-answers",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                List.of(
                                        parameterWithName("page").description("현재 페이지 쪽수"),
                                        parameterWithName("size").description("한 페이지 당 데이터 갯수")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[].answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                        fieldWithPath("data[].content").type(JsonFieldType.STRING).description("답변 내용"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("현재 페이지 쪽수"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("한 페이지 당 데이터 갯수"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 데이터 갯수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                )
                        )
                ));
    }*//*

    @Test
    public void deleteOneAnswerTest() throws Exception{
        //given
        Long answerId = 1L;
        doNothing().when(answerService).deleteOneAnswer(Mockito.anyLong());
        //when
        ResultActions actions = mockMvc.perform(
                delete("/answers/{answer-id}", answerId)
        );
        //then
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-one-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("회원 식별자")
                        )
                ));
    }

}
*/
