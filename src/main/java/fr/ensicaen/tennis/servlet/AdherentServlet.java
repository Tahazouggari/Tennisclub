package fr.ensicaen.tennis.servlet;

import fr.ensicaen.tennis.persistence.AdherentEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "AdherentServlet", urlPatterns = "/service/adherent")
public class AdherentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        AdherentEntity adherent = (AdherentEntity) session.getAttribute("adherent");

        if (adherent == null) {
            response.sendRedirect("login.html");
            return;
        }

        request.setAttribute("adherent", adherent);
        request.getRequestDispatcher("/Adherent.jsp").forward(request, response);
    }
}
