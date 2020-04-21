package servlet;

import manager.Manager;
import model.Client;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first name");
        String lastName = request.getParameter("last name");
        String city = request.getParameter("city");
        String dateOfBirth = request.getParameter("date of birth");

        if (login.equals("") || password.equals("") || firstName.equals("") || lastName.equals("") || city.equals("") || dateOfBirth.equals(""))
        {
            request.setAttribute("message", "Please fill in all required fields");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Client client = new Client();
        client.setCity(city);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setLogin(login);
        client.setPassword(DigestUtils.sha256Hex(password));
        client.setVote(false);

        {
            int year = Integer.parseInt(dateOfBirth.split("-")[0]);
            int month = Integer.parseInt(dateOfBirth.split("-")[1]);
            int day = Integer.parseInt(dateOfBirth.split("-")[2]);
        }

        boolean created = Manager.getClientDAO().saveOrUpdate(client);

        if (created)
        {
            request.setAttribute("registerSuccess", "Registration success, please sign in");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else
        {
            request.setAttribute("message", "Registration failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("message", "");
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }
}
