package kr.ac.kopo.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.dao.MemberDAOImpl;
import kr.ac.kopo.member.service.MemberService;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("리스너 종료....");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("리스너 시작....");
		
		ServletContext sc = event.getServletContext();
		sc.setAttribute("boardDAO", new BoardDAOImpl());
		MemberDAO memberDao = new MemberDAOImpl();
		sc.setAttribute("memberService", new MemberService(memberDao));
	}

	
}










