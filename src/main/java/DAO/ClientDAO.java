package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Client;

import java.util.List;

public class ClientDAO implements UserDAOInterface<Client>
{
    @Override
    public boolean delete(Client entity)
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAll()
    {
        Manager.beginTransaction();
        List<Client> clients = (List<Client>) Manager.getSession().createQuery("from Client ").list();
        Manager.commitTransaction();
        return clients;
    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public boolean saveOrUpdate(Client entity)
    {
        return false;
    }

    @Override
    public Client findByLoginAndPassword(String login, String password)
    {
        return null;
    }
}