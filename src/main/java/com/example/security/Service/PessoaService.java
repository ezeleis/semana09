package com.example.security.Service;

import com.example.security.Entities.Pessoa;
import com.example.security.Entities.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}

