package int202.prefinalint202.servlets;

import int202.prefinalint202.repositories.OfficeRepositoy;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OfficeServlet", value = "/040/office")
public class OfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepositoy officeRepositoy = new OfficeRepositoy();
        request.setAttribute("officeList", officeRepositoy.findAll());
        request.getRequestDispatcher("/office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
