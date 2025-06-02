package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.dao.BoardDAOImpl;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardDAOTest {

	@Ignore
	@Test
	public void 상세게시글조회Test() throws Exception {
		
		BoardDAO dao = new BoardDAOImpl();
		// 4번 게시글 조회
		BoardVO board = dao.selectBoardByNo(3);
		
		assertNotNull(board);
		System.out.println(board);
		
	}
	
	@Test
	public void 전체게시글조회Test() throws Exception {
		
	}
}
