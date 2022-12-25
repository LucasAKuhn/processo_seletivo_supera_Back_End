package br.com.banco.service;

import br.com.banco.entities.Transferencia;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaService {

    List<Transferencia> transferenciasObter(int conta_id);

    //List<Transferencia> buscaComParametros(LocalDateTime startDate, LocalDateTime endDate);

}
