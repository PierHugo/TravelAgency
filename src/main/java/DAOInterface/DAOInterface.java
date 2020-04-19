package main.java.DAOInterface;

import java.util.List;

public interface DAOInterface<T>
{
    boolean delete(T entity);

    List<T> findAll();

    void deleteAll();

    boolean saveOrUpdate(T entity);
}
