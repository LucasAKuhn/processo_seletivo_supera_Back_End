package br.com.banco.service.imp;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaServiceImp {

    @Autowired
    TransferenciaRepository transferenciaRepository;


    public List<Transferencia> findAllByConta(Long conta_id){
        return transferenciaRepository.findAllTransferencia(conta_id);
    }

    public List<Transferencia> findAllByNomeOperador(String nome_operador_transacao){
        return transferenciaRepository.findByNomeOperador(nome_operador_transacao);
    }

    public List<Transferencia> findByDataENomeOperador(String nome_operador_transacao,
                                                       String startDate,
                                                       String endDate) {
        return transferenciaRepository.findByDataENomeOperador(nome_operador_transacao, startDate, endDate);
    }


    public List<Transferencia> findByTransferenciasPorData(String startDate, String endDate) {

        return transferenciaRepository.findByParametroDatas(startDate, endDate);
    }

}
