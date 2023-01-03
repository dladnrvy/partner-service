package com.example.partnerservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PartnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("성공케이스")
    class SuccessCase {
        @Test
        void 카테고리아이디_조회() throws Exception{
            // given
            // when
            ResultActions resultActions = mockMvc.perform(get("/partner/category/find")
                            .param("partnerId","1"))
                    .andDo(print());

            // then
            resultActions
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("data", is(notNullValue())));
        }
    }

    @Nested
    @DisplayName("실패케이스")
    class FailCase {
        @Test
        void 카테고리아이디_없는아이디_조회() throws Exception{
            // given
            // when
            ResultActions resultActions = mockMvc.perform(get("/partner/category/find")
                            .param("partnerId","123"))
                    .andDo(print());

            // then
            resultActions
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("code").value("404"));
        }

        @Test
        void 카테고리아이디_오류() throws Exception{
            // given
            // when
            ResultActions resultActions = mockMvc.perform(get("/partner/category/find")
                            .param("partnerId","test"))
                    .andDo(print());

            // then
            resultActions
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("code").value("404"));
        }
    }

}