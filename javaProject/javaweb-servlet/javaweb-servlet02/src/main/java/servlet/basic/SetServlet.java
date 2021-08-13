package servlet.basic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter();    //初始化参数
//        this.getServletConfig();    //配置
        //ServletContext管理所有servlet，servlet之间的通信、数据传递通过它实现

        ServletContext servletContext = this.getServletContext();   // 上下文
        String name="Hchier";
        servletContext.setAttribute("name", name);

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
