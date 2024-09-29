package com.backend_framwors_dbpessoa.pessoa.repository;

import com.backend_framwors_dbpessoa.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}
