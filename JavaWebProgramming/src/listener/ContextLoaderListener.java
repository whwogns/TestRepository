package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent arg0) {  //deploy �Ҷ� ����
		System.out.println("contextInitialized");
		String key1 = arg0.getServletContext().getInitParameter("key1");
		System.out.println(key1);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {   //undeploy �Ҷ� ����
		System.out.println("contextDestroyed");
	}
	
}
