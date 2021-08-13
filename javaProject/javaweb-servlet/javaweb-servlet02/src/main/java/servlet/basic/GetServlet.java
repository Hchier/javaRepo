package servlet.basic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //不加，页面中文乱码
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter printWriter =resp.getWriter();
        printWriter.println("姓名："+servletContext.getAttribute("name"));
    }
}
