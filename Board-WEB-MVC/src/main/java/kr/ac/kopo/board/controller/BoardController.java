package kr.ac.kopo.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.annotation.RequestMapping;

public class BoardController {

	
	@RequestMapping("/board/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "";
	}

	@RequestMapping("/board/writeForm.do")
	public String writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "";
	}
	
	@RequestMapping("/board/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "";
	}
	
	@RequestMapping("/board/detail.do")
	public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "";
	}
	
}
