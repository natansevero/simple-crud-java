
package com.ifpb.simplecrudjava.controller;

import com.ifpb.simplecrudjava.interfaces.DaoPessoa;
import com.ifpb.simplecrudjava.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author natan
 */
public class DaoPessoaBanco implements DaoPessoa<Pessoa>{
    
    private String url;
    private String user;
    private String password;
    private Connection con;
    
    public DaoPessoaBanco() throws ClassNotFoundException, SQLException{
        url = "jdbc:postgres://localhost:5432/Cadastro";
        user = "postgres";
        password = "12345";
        con = ConFactory.getConnection(url, user, password);
    }

    @Override
    public boolean insert(Pessoa obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pessoa obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Pessoa obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa read(String cpf) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
