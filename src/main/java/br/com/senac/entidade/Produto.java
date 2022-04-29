/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author vitor.kuhnen
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table (name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn (name = "fkfornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column (nullable = false, length = 120)
    private String nome;
    
    @Column (nullable = false, length = 4)
    private int qtdEstoque;
    
    @Column (nullable = false, length = 20)
    private float preco;
}
