package pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("1") && password.equals("1")) {
            HttpSession session = req.getSession();
            session.setAttribute("session_id", session.getId());
            System.out.println("登录成功:session_id:" + session.getId());
            resp.sendRedirect(this.getServletContext().getContextPath() + "/filter/success.jsp");
        } else {
            resp.sendRedirect(this.getServletContext().getContextPath()+"/fail.jsp");
        }
    }
}
