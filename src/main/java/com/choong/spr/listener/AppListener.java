package com.choong.spr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
/*   어플리케이션 영역에
appRoot 라는 attribute를 넣어놓고 쓰기 위해 listener를 만들 것 */
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        /* Application의 다른 이름이 servletContext */ 
    	ServletContext application = sce.getServletContext();
    	
    	application.setAttribute("appRoot", application.getContextPath());
    }
	
}
