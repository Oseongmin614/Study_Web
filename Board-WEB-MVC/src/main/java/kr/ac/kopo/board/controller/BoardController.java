package kr.ac.kopo.board.controller;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.ModelAndView;
import kr.ac.kopo.framework.annotation.RequestMapping;

public class BoardController {
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ServletContext sc = request.getServletContext();
		
		BoardDAO boardDao = (BoardDAO)sc.getAttribute("boardDAO");
		List<BoardVO> boardList = boardDao.selectBoardAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("boardList", boardList);
		mav.setView("/board/list.jsp");
		
		return mav;
	}

	@RequestMapping("/board/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("/board/writeForm.jsp");
		return mav;
	}
	
	@RequestMapping("/board/write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("write() 호출...");
		return null;
	}
	
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("detail() 호출...");
		return null;
	}
	
}
