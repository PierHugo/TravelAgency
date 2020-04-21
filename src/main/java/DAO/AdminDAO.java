package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Admin;

import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDAO implements UserDAOInterface<Admin, Integer>
{

    public Admin findById(Integer id)
    {
        Manager.beginTransaction();
        Admin admin = Manager.getSession().find(Admin.class, id);
        Manager.commitTransaction();
        return admin;
    }

    public Admin findByLoginAndPassword(String login, String password)
    {
        Manager.beginTransaction();
        TypedQuery<Admin> query = Manager.getSession().createQuery("FROM Admin WHERE login = :login AND password = :password", Admin.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<Admin> admins = query.getResultList();
        Manager.commitTransaction();
        if (admins.size() == 0)
            return null;
        else
            return admins.get(0);
    }

    public boolean delete(Admin entity)
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
    public List<Admin> findAll()
    {
        Manager.beginTransaction();
        List<Admin> admins = (List<Admin>) Manager.getSession().createQuery("from Admin").list();
        Manager.commitTransaction();
        return admins;
    }

    public void deleteAll()
    {
        Manager.beginTransaction();
        for (Admin admin : findAll())
        {
            if (!Manager.getSession().contains(admin))
                Manager.getSession().merge(admin);
            Manager.getSession().delete(admin);
        }
        Manager.commitTransaction();
    }

    public boolean saveOrUpdate(Admin entity)
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
