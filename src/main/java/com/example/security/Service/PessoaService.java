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


    public List<Pessoa> getPessoaActive() {
        return pessoaRepository.findAllByStatus(true);
    }

    public Pessoa updatePessoa(Pessoa pessoa) {
        Long id = pessoa.getId();
        if (id != null && pessoaRepository.existsById(id)) {
            return pessoaRepository.save(pessoa);
        }
        return null;
    }
    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> getPessoasByFilter(String filter) {
        return pessoaRepository.findByFilter(filter);
    }
}

