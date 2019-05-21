package com.desafio.api.repository;

import com.desafio.api.entity.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

    ContaCorrente findContaCorrenteByNumeroConta(Integer numeroConta);

}
