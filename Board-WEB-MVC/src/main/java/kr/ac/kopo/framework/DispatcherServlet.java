package kr.ac.kopo.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			mappings = new HandlerMapping();
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		
		/*
		 	/board/list.do   ==> new kr.ac.kopo.board.controller.BoardController().list()
		 	/board/detail.do ==> new kr.ac.kopo.board.controller.BoardController().detail()
		 	/login.do        ==> new kr.ac.kopo.member.controller.MemberController().login() 
		 */
		
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		//System.out.println("uri : " + uri);
		//System.out.println("/board/list.do:" +mappings.getCtrlAndMethod(uri));
		CtrlAndMethod cam =mappings.getCtrlAndMethod(uri);
		try {
		if(cam ==null) {
			throw new Exception("요청 url은 존재하지 않습니다 ");
		}
		Object target = cam.getTarget();
		Method method = cam.getMethod();
			method.invoke(target,request,response);
		}catch (Exception e) {
			response.setContentType("html/text; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
		
		}
		
			
	}

	
	
}









