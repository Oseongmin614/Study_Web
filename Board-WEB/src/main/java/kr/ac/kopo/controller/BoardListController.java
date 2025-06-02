package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.Controller;

public class BoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO boardDao = new BoardDAOImpl();
		
		List<BoardVO> boardList = boardDao.selectBoardAll();
		
		request.setAttribute("boardList", boardList);

		return "/board/list.jsp";
	}

	
}







