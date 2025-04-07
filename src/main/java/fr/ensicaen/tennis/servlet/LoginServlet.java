package fr.ensicaen.tennis.servlet;

import fr.ensicaen.tennis.persistence.AdherentEntity;
import fr.ensicaen.tennis.persistence.Database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AdherentEntity adherent = Database.getInstance().getAdherentByEmail(email);


        if (adherent != null && password.equals(adherent.getPassword())) {
            HttpSession session = req.getSession(true);
            session.setAttribute("adherent", adherent);
            session.setMaxInactiveInterval(5 * 60);
            req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Identifiants incorrects");
            req.getRequestDispatcher("/login.html").forward(req, resp); // assure-toi que ce fichier existe
        }

    }
}
