package com.desafio.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ContaCorrente {
    @Id
    @Column(name = "NUMERO_CONTA")
    private Integer numeroConta;

    @Column(name = "NOME_CORRENTISTA")
    private String nomeCorrentista;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return getNumeroConta().equals(that.getNumeroConta()) &&
                getNomeCorrentista().equals(that.getNomeCorrentista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroConta(), getNomeCorrentista());
    }


    public static final class ContaCorrenteBuilder {
        private Integer numeroConta;
        private String nomeCorrentista;
        private BigDecimal saldo;

        private ContaCorrenteBuilder() {
        }

        public static ContaCorrenteBuilder aContaCorrente() {
            return new ContaCorrenteBuilder();
        }

        public ContaCorrenteBuilder withNumeroConta(Integer numeroConta) {
            this.numeroConta = numeroConta;
            return this;
        }

        public ContaCorrenteBuilder withNomeCorrentista(String nomeCorrentista) {
            this.nomeCorrentista = nomeCorrentista;
            return this;
        }

        public ContaCorrenteBuilder withSaldo(BigDecimal saldo) {
            this.saldo = saldo;
            return this;
        }

        public ContaCorrente build() {
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setNumeroConta(numeroConta);
            contaCorrente.setNomeCorrentista(nomeCorrentista);
            contaCorrente.setSaldo(saldo);
            return contaCorrente;
        }
    }
}
