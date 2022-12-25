package br.com.banco.controllers;


import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import br.com.banco.service.imp.TransferenciaServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transferencia")
@RequiredArgsConstructor
public class TransferenciaController {



    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    TransferenciaServiceImp transferenciaServiceImp;

    @Autowired
    TransferenciaService transferenciaService;




    @GetMapping(value = "{id}")
    public ResponseEntity obterValores(@PathVariable int conta_id) {
        List<Transferencia> result = transferenciaServiceImp.transferenciasObter(conta_id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    public List<Transferencia> findAllT() {
        List<Transferencia> result = transferenciaRepository.findAll();
        return result;
    }

    @GetMapping(value = "/selecionar/{id}")
    public Optional<Transferencia> obterTransferenciaPorId(@PathVariable BigInteger id) {
        Optional<Transferencia> result = transferenciaRepository.findById(id);
        return result;
    }

    @GetMapping("/byTempo")
    public ResponseEntity obterTransferenciasPorParametroDeDatas(@Param("startDate") String startDate,
                                                                 @Param("endDate") String endDate){

        return ResponseEntity.ok().body(transferenciaServiceImp.obterTransferenciasPorData(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity inserirNovaTransferencia(@RequestBody Transferencia transferencia) {
        Transferencia entidade = transferencia;
        entidade = transferenciaRepository.save(entidade);
        return ResponseEntity.ok(entidade);
    }

}
