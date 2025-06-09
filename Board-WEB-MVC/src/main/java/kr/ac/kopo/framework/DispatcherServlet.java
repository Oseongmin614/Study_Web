package kr.ac.kopo.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.do"},
			initParams = {@WebInitParam(name="controllers", 
										value="kr.ac.kopo.board.controller.BoardController"
												+ "|kr.ac.kopo.member.controller.MemberController")})
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String ctrlNames = config.getInitParameter("controllers");
//		System.out.println(ctrlNames);
		try {
			mappings = new HandlerMapping(ctrlNames);
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
//		System.out.println("uri : " + uri);
//		System.out.println(mappings.getCtrlAndMethod(uri));
		CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
		
		String view = "";
		try {
		
			if(cam == null) {
				throw new Exception("요청 URL은 존재하지 않습니다");
			}
			
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			
			ModelAndView mav = (ModelAndView)method.invoke(target, request, response);
			view = mav.getView();
			
			// 공유영역(request) 등록
			Map<String, Object> model = mav.getModel();
			Set<String> keys = model.keySet();
			for(String key : keys) {
				Object value = model.get(key);
				request.setAttribute(key, value);
			}
			
		} catch(Exception e) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
		}
		
		if(view.startsWith("redirect:")) {
			view = view.substring("redirect:".length());
			response.sendRedirect(request.getContextPath() + view);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	
	
}









