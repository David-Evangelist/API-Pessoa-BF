package com.backend_framwors_dbpessoa.pessoa.controller;

import com.backend_framwors_dbpessoa.pessoa.dto.PessoaDto;
import com.backend_framwors_dbpessoa.pessoa.model.Pessoa;
import com.backend_framwors_dbpessoa.pessoa.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody PessoaDto pessoaDto) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);

        Pessoa savePessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(savePessoa);
    }

    public ResponseEntity<Object> getPessoaById(@PathVariable UUID id){
        Optional<Pessoa> foundPessoa = pessoaRepository.findById(id);
        if(foundPessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundPessoa.get());
    }

}
