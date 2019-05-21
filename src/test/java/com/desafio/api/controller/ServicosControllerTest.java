package com.desafio.api.controller;

import com.desafio.api.service.ServicosBancariosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ServicosController.class)
public class ServicosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServicosBancariosService servicosBancariosService;

    @Test
    public void efetuarTransferenciaComSucesso() throws Exception {

        servicosBancariosService = mock(ServicosBancariosService.class);
        doNothing().when(servicosBancariosService).efetuarTransferencia(100, 200, new BigDecimal(100));

        this.mockMvc.perform(post("/servicos/transferencia")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"contaOrigem\" : 300, \"contaDestino\" : 400, \"valor\" : 254.98 }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().compareTo("Transação efetuada com sucesso");
    }
}