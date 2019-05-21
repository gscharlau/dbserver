package com.desafio.api.service;

import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

public interface ServicosBancariosService {

    void efetuarTransferencia(Integer origem, Integer destino, BigDecimal valor) throws ResponseStatusException;
}
