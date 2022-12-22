package com.pre007.server.testForAPI.answerForTest;

import com.google.gson.Gson;
import com.pre007.server.answer.dto.AnswerDto;
import com.pre007.server.answer.entity.Answer;
import com.pre007.server.answer.mapper.AnswerMapper;
import com.pre007.server.answer.service.AnswerService;
import com.pre007.server.member.controller.MemberController;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.util.List;

import static com.pre007.server.answer.entity.Answer.AnswerStatus.ANSWER_EXIST;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class AnswerForTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private Gson gson;
//    @MockBean
//    private AnswerMapper answerMapper;
//    @MockBean
//    private AnswerService answerService;
//    @Test
//    public void postAnswerTest() throws Exception {
//        // given 공부 하기 ㅠㅠ 가져 오는값 정해주세요 ㅠㅠ
//        // 1. stub Post request
//        AnswerDto.Post postDto = new AnswerDto.Post(
//                "답변 내용",
//                1L,
//                1L
//        );
//
//        // 2. Json 형태 변경
//        String requestToJson = gson.toJson(postDto);
//        // 3. stub response
//        long answerId = 1L;
//        AnswerDto.Response responseDto = new AnswerDto.Response(
//                1L,
//                1L,
//                "답변 내용",
//                ("test"),
//                ("코멘트를 달아주세요"),
//                ANSWER_EXIST
//        );
//
//
//
//
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        // (8) request 전송
//                );
//
//        // then
//        actions
//                .andExpect(// (9) response에 대한 기대 값 검증)
//                .andDo(document(
//                        // (10) API 문서 스펙 정보 추가
//                ));
//    }

}
