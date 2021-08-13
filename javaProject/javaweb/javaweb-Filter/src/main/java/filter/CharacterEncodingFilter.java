package filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //放行。否则一直卡这儿
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
