package servlet;

import manager.Manager;
import model.Offer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OfferServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String option = request.getParameter("Offer");
        switch (option)
        {
            case "add":
            case "editing":
                addOffer(request, response);
                break;
            case "edit":
                editOffer(request, response);
                break;
            case "delete":
                deleteOffer(request, response);
                break;
            default:
            {
                request.setAttribute("errorMessage", "The parameter to add/edit/delete has been modified");
                RequestDispatcher dispatcher = request.getRequestDispatcher(option + "Offer.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Offer> offerList = Manager.getOfferDAO().findAll();
        if (offerList == null)
            offerList = new ArrayList<>();
        request.setAttribute("offerList", offerList);

        String option = request.getParameter("Offer");

        if (option.equals("editing"))
        {
            request.setAttribute("option", "editing");
            editOffer(request, response);
            return;
        }
        request.setAttribute("option", "add");

        RequestDispatcher dispatcher = request.getRequestDispatcher(option + "Offer.jsp");
        dispatcher.forward(request, response);
    }

    private void addOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String option = request.getParameter("Offer");
        String destination;
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String mustsees = request.getParameter("mustsees");
        String activities = request.getParameter("activities");
        String slots = request.getParameter("slots");

        String oldDestination = request.getParameter("destination");

        if (option.equals("editing"))
        {
            destination = request.getParameter("destinationEdit");
            if (destination.equals("") || description.equals("") || price.equals("") || mustsees.equals("") || activities.equals("") || slots.equals(""))
            {
                request.setAttribute("errorMessage", "Please fill in all fields");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } else
        {
            destination = request.getParameter("destinationAdd");
            if (destination.equals("") || description.equals("") || price.equals("") || mustsees.equals("") || activities.equals("") || slots.equals(""))
            {
                request.setAttribute("errorMessage", "Please fill in all fields");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        Offer offer;
        if (option.equals("add"))
        {
            offer = new Offer();
        } else
        {
            offer = Manager.getOfferDAO().findOfferByDestination(oldDestination);
        }
        offer.setDestination(destination);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setMustsees(mustsees);
        offer.setActivities(activities);
        offer.setSlots(slots);

        boolean created = Manager.getOfferDAO().saveOrUpdate(offer);

        if (created && option.equals("add"))
        {
            request.setAttribute("successMessage", "Add success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
            dispatcher.forward(request, response);
        } else if (created && option.equals("editing"))
        {
            List<Offer> offerList = Manager.getOfferDAO().findAll();
            if (offerList == null)
                offerList = new ArrayList<>();
            request.setAttribute("offerList", offerList);

            request.setAttribute("successMessage", "Edit success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("editOffer.jsp");
            dispatcher.forward(request, response);
        } else if (option.equals("add"))
        {
            request.setAttribute("errorMessage", "Add fail");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
            dispatcher.forward(request, response);
        } else
        {
            request.setAttribute("errorMessage", "Edit fail");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void editOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String destination = request.getParameter("destination");

        if (destination == null)
        {

            List<Offer> offerList = Manager.getOfferDAO().findAll();
            if (offerList == null)
                offerList = new ArrayList<>();
            request.setAttribute("offerList", offerList);

            request.setAttribute("errorMessage", "Nothing to edit");
            RequestDispatcher dispatcher = request.getRequestDispatcher("editOffer.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Offer offer = Manager.getOfferDAO().findOfferByDestination(destination);
        request.setAttribute("destination", offer.getDestination());
        request.setAttribute("destination", offer.getDestination());
        RequestDispatcher dispatcher = request.getRequestDispatcher("addOffer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String option = request.getParameter("Offer");
        String destination = request.getParameter("destination");

        if (destination == null)
        {
            request.setAttribute("errorMessage", "Nothing to delete");

            List<Offer> offerList = Manager.getOfferDAO().findAll();
            if (offerList == null)
                offerList = new ArrayList<>();
            request.setAttribute("offerList", offerList);

            RequestDispatcher dispatcher = request.getRequestDispatcher(option + "Offer.jsp");
            dispatcher.forward(request, response);
            return;
        }

        boolean deleted = Manager.getOfferDAO().delete(Manager.getOfferDAO().findOfferByDestination(destination));

        List<Offer> offerList = Manager.getOfferDAO().findAll();
        if (offerList == null)
            offerList = new ArrayList<>();
        request.setAttribute("offerList", offerList);

        if (deleted)
        {
            request.setAttribute("successMessage", "Delete success");
            RequestDispatcher dispatcher = request.getRequestDispatcher(option + "Offer.jsp");
            dispatcher.forward(request, response);
        } else
        {
            request.setAttribute("errorMessage", "Delete fail");
            RequestDispatcher dispatcher = request.getRequestDispatcher(option + "Offer.jsp");
            dispatcher.forward(request, response);
        }
    }
}
