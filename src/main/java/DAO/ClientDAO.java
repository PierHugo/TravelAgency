package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Client;

import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO implements UserDAOInterface<Client, Integer>
{
    public Client findById(Integer id)
    {
        Manager.beginTransaction();
        Client client = Manager.getSession().find(Client.class, id);
        Manager.commitTransaction();
        return client;
    }

    public Client findByLoginAndPassword(String login, String password)
    {
        Manager.beginTransaction();
        TypedQuery<Client> query = Manager.getSession().createQuery("FROM Client WHERE login = :login AND password = :password", Client.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<Client> clients = query.getResultList();
        Manager.commitTransaction();
        if (clients.size() == 0)
            return null;
        else
            return clients.get(0);
    }

    public boolean delete(Client entity)
    {
        try
        {
            Manager.beginTransaction();
            if (!Manager.getSession().contains(entity))
                Manager.getSession().merge(entity);
            Manager.getSession().delete(entity);
            Manager.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAll()
    {
        Manager.beginTransaction();
        List<Client> clients = (List<Client>) Manager.getSession().createQuery("from Client").list();
        Manager.commitTransaction();
        return clients;
    }

    public void deleteAll()
    {
        Manager.beginTransaction();
        for (Client client : findAll())
        {
            if (!Manager.getSession().contains(client))
                Manager.getSession().merge(client);
            Manager.getSession().delete(client);
        }
        Manager.commitTransaction();
    }

    public boolean saveOrUpdate(Client entity)
    {
        try
        {
            Manager.beginTransaction();
            Manager.getSession().saveOrUpdate(entity);
            Manager.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}