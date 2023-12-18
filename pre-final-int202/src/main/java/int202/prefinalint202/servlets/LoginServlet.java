package int202.prefinalint202.servlets;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import int202.prefinalint202.entities.Customer;
import int202.prefinalint202.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/040/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        if (action.equalsIgnoreCase("logout")) {
            request.getSession().setAttribute("currentUser", null);
            response.sendRedirect("../index.jsp");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        CustomerRepository customerRepository = new CustomerRepository();
        Customer currentUser = customerRepository.findByUserName(userName);
        if (currentUser == null) {
            request.setAttribute("error", "wrong username");
            doGet(request, response);
        } else {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
            char[] passwordArray = password.toCharArray();
            if (argon2.verify(currentUser.getPassword(), passwordArray)) {
                request.getSession().setAttribute("currentUser", currentUser);
                response.sendRedirect("../index.jsp");
            } else {
                request.setAttribute("error", "wrong password");
                doGet(request, response);
            }
        }
    }
}
