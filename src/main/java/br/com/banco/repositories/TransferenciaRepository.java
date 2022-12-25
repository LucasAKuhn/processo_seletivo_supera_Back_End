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


    //select * from transferencia where CONTA_ID = 1
    //select * from conta


    @Query(value =
            "select '*' " +
                    "from Transferencia tr  " +
                    "WHERE tr.conta_id = :conta_id "
    )
    List<Transferencia> trazerTransferencias(@Param("conta_id") int conta_id);

    Optional<Transferencia> findById(BigInteger id);


    //SELECT * FROMT transferencia WHERE data_transferencia BETWEEN 2019-01-01 12:00:00+03 and 2019-05-04 08:12:45+03
    //BUSCA COM PARAMETRO DE DATAS
//    @Query(value =
//    "SELECT '*' " +
//            "FROM Transferencia tr " +
//            "WHERE tr.data_transferencia " +
//            "BETWEEN :startDate " +
//            "AND :endDate ")
//    List<Transferencia> getTransferenciaPorIntervaloDeDatas(
//            @Param("startDate")LocalDateTime startDate,
//            @Param("endDate")LocalDateTime endDate
//            );
//
//}


    @Query(nativeQuery = true, value =
            "SELECT * FROM " +
                    " Transferencia tr " +
                    "WHERE tr.data_transferencia " +
                    "BETWEEN :startDate " +
                    "AND :endDate ")
    List<Transferencia> encontrarPorParametroDatas(@Param("startDate") String startDate, @Param("endDate") String endDate);

}