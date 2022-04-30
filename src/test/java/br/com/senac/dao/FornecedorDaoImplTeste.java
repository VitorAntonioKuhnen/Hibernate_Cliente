/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author vitor.kuhnen
 */
public class FornecedorDaoImplTeste {

    private Fornecedor fornecedor;
    private FornecerdorDao fornecerdorDao;
    private Session session;
    private GeradorUtil geradorUtil;

    public FornecedorDaoImplTeste() {
        fornecerdorDao = new FornecedorDaoImpl();
    }
    
    @Test
    public void testSave() {
        System.out.println("Salvando");
        
        for (int i = 0; i < 1000; i++) {
            
        
        fornecedor = new Fornecedor(null, geradorUtil.gerarNome(), geradorUtil.gerarCnpj(),
                "Fornecedore autorizado pelo Governo!", geradorUtil.gerarNome() + "@gmail.com", 
                geradorUtil.gerarNumero(11));
        session = HibernateUtil.abrirConexao();
        fornecerdorDao.saveOrAlter(fornecedor, session);
        session.close();
        assertNotNull(fornecedor.getId());
        
        }
    }
    
    @Test
    public void testePesquisarPorNome(){
        System.out.println("pesquisarPorNome");
        buscarFornecedorBd();
        session = HibernateUtil.abrirConexao();
        List<Fornecedor> fornecedores = fornecerdorDao.pesquisarPorNome(fornecedor,getNome(), session);
        session.close();
        assertFalse(fornecedores.isEmpty());
    }
    
    
    public Fornecedor buscarFornecedorBd(){
        String hql = "FROM Fornecedor f";
        session = HibernateUtil.abrirConexao();
        Query<Fornecedor> consulta = session.createQuery(hql);
        List<Fornecedor> fornecedores = consulta.getResultList();
        session.close();
        if(fornecedores.isEmpty()){
            testSave();
            
        }else{
            fornecedor = fornecedores.get(0);
        }
        return fornecedor;
    }
//    @Test
    public void testAskPerId(){
        System.out.println("Pesquisar por ID");
        session = HibernateUtil.abrirConexao();
        fornecedor = session.find(Fornecedor.class, Long.valueOf(""));
        session.close();
        System.out.println(fornecedor.getNome() + "\n" + fornecedor.getEmail() + "\n" + fornecedor.getCnpj());
    }
    
}
