package com.desafio.api.repository;

import com.desafio.api.entity.ContaCorrente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaCorrenteRepositoryTest {

    private ContaCorrente contaCorrente;

    @MockBean
    private ContaCorrenteRepository contaCorrenteRepository;

    @Before
    public void setup(){
        contaCorrente = ContaCorrente.ContaCorrenteBuilder.aContaCorrente()
                .withNomeCorrentista("Correntista 100")
                .withNumeroConta(600)
                .withSaldo(new BigDecimal(542.34))
                .build();
    }

    @Test
    public void findContaCorrenteByNumeroConta() {
        when(contaCorrenteRepository.findContaCorrenteByNumeroConta(600)).thenReturn(contaCorrente);
        ContaCorrente contaCorrenteNova = contaCorrenteRepository.findContaCorrenteByNumeroConta(600);
        Assert.assertTrue(contaCorrente.equals(contaCorrenteNova));
    }
}