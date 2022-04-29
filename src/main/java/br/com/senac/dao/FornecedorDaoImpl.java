/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vitor.kuhnen
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecerdorDao{

    @Override
    public Fornecedor askPerId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Fornecedor.class, id);
    }
    
}
