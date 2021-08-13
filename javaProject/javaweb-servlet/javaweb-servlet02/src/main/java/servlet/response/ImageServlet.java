package servlet.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//验证码
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器5s刷新一次
        resp.setHeader("refresh", "2");
        //在内存中创建图片
        BufferedImage bufferedImage = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();//笔
        //设置图片背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 200, 50);
        //给图片写数据
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(getRandom(), 20, 20);
        //告诉浏览器这图请求图片方式打开
        resp.setContentType("image/png");
        //网站存在缓存,使其不缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //把图片写给浏览器
        ImageIO.write(bufferedImage, "png", resp.getOutputStream());
    }

    //生成随机数
    String getRandom() {
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6 - num.length(); i++) {
            sb.append((0));
        }
        num = sb.toString() + num;
        return num;
    }
}
