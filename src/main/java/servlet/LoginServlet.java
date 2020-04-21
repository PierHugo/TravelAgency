package servlet;

import manager.Manager;
import model.Admin;
import model.Client;
import model.Offer;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (!login.equals("") && !password.equals(""))
        {
            password = DigestUtils.sha256Hex(password);
            String type = "";
            boolean isFound = false;
            Admin admin;
            Client client = Manager.getClientDAO().findByLoginAndPassword(login, password);

            if (client == null)
            {
                admin = Manager.getAdminDAO().findByLoginAndPassword(login, password);
                if (admin != null)
                {
                    isFound = true;
                    type = "admin";
                }
            } else
            {
                isFound = true;
                type = "client";
            }

            if (isFound)
            {
                HttpSession session = request.getSession();
                session.setAttribute("type", type);
                session.setAttribute("login", login);
                session.setAttribute("password", password);

                List<Offer> offerList = Manager.getOfferDAO().findAll();
                if (offerList == null)
                    offerList = new ArrayList<>();

                request.setAttribute("offerList", offerList);

                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else
            {
                request.setAttribute("message", "Login credentials do not match any account");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } else
        {
            request.setAttribute("message", "Please fill in all fields");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type = request.getParameter("type");

        if (type != null)
        {
            HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("registerSuccess", "Logout success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else
        {
            request.setAttribute("message", "");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
