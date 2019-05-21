package com.desafio.api.controller;

import com.desafio.api.dto.TransferenciaRequest;
import com.desafio.api.service.ServicosBancariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/servicos")
@Validated
public class ServicosController {

    @Autowired
    private ServicosBancariosService servicosBancariosService;

    @RequestMapping(value = "/transferencia", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> efetuarTransferencia(@Valid @RequestBody TransferenciaRequest request) {
        servicosBancariosService.efetuarTransferencia(request.getContaOrigem(), request.getContaDestino(), request.getValor());
        return ResponseEntity.ok("Transação efetuada com sucesso");
    }


}
