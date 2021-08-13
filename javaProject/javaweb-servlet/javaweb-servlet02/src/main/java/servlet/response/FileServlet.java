package servlet.response;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        下载文件
//      1. 要获取下载文件的路径
        String path = "E:\\Hchier\\javaProject\\javaweb-servlet\\javaweb-servlet02\\target\\javaweb-servlet02-1.0-SNAPSHOT\\WEB-INF\\classes\\叉.png";
//      2. 下载的文件名是啥？
        String filename = path.substring(path.lastIndexOf("//") + 1);
//      3. 设置想办法让浏览器能够支持下载我们需要的东西
//        resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(filename));

        resp.setHeader("Content-disposition", "attachment;filename" + URLEncoder.encode(filename, "UTF-8"));
        //resp.setHeader("Content-disposition", "attachment;filename" + filename);
//      4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(path);

//      5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//      6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
//      7. 将FileOutputStream流写入到buffer缓冲区
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
//      8. 使用OutputStream将缓冲区中的数据输出到客户端！
    }
}