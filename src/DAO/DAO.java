package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Generic DAO interface
 * @param <T>
 */
public interface DAO<T> {
    DTO.Employee get(int id) throws SQLException;

    List<DTO.Employee> getAll() throws SQLException;

    int save(DTO.Employee t) throws SQLException;

    int insert (DTO.Employee t) throws SQLException;

    int update(DTO.Employee t) throws SQLException;

    int delete(DTO.Employee t);
}
