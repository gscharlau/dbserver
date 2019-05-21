package com.desafio.api.service;

import com.desafio.api.entity.Lancamento;
import com.desafio.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public void registrarLancamento(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
    }
}
