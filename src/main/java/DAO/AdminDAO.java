package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Admin;

import java.util.List;

public class AdminDAO implements UserDAOInterface<Admin>
{
    @Override
    public boolean delete(Admin entity)
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public List<Admin> findAll()
    {
        Manager.beginTransaction();
        List<Admin> admins = (List<Admin>) Manager.getSession().createQuery("from Admin").list();
        Manager.commitTransaction();
        return admins;
    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public boolean saveOrUpdate(Admin entity)
    {
        return false;
    }

    @Override
    public Admin findByLoginAndPassword(String login, String password)
    {
        return null;
    }
}