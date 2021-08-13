package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //两个名字不能一样
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("LoginFilter:" + req.getSession().getAttribute("session_id"));
        if (req.getSession().getAttribute("session_id") == null) {
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
            //req.getServletContext().getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
