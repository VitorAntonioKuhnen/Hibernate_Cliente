/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class ProdutoDaoImpl extends BaseDaoImpl<Produto, Long> implements ProdutoDao, Serializable {

    @Override
    public Produto askPerId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Produto.class, id);
    }

    @Override
    public List<Produto> askPerName(String nome, Session session) throws HibernateException {
        
        Query consulta = session.createQuery("from Produto p where p.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

}
