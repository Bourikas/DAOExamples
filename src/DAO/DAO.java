package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Generic DAO interface
 * @param <T>
 */
public interface DAO<T> {
    DTO.T get(int id) throws SQLException;

    List<DTO.T> getAll() throws SQLException;

    int save(DTO.T t) throws SQLException;

    int insert (DTO.T t) throws SQLException;

    int update(DTO.T t) throws SQLException;

    int delete(DTO.T t);
}
