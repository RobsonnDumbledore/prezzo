package br.com.noblesse.prezzo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Robson
 */
@Getter
@Setter
@Entity
@Table(name = "usuario")
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "campo obrigatório")
    private String nome;

    @Email(message = "email inválido")
    @NotEmpty(message = "campo obrigatório")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "campo obrigatório")
    private String senha;

    public Usuario() {
    }

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
