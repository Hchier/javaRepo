package pojo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        if (username.equals("1") && password.equals("1")) {
            System.out.println("username,password:"+username+password);
            req.getSession().setAttribute("session_id",req.getSession().getId());
            System.out.println("Login success:"+req.getSession().getAttribute("session_id"));
            //System.out.println("after login to:"+this.getServletContext().getContextPath() + "/success.jsp");
            this.getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);


        } else {
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
