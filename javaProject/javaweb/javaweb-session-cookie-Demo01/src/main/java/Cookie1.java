import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Cookie1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        jakarta.servlet.http.Cookie[] cookies = req.getCookies();
        int flag = 1;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("username")) {
                //存在username，不是第一次访问
                flag = 0;
            }
        }
        if (flag == 1) {
            resp.getWriter().println("第一次访问");
            Cookie cookie = new Cookie("username", "裴");
            //活1秒后自动注销该cookie
            cookie.setMaxAge(1);
            resp.addCookie(cookie);
        } else {
            resp.getWriter().println("非第一次访问");
        }

    }
}
