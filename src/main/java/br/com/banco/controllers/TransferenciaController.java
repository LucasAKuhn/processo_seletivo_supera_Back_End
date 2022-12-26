package br.com.banco.controllers;


import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.imp.TransferenciaServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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



    @GetMapping
    public List<Transferencia> findAllT() {
        List<Transferencia> result = transferenciaRepository.findAll();
        return result;
    }

    @GetMapping(value = "/selecionar/{id}")
    public Optional<Transferencia> findTransferenciaPorId(@PathVariable BigInteger id) {
        Optional<Transferencia> result = transferenciaRepository.findById(id);
        return result;
    }




    @GetMapping("/byTempo")
    public ResponseEntity findTransferenciasPorParametroDeDatas(@Param("startDate") String startDate,
                                                                @Param("endDate") String endDate){

        return ResponseEntity.ok().body(transferenciaServiceImp.findByTransferenciasPorData(startDate, endDate));
    }

    @GetMapping("/byContaId")
    public ResponseEntity findAllByContaId(@Param("id") Long conta_id){

        return ResponseEntity.ok().body(transferenciaServiceImp.findAllByConta(conta_id));
    }

    @GetMapping("/ByOperadorTransacao")
    public ResponseEntity findAllByOperadorTransacao(@Param("nomeOperador") String nome_operador_transacao ) {

        return ResponseEntity.ok().body(transferenciaServiceImp.findAllByNomeOperador(nome_operador_transacao));
    }

    @GetMapping("/ByTodosOsFiltros")
    public ResponseEntity findByTodosOsFiltros(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("nomeOperador") String nome_operador_transacao) {

        return ResponseEntity.ok().body(transferenciaServiceImp.findByDataENomeOperador(
                startDate,
                endDate,
                nome_operador_transacao));

    }




//    @PostMapping
//    public ResponseEntity inserirNovaTransferencia(@RequestBody Transferencia transferencia) {
//
//        transferencia.setData_transferencia(transferencia.getData_transferencia());
//        transferencia.setValor(transferencia.getValor());
//        transferencia.setTipo(transferencia.getTipo());
//        transferencia.setNome_operador_transacao(transferencia.getNome_operador_transacao());
//
//        Object conta = contaRepository
//                .findById(transferencia.getConta_id())
//                .orElseThrow( () -> new RegraNegocioException("não encontrado"));
//
//        transferencia.setConta_id(transferencia.getConta_id());
//
//        return ResponseEntity.ok(transferencia);
//
////        Transferencia entidade = transferencia;
////        entidade = transferenciaRepository.save(entidade);
////        return ResponseEntity.ok(entidade);
//    }

}
