package servlet.basic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Dispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //dispatcher 到  /hello
        //转发与重定向  前者路径不变，后者路径变化
        this.getServletContext().getRequestDispatcher("/hello").forward(req, resp);
    }
}
