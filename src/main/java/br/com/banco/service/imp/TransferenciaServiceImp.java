package br.com.banco.service.imp;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Override
    public List<Transferencia> transferenciasObter(int conta_id) {
        return transferenciaRepository.trazerTransferencias(conta_id);
    }

    public List<Transferencia> obterTransferenciasPorData(String startDate, String endDate) {

        return transferenciaRepository.encontrarPorParametroDatas(startDate, endDate);
    }

}
