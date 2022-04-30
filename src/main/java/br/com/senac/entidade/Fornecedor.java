/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vitor.kuhnen
 */ 
// nome, cnpj, inscrição estadual, e-mail e telefone. 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false, length = 120)
    private String nome;
    
    @Column (nullable = false, length = 18, unique = true)
    private String cnpj;
    
    @Column (nullable = false)
    private String inscricaoEstadual;
    
    @Column (nullable = false, length = 120, unique = true)
    private String email; 
    
    @Column (nullable = false, length = 11)
    private String telefone;
    
    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;
}
