

package com.ifpb.simplecrudjava.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author natan
 */
public interface DaoPessoa<T> {
    public boolean insert(T obj) throws ClassNotFoundException, SQLException;
    public boolean update(T obj) throws ClassNotFoundException, SQLException;
    public boolean delete(T obj) throws ClassNotFoundException, SQLException;
    public List<T> listAll() throws ClassNotFoundException, SQLException;
    public T read(String cpf) throws ClassNotFoundException, SQLException;
}
