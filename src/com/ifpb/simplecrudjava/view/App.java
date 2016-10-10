/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ifpb.simplecrudjava.view;

import com.ifpb.simplecrudjava.controller.DaoPessoaBanco;
import com.ifpb.simplecrudjava.interfaces.DaoPessoa;
import com.ifpb.simplecrudjava.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natan
 */
public class App {
    public static void main(String[] args) {
        DaoPessoa<Pessoa> dao;
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            dao = new DaoPessoaBanco();
            
            pessoas = dao.listAll();
        } catch(ClassNotFoundException | SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error No Banco", "Banco Fail", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        String[] titulos = {"CPF", "Nome", "Sexo", "Idade"};
        String[][] matriz = null;
        
        if(pessoas != null){
            matriz = new String[pessoas.size()][titulos.length];
            
            for(int i = 0; i< pessoas.size(); i++){
                Pessoa pessoa = pessoas.get(i);
                
                matriz[i][0] = pessoa.getCpf();
                matriz[i][1] = pessoa.getNome();
                matriz[i][2] = pessoa.getSexo();
                matriz[i][3] = ""+pessoa.getIdade();
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(matriz, titulos);
        
        Table t = new Table();
        t.alteraTable(model);
        t.setVisible(true);
            
    }
}
