package DAO;

import manager.Manager;
import model.Offer;

import java.util.List;

public class OfferDAO
{
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

    public void deleteAll()
    {

    }

    public boolean saveOrUpdate(Offer entity)
    {
        return false;
    }

}