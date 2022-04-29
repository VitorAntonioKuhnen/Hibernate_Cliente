/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.entidade.Produto;
import br.com.senac.util.GeradorUtil;
import org.hibernate.Session;
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
    
//        @Test
    public void testSave() {
        fornecedor = new Fornecedor();
        System.out.println("Salvando");
        session = HibernateUtil.abrirConexao();
        fornecedor = session.find(Fornecedor.class, Long.valueOf("6"));
        produto = new Produto(null, fornecedor, "papel", 20, (float) 15.5);
        produtoDao.saveOrAlter(produto, session);
        session.close();
        assertNotNull(fornecedor.getId());
    }
    
    
    @Test
    public void testAskPerId(){
        System.out.println("Pesquisar por ID");
        session = HibernateUtil.abrirConexao();
        produto = session.find(Produto.class, Long.valueOf("1"));
        session.close();
        System.out.println(produto.getNome() + "\n" + produto.getQtdEstoque() + "   " + produto.getPreco());
    }
}
