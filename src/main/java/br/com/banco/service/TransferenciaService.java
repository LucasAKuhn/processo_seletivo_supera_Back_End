package br.com.banco.service;

import br.com.banco.entities.Transferencia;

import java.math.BigInteger;
import java.util.List;

public interface TransferenciaService {

    List<Transferencia> transferenciasObter(int conta_id);

}
