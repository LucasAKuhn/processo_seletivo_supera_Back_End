package br.com.banco.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "conta")
@Data
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id_conta;

    private String nome_responsavel;

}
