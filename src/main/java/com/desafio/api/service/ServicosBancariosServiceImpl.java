package com.desafio.api.service;

import com.desafio.api.entity.ContaCorrente;
import com.desafio.api.entity.Lancamento;
import com.desafio.api.validator.ContaCorrenteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ServicosBancariosServiceImpl implements ServicosBancariosService {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ContaCorrenteValidator contaCorrenteValidator;

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @Override
    public void efetuarTransferencia(Integer origem, Integer destino, BigDecimal valor) throws ResponseStatusException {
        validarDados(origem, destino, valor);
        efetivarLancamento(origem, destino, valor);
    }

    private void efetivarLancamento(Integer origem, Integer destino, BigDecimal valor) {
        ContaCorrente contaOrigem = contaCorrenteService.obterContaCorrentePorNumero(origem);
        ContaCorrente contaDestino = contaCorrenteService.obterContaCorrentePorNumero(destino);

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        contaCorrenteService.atualizarSaldoContaCorrente(contaOrigem);
        contaCorrenteService.atualizarSaldoContaCorrente(contaDestino);

        Lancamento lancamento = Lancamento.LancamentoBuilder.aLancamento()
                .withContaCorrenteOrigem(contaOrigem)
                .withContaCorrenteDestino(contaDestino)
                .withValor(valor)
                .withDataTransacao(new Date())
                .build();

        lancamentoService.registrarLancamento(lancamento);
    }

    private void validarDados(Integer origem, Integer destino, BigDecimal valor) {
        if (!contaCorrenteValidator.verificaExistenciaConta(destino)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta Origem Inválida");
        }

        if (!contaCorrenteValidator.verificaExistenciaConta(origem)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta Destino Inválida");
        }

        if (!contaCorrenteValidator.verificaSeExisteSaldo(origem, valor)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente");
        }
    }

}
