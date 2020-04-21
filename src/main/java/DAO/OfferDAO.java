package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Offer;

import java.util.List;

public class OfferDAO implements UserDAOInterface<Offer>
{
    @Override
    public boolean delete(Offer entity)
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public List<Offer> findAll()
    {
        Manager.beginTransaction();
        List<Offer> offers = (List<Offer>) Manager.getSession().createQuery("from Offer").list();
        Manager.commitTransaction();
        return offers;
    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public boolean saveOrUpdate(Offer entity)
    {
        return false;
    }

    @Override
    public Offer findByLoginAndPassword(String login, String password)
    {
        return null;
    }
}