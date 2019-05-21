package com.desafio.api.service;

import com.desafio.api.entity.ContaCorrente;
import com.desafio.api.repository.ContaCorrenteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaCorrenteServiceImplTest {

    @MockBean
    private ContaCorrenteRepository contaCorrenteRepository;
    private ContaCorrente contaCorrente;

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @Before
    public void setup() {

        contaCorrente = ContaCorrente.ContaCorrenteBuilder.aContaCorrente()
                .withNomeCorrentista("Correntista 001")
                .withNumeroConta(500)
                .withSaldo(new BigDecimal(156.50))
                .build();
    }

    @Test
    public void obterContaCorrentePorNumero() {
        when(contaCorrenteRepository.findContaCorrenteByNumeroConta(100)).thenReturn(contaCorrente);
        ContaCorrente contaCorrente1 = contaCorrenteService.obterContaCorrentePorNumero(100);
        Assert.assertTrue(contaCorrente.equals(contaCorrente1));
    }

    @Test
    public void atualizarSaldoContaCorrente() {
        contaCorrenteService.atualizarSaldoContaCorrente(contaCorrente);
        verify(contaCorrenteRepository, times(1)).save(contaCorrente);
    }
}