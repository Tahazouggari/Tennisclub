package fr.ensicaen.tennis.servlet;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ("zouggari".equals(email) && "tennis".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email); // Store user info if needed

            // Redirect to the app homepage
            response.sendRedirect("http://localhost:8080/tennis/");
        } else {
            // Invalid login → back to login page
            request.setAttribute("error", "Invalid login");
            request.getRequestDispatcher("/Login.html").forward(request, response);
        }
    }
}

