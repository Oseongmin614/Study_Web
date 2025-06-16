package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	public List<BoardVO> listAllService() {
		return boardDao.selectBoardAll();
	}
	
	public BoardVO getBoardService(int boardNo) {
		
		return boardDao.selectBoardByNo(boardNo);
	}
	
	public void addBoardSerivce(BoardVO board) {
		boardDao.insertBoard(board);
	}
}
