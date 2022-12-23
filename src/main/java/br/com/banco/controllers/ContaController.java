package br.com.banco.controllers;

import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
@RequiredArgsConstructor
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @PostMapping
    public ResponseEntity insert(@RequestBody Conta conta) {
        Conta entidade = conta;
        entidade = contaRepository.save(entidade);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping
    public List<Conta> findAll() {
        List<Conta> result = contaRepository.findAll();
        return result;
    }
}
