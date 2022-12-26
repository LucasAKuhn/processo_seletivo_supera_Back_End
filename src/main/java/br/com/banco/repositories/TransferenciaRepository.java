package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    Optional<Transferencia> findById(BigInteger id);

    @Query(nativeQuery = true, value = "SELECT * FROM Transferencia WHERE conta_id = :id ")
    List<Transferencia> findAllTransferencia(@Param("id") Long id);


    @Query(nativeQuery = true, value =
            "SELECT * FROM " +
                    " Transferencia tr " +
                    "WHERE tr.data_transferencia " +
                    "BETWEEN :startDate " +
                    "AND :endDate ")
    List<Transferencia> findByParametroDatas(@Param("startDate") String startDate, @Param("endDate") String endDate);


    @Query(value =
    "SELECT tr FROM " +
            " Transferencia tr " +
            "WHERE tr.nome_operador_transacao = :nomeOperador")
    List<Transferencia> findByNomeOperador(@Param("nomeOperador") String nomeOperador);

    @Query(nativeQuery = true, value = "SELECT * FROM " +
            " Transferencia  " +
            "WHERE data_transferencia " +
            "BETWEEN :startDate " +
            "AND :endDate " +
            "AND nome_operador_transacao = :nomeOperador")
    List<Transferencia> findByDataENomeOperador(
                                                @Param("startDate") String startDate,
                                                @Param("endDate") String endDate,
                                                @Param("nomeOperador") String nomeOperador);

}
