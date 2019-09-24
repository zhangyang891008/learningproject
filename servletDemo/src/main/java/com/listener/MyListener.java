package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Enumeration;

/**
 * 自定义Listener，打印初始化定义的参数
 *
 */
@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        System.out.println("--------start--------");
        while (initParameterNames.hasMoreElements()){
            String paramName = initParameterNames.nextElement();
            String paramValue = servletContext.getInitParameter(paramName);
            System.out.println(paramName+"--"+paramValue);
        }
        System.out.println("--------end--------");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
