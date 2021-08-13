package pojo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("session_id");
        System.out.println("before Logout:"+req.getSession().getAttribute("session_id"));
        if(id!=null){
            req.getSession().removeAttribute("session_id");
            System.out.println("after Logout:"+req.getSession().getAttribute("session_id"));
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }
}
