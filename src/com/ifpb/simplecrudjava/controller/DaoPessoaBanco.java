
package com.ifpb.simplecrudjava.controller;

import com.ifpb.simplecrudjava.interfaces.DaoPessoa;
import com.ifpb.simplecrudjava.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        url = "jdbc:postgresql://localhost:5432/Cadastro";
        user = "postgres";
        password = "12345";
        con = ConFactory.getConnection(url, user, password);
    }

    @Override
    public boolean insert(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = con.prepareStatement("insert into pessoa values(?, ?, ?, ?)");
        stmt.setString(1, pessoa.getCpf());
        stmt.setString(2, pessoa.getNome());
        stmt.setString(3, pessoa.getSexo());
        stmt.setInt(4, pessoa.getIdade());
       
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean update(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = con.prepareStatement("update pessoa set nome=?, sexo=?, idade=? where cpf=?");
        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getSexo());
        stmt.setInt(3, pessoa.getIdade());
        
        stmt.setString(4, pessoa.getCpf());
       
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean delete(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = con.prepareStatement("delete from pessoa where cpf=?");
        stmt.setString(1, pessoa.getCpf());
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public List<Pessoa> listAll() throws ClassNotFoundException, SQLException { 
        PreparedStatement stmt = con.prepareStatement("select * from pessoa");
        
        ResultSet rs = stmt.executeQuery();
        
        List<Pessoa> pessoas = new ArrayList<>();
        while(rs.next()){
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf(rs.getString(1));
            pessoa.setNome(rs.getString(2));
            pessoa.setSexo(rs.getString(3));
            pessoa.setIdade(rs.getInt(4));
            
            pessoas.add(pessoa);
        }
        
        return pessoas;
    }

    @Override
    public Pessoa read(String cpf) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from pessoa where cpf = ?");
        stmt.setString(1, cpf);
        
        ResultSet rs = stmt.executeQuery();
        
        Pessoa pessoa = new Pessoa();
        while(rs.next()){
            pessoa.setCpf(rs.getString(1));
            pessoa.setNome(rs.getString(2));
            pessoa.setSexo(rs.getString(3));
            pessoa.setIdade(rs.getInt(4));
        }
        
        return pessoa;
    }
    
}
