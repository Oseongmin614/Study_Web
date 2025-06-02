package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.BoardListController;

public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new HandlerMapping();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			System.out.println("uri : " + uri);
			
			Controller control = mappings.getController(uri);			
			
			String callPage = control.handleRequest(request, response);
			
			// callPage의 jsp주소로 forward 수행
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

}













