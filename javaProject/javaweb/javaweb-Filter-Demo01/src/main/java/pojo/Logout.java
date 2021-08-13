package pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("before remove:session_id:"+session.getAttribute("session_id"));
        session.removeAttribute("session_id");
        System.out.println("after remove:session_id:"+session.getAttribute("session_id"));
        resp.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");

    }
}
