package main.java.DAOInterface;

public interface UserDAOInterface<T> extends DAOInterface<T>
{
    T findByLoginAndPassword(String login, String password);

}
