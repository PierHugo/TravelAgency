package servlet;

import controller.Controller;
import model.Client;
import model.Employee;
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
            Employee employee;
            Client client = Controller.getClientDAO().findByLoginAndPassword(login, password);

            if (client == null)
            {
                employee = Controller.getEmployeeDAO().findByLoginAndPassword(login, password);
                if (employee != null)
                {
                    isFound = true;
                    type = "employee";
                }
            } else
            {
                isFound = true;
                type = "client";
            }

            if (isFound)
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("type", type);
                session.setAttribute("login", login);
                session.setAttribute("password", password);

                List<Offer> offerList = Controller.getOfferDAO().findAll();
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
            HttpSession session = request.getSession(false);
            if (session != null)
                session.invalidate();
            request.setAttribute("loginSuccess", "Logout success");
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
