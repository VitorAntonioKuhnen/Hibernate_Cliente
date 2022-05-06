/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vitor.kuhnen
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable {

    @Override
    public Fornecedor askPerId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Fornecedor.class, id);
    }
    @Override
    public List<Fornecedor> askPerName(String nome, Session session) throws HibernateException {
        Query<Fornecedor> consulta = session.createQuery("from Fornecedor f where f.nome like :nomeHql");
        consulta.setParameter("nomeHql", "%" + nome + "%");
        return consulta.getResultList();
    }
}
