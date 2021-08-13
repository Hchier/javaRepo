import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionSet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username","裴");
        if(session.isNew()){
            resp.getWriter().println("session.isNew."+"session.id:"+session.getId());
        }
        else{
            resp.getWriter().println("session.isNotNew."+"session.id:"+session.getId());
        }
    }
}
