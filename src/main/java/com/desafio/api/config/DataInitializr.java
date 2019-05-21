package com.desafio.api.config;

import com.desafio.api.entity.ContaCorrente;
import com.desafio.api.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<ContaCorrente> contaCorrenteList = contaCorrenteRepository.findAll();

        if(contaCorrenteList.isEmpty()){
            contaCorrenteRepository.save(adicionarCorrentista("Correntista 001", 100, new BigDecimal(100.00)));
            contaCorrenteRepository.save(adicionarCorrentista("Correntista 002", 200, new BigDecimal(130.00)));
            contaCorrenteRepository.save(adicionarCorrentista("Correntista 003", 300, new BigDecimal(400.00)));
            contaCorrenteRepository.save(adicionarCorrentista("Correntista 004", 400, new BigDecimal(BigInteger.ZERO)));

        }


    }

    private ContaCorrente adicionarCorrentista(String nome, Integer numeroConta, BigDecimal saldo){
        return ContaCorrente.ContaCorrenteBuilder.aContaCorrente()
                .withNumeroConta(numeroConta)
                .withNomeCorrentista(nome)
                .withSaldo(saldo)
                .build();
    }
}
