/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import org.hibernate.*;
/**
 *
 * @author Vítor
 * @param <T>
 * @param <ID>
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{

    private Transaction transaction;
    
    @Override
    public void saveOrAlter(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.saveOrUpdate(entidade);
        transaction.commit();
    }

    @Override
    public void delete(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.delete(entidade);
        transaction.commit(); 
    }
     
}
