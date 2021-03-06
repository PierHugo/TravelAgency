package DAO;

import DAOinterface.UserDAOInterface;
import controller.Controller;
import model.Client;

import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO implements UserDAOInterface<Client, Integer>
{
    public Client findByLoginAndPassword(String login, String password)
    {
        Controller.beginTransaction();
        TypedQuery<Client> query = Controller.getSession().createQuery("FROM Client WHERE login = :login AND password = :password", Client.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<Client> clients = query.getResultList();
        Controller.commitTransaction();
        if (clients.size() == 0)
            return null;
        else
            return clients.get(0);
    }

    public boolean delete(Client entity)
    {
        try
        {
            Controller.beginTransaction();
            if (!Controller.getSession().contains(entity))
                Controller.getSession().merge(entity);
            Controller.getSession().delete(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAll()
    {
        Controller.beginTransaction();
        List<Client> clients = (List<Client>) Controller.getSession().createQuery("from Client").list();
        Controller.commitTransaction();
        return clients;
    }

    public boolean saveOrUpdate(Client entity)
    {
        try
        {
            Controller.beginTransaction();
            Controller.getSession().saveOrUpdate(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}