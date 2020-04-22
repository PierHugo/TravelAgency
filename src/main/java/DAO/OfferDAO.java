package DAO;

import controller.Controller;
import model.Offer;

import java.util.List;

public class OfferDAO
{
    public boolean delete(Offer entity)
    {
        try
        {
            Controller.beginTransaction();
            if (!Controller.getSession().contains(entity))
                Controller.getSession().merge(entity);
            Controller.getSession().delete(entity);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Offer> findAll()
    {
        Controller.beginTransaction();
        List<Offer> offers = (List<Offer>) Controller.getSession().createQuery("from Offer").list();
        Controller.commitTransaction();
        return offers;
    }

    public boolean saveOrUpdate(Offer entity)
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

    public Offer findOfferByDestination(String destination)
    {
        Controller.beginTransaction();
        Offer offer = Controller.getSession().find(Offer.class, destination);
        Controller.commitTransaction();
        return offer;
    }

}