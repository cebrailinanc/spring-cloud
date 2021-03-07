package com.cbrl.cloud.product.api.controller;

import com.cbrl.cloud.product.api.response.ApiResponse;
import com.cbrl.cloud.product.dto.CheckStockDto;
import com.cbrl.cloud.product.dto.mapper.StockMapper;
import com.cbrl.cloud.product.service.StockService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(value = StockController.class)
class StockControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;
    @MockBean
    private StockMapper stockMapper;

    @Test
    void checkStock_Success_IfRequestIsValid() throws Exception {
        Mockito.when(stockService.checkStock(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong())).
                thenReturn(CheckStockDto.builder().existStock(false).build());

        Long productId = 123L;
        this.mockMvc.perform(get("/stock/{product-id}/exist", productId)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.SUCCESS.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", Matchers.nullValue()));

        Mockito.verify(stockService).checkStock(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());
    }

    @Test
    void checkStock_Error_IfRequestIsValid() throws Exception {
      //  Mockito.when(stockService.checkStock(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong())).thenThrow(RuntimeException.class);
        Mockito.doThrow(new RuntimeException("Product not found"))
                .when(stockService).checkStock(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());
        Long productId = 123L;
        this.mockMvc.perform(get("/stock/{product-id}/exist", productId)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.ERROR.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", Matchers.notNullValue()));

        Mockito.verify(stockService).checkStock(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());
    }

    @Test
    void createStock_Success_IfRequestIsValid() throws Exception {
        this.mockMvc.perform(post("/stock")
                .content("{\"productId\":2,\"count\":10}")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.SUCCESS.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", Matchers.nullValue()));
    }

    @Test
    void createStock_Fail_IfContentOfRequestIsNotSent() throws Exception {
        this.mockMvc.perform(post("/stock")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.FAIL.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", Matchers.notNullValue()));
    }

    @Test
    void createStock_Fail_IfRequestIsNull() throws Exception {
        this.mockMvc.perform(post("/stock")
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.FAIL.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.message", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.fieldErrors", Matchers.hasSize(2)));
    }

    @Test
    void createStock_Fail_IfRequestIsInvalid() throws Exception {
        this.mockMvc.perform(post("/stock")
                .content("{\"productId\":0,\"count\":0}")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo(ApiResponse.Status.FAIL.name())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.message", Matchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.fieldErrors", Matchers.hasSize(2)));
    }

}