package com.desafio.api.service;

import com.desafio.api.entity.ContaCorrente;
import com.desafio.api.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;


    @Override
    public ContaCorrente obterContaCorrentePorNumero(@NotNull Integer numeroConta) {

        return contaCorrenteRepository.findContaCorrenteByNumeroConta(numeroConta);

    }

    @Override
    public void atualizarSaldoContaCorrente(@NotNull ContaCorrente contaCorrente) {
        contaCorrenteRepository.save(contaCorrente);
    }


}
