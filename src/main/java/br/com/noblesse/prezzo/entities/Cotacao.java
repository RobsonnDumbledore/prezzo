package br.com.noblesse.prezzo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Robson
 */
@Getter
@Setter
@Entity
@Table(name = "cotacao")
@NoArgsConstructor
@AllArgsConstructor
public class Cotacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeEmpresa;
    private String nomeProduto;
    private Float preco;

}
