package fr.ensicaen.tennis.servlet;

import fr.ensicaen.tennis.persistence.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "InscriptionServlet", urlPatterns = "/service/inscription")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        AdherentEntity adherent = (AdherentEntity) session.getAttribute("adherent");

        if (adherent == null) {
            resp.sendRedirect("login.html");
            return;
        }

        String codeStr = req.getParameter("tournoi");


        if (codeStr == null || codeStr.isEmpty()) {
            // Affiche tous les tournois
            List<TournoiEntity> tournois = Database.getInstance().listTournois();
            req.setAttribute("tournois", tournois);
            req.getRequestDispatcher("/InscriptionTournois.jsp").forward(req, resp);
        } else {

                int codeTournoi = Integer.parseInt(codeStr);
                TournoiEntity tournoi = Database.getInstance().getTournoiById(codeTournoi);

                if (tournoi != null) {
                    boolean dejaInscrit = Database.getInstance()
                            .estDejaInscrit(adherent.getNumeroAdherent(), codeTournoi);

                    req.setAttribute("tournoi", tournoi);

                    if (dejaInscrit) {
                        req.setAttribute("dejaInscrit", true);
                    } else {
                        Database.getInstance().inscrireAdherent(adherent.getNumeroAdherent(), codeTournoi);
                    }

                    req.getRequestDispatcher("/InscriptionStatus.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error", "Tournoi introuvable.");
                    req.getRequestDispatcher("/InscriptionTournois.jsp").forward(req, resp);
                }
            Database.getInstance().inscrireAdherent(adherent.getNumeroAdherent(), codeTournoi);





        }
    }
}
