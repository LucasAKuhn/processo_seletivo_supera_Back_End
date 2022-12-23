package br.com.banco.repositories;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import org.springframework.data.domain.Page;
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

    @Query( value =
            "select '*' " +
                    "from Transferencia tr  " +
                    "WHERE tr.conta_id = :conta_id "
    )
    List<Transferencia> trazerTransferencias(@Param("conta_id") int conta_id);

    Optional<Transferencia> findById(BigInteger id);


    //"where conta_id = conta_id")
//    List<Transferencia> obterTransferencia(
//            @Param("id") Long conta_id
//    );

}
