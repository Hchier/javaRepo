package servlet.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //resp.getWriter().println(username+" "+password);
        System.out.println("req.getContextPath()" + req.getContextPath());
        //重定向要加req.getContextPath()
        resp.sendRedirect(req.getContextPath() + "/success.jsp");
    }
}
