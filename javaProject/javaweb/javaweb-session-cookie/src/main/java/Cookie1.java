import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Cookie1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Cookie[] cookies = req.getCookies();
        int flag = 0;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("username")) {

                flag = 1;
                break;
            }
        }
        System.out.println("flag:" + flag);
        //第一次访问
        if (flag == 0) {
            resp.getWriter().println("first");
        } else {
            String username = null;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("username")) {
                    username = cookies[i].getValue();
                    resp.getWriter().println(username);
                    break;
                }
            }
        }
        Cookie cookie = new Cookie("username:", "裴");
        //cookie活1秒
        cookie.setMaxAge(1);
        resp.addCookie(cookie);

    }
}
