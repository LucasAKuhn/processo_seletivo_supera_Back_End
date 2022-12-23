//package br.com.banco.service;
//
//import br.com.banco.entities.Transferencia;
//import br.com.banco.repositories.TransferenciaRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class TransferenciaService {
//
//    @Autowired
//    TransferenciaRepository transferenciaRepository;
//
//    @Override
//    public List<Transferencia> transferenciasObter(Long conta_id) {
//        return transferenciaRepository.trazerTransferencias(conta_id);
//    }
//}
