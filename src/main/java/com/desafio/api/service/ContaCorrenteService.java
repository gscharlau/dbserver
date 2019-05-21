package com.desafio.api.service;

import com.desafio.api.entity.ContaCorrente;

public interface ContaCorrenteService {

    ContaCorrente obterContaCorrentePorNumero(Integer numeroConta);

    void atualizarSaldoContaCorrente(ContaCorrente contaCorrente);

}
