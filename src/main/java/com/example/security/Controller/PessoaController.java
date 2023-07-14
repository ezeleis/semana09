package com.example.security.Controller;

import com.example.security.Entities.Pessoa;
import com.example.security.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//Nao requerido no Exercicio mas recomendavel
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.getPessoaById(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/active")
    public ResponseEntity<List <Pessoa>> getPessoaActive(){
        List<Pessoa> activePessoas= pessoaService.getPessoaActive();
        return ResponseEntity.ok(activePessoas);
    }

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa createdPessoa = pessoaService.createPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        Pessoa updatedPessoa = pessoaService.updatePessoa(pessoa);
        if (updatedPessoa != null) {
            return ResponseEntity.ok(updatedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Pessoa>> getPessoasByFilter(@RequestParam("filter") String filter) {
        List<Pessoa> pessoas = pessoaService.getPessoasByFilter(filter);
        return ResponseEntity.ok(pessoas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }
}

