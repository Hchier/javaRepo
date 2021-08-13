package Listener;

import com.mysql.cj.Session;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");
        if(onlineNum==null) {
            onlineNum=(Integer)1;
        }
        else{
            onlineNum+=1;
        }
        servletContext.setAttribute("onlineNum",onlineNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
