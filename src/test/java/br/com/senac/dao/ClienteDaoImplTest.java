/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.util.GeradorUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vítor
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session session;
    private GeradorUtil geradorUtil;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
        
    }

    @Test
    public void testSave() {
        System.out.println("Save");
        cliente = new Cliente(null, geradorUtil.gerarNome(), "aassd@gmail.com", "12345678910", "1237894");
        session = HibernateUtil.abrirConexao();
        clienteDao.saveOrAlter(cliente, session);
        session.close();
        assertNotNull(cliente.getId());

    }
    
//    @Test
    public void testDelete() {
        System.out.println("Delete");

        cliente = buscarCliente();
        session = HibernateUtil.abrirConexao();
        clienteDao.delete(cliente, session);
        session.close();
        Cliente clienteExcluido = session.find(Cliente.class, cliente.getId());
        assertNull(clienteExcluido);
    }

//    @Test
    public void testAskPerId() {
        System.out.println("askPerId");
//        cliente.setId(1);
        session = HibernateUtil.abrirConexao();
        cliente = session.find(Cliente.class, Long.valueOf("1"));
        session.close();
        JOptionPane.showMessageDialog(null, cliente.getEmail());
        System.out.println(cliente.getNome());
    }
    
    private Cliente buscarCliente(){
        cliente = new Cliente(null, "AqweAS", "sdfsdqweasf@fgds", "09160545941", "3443121");
        session = HibernateUtil.abrirConexao();
        clienteDao.askPerId(Long.valueOf(1), session);
        session.close();
        return cliente;
    }

}
