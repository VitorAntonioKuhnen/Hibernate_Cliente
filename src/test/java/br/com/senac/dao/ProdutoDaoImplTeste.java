/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.entidade.Produto;
import br.com.senac.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author vitor.kuhnen
 */
public class ProdutoDaoImplTeste {

    private Produto produto;
    private ProdutoDao produtoDao;
    private Session session;
    private GeradorUtil geradorUtil;
    private Fornecedor fornecedor;

    public ProdutoDaoImplTeste() {
        produtoDao = new ProdutoDaoImpl();
    }

//    @Test
    public void testSave() {

        System.out.println("Salvando");
        session = HibernateUtil.abrirConexao();

        produto = new Produto(null, fornecedor, "papel", 20, (float) 15.5);
        FornecedorDaoImplTeste fdit = new FornecedorDaoImplTeste();
        Fornecedor fornecedor = fdit.buscarFornecedorBd();
        produto.setFornecedor(fornecedor);
        produtoDao.saveOrAlter(produto, session);
        session.close();
        assertNotNull(fornecedor.getId());
    }
    @Test
    public void testAlter() {
        System.out.println("testAlter");
        buscarProdutoBd();
        produto.setNome("Produto alterado");
        session = HibernateUtil.abrirConexao();
        produtoDao.saveOrAlter(produto, session);
        session.close();
        
        session = HibernateUtil.abrirConexao();
        Produto produtoAlt = produtoDao.askPerId(produto.getId(), session);
        session.close();
        assertEquals(produto.getNome(), produtoAlt.getNome());
    }
    //    @Test
    public void testAskPerName() {
        System.out.println("testAskPerName");
    }

//    @Test
    public void testAskPerId() {
        System.out.println("Pesquisar por ID");
        session = HibernateUtil.abrirConexao();
        produto = session.find(Produto.class, Long.valueOf("1"));
        session.close();
        System.out.println(produto.getNome() + "\n" + produto.getQtdEstoque() + "   " + produto.getPreco());
    }

    public Produto buscarProdutoBd() {
        session = HibernateUtil.abrirConexao();
        Query consulta = session.createQuery("from Produto");
        
        List<Produto> produtos = consulta.getResultList();
        if (produtos.isEmpty()) {
            testSave();
        } else {
            produto = produtos.get(0);
        }
        session.close();
        return produto;
    }
}
