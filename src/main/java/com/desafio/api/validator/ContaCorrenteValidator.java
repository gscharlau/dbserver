package com.desafio.api.validator;

import com.desafio.api.entity.ContaCorrente;
import com.desafio.api.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Service
public class ContaCorrenteValidator {

    @Autowired
    private ContaCorrenteService contaCorrenteService;


    public Boolean verificaExistenciaConta(@NotNull Integer numeroConta){
        ContaCorrente contaCorrente = contaCorrenteService.obterContaCorrentePorNumero(numeroConta);
        return contaCorrente != null;
    }

    public Boolean verificaSeExisteSaldo(@NotNull Integer numeroConta, @NotNull BigDecimal valorTransferencia){
        ContaCorrente contaCorrente = contaCorrenteService.obterContaCorrentePorNumero(numeroConta);

        return contaCorrente.getSaldo().subtract(valorTransferencia).compareTo(BigDecimal.ZERO) >= 0;

    }


}
