package DAO;

import manager.Manager;
import model.Offer;

import java.util.List;

public class OfferDAO
{
    public boolean delete(Offer entity)
    {
        try
        {
            Manager.beginTransaction();
            if (!Manager.getSession().contains(entity))
                Manager.getSession().merge(entity);
            Manager.getSession().delete(entity);
            return true;
        } catch (Exception e)
        {
            return false;
        }
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
        Manager.beginTransaction();
        for (Offer p : findAll())
        {
            if (!Manager.getSession().contains(p))
                Manager.getSession().merge(p);
            Manager.getSession().delete(p);
        }
        Manager.commitTransaction();
    }

    public boolean saveOrUpdate(Offer entity) // TODO : ici le souci de Add
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

    public Offer findOfferByDestination(String destination)
    {
        Manager.beginTransaction();
        Offer offer = Manager.getSession().find(Offer.class, destination);
        Manager.commitTransaction();
        return offer;
    }

}