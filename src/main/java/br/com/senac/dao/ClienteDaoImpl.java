/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Vítor
 */
public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao{

    @Override
    public Cliente askPerId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Cliente.class, id);
    }

}
