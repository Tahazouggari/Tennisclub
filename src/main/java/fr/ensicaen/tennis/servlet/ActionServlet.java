package fr.ensicaen.tennis.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ActionServlet", urlPatterns = "/action")
public class ActionServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		HttpSession session = req.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("adherent") != null);

		if (!isLoggedIn) {

			if ("L".equals(code)) {
				req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			} else {
				req.getRequestDispatcher("/login.html").forward(req, resp);
			}
			return;
		}

		switch (code) {
			case "A":
			req.getRequestDispatcher("/service/adherent").forward(req, resp);
			break;


			case "I":
				req.getRequestDispatcher("/service/inscription").forward(req, resp);
				break;
			case "menu":
				req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
				break;

			default:
				req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
				break;
		}
	}
}
