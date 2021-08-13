import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class SessoinSet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        session.setAttribute("username","裴");
        if(session.isNew()){
            resp.getWriter().println("isNew."+"sessionID："+session.getId());
        }
        else{
            resp.getWriter().println("session已经创建."+"sessionID:"+session.getId());
        }

    }
}
