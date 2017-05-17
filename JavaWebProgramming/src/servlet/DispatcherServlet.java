package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DispatcherServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		String name1 = config.getInitParameter("name1"); 
		String name2 = config.getInitParameter("name2");
		System.out.println(name1);
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("½ÇÇà");
	}
}
