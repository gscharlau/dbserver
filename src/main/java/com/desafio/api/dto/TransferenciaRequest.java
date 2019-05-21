package com.desafio.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

public class TransferenciaRequest implements Serializable {

    @NotNull(message = "Conta de Origem Obrigatória")
    @Positive
    Integer contaOrigem;

    @NotNull(message = "Conta de Destino Obrigatória")
    @Positive
    Integer contaDestino;

    @NotNull(message = "Valor da Transferência Obrigatório")
    BigDecimal valor;


    public TransferenciaRequest() {
    }

    public TransferenciaRequest(Integer contaOrigem, Integer contaDestino, BigDecimal valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public Integer getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Integer contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Integer getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public static final class TransferenciaRequestBuilder {
        Integer contaOrigem;
        Integer contaDestino;
        BigDecimal valor;

        private TransferenciaRequestBuilder() {
        }

        public static TransferenciaRequestBuilder aTransferenciaRequest() {
            return new TransferenciaRequestBuilder();
        }

        public TransferenciaRequestBuilder withContaOrigem(Integer contaOrigem) {
            this.contaOrigem = contaOrigem;
            return this;
        }

        public TransferenciaRequestBuilder withContaDestino(Integer contaDestino) {
            this.contaDestino = contaDestino;
            return this;
        }

        public TransferenciaRequestBuilder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public TransferenciaRequest build() {
            return new TransferenciaRequest(contaOrigem, contaDestino, valor);
        }
    }
}
