package com.desafio.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ContaCorrente contaCorrenteOrigem;

    @OneToOne
    private ContaCorrente contaCorrenteDestino;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DATA_TRANSACAO")
    private Date dataTransacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContaCorrente getContaCorrenteOrigem() {
        return contaCorrenteOrigem;
    }

    public void setContaCorrenteOrigem(ContaCorrente contaCorrenteOrigem) {
        this.contaCorrenteOrigem = contaCorrenteOrigem;
    }

    public ContaCorrente getContaCorrenteDestino() {
        return contaCorrenteDestino;
    }

    public void setContaCorrenteDestino(ContaCorrente contaCorrenteDestino) {
        this.contaCorrenteDestino = contaCorrenteDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public static final class LancamentoBuilder {
        private Long id;
        private ContaCorrente contaCorrenteOrigem;
        private ContaCorrente contaCorrenteDestino;
        private BigDecimal valor;
        private Date dataTransacao;

        private LancamentoBuilder() {
        }

        public static LancamentoBuilder aLancamento() {
            return new LancamentoBuilder();
        }

        public LancamentoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public LancamentoBuilder withContaCorrenteOrigem(ContaCorrente contaCorrenteOrigem) {
            this.contaCorrenteOrigem = contaCorrenteOrigem;
            return this;
        }

        public LancamentoBuilder withContaCorrenteDestino(ContaCorrente contaCorrenteDestino) {
            this.contaCorrenteDestino = contaCorrenteDestino;
            return this;
        }

        public LancamentoBuilder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public LancamentoBuilder withDataTransacao(Date dataTransacao) {
            this.dataTransacao = dataTransacao;
            return this;
        }

        public Lancamento build() {
            Lancamento lancamento = new Lancamento();
            lancamento.setId(id);
            lancamento.setContaCorrenteOrigem(contaCorrenteOrigem);
            lancamento.setContaCorrenteDestino(contaCorrenteDestino);
            lancamento.setValor(valor);
            lancamento.setDataTransacao(dataTransacao);
            return lancamento;
        }
    }
}
