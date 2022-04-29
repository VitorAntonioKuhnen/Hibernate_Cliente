/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public class ProdutoDaoImpl extends BaseDaoImpl<Produto, Long> implements ProdutoDao{

    @Override
    public Produto askPerId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Produto.class, id);
    }
    
}
