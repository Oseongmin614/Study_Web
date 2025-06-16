package kr.ac.kopo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class BoardDAOTest {

	@Autowired
	BoardDAO boardDao;
	
	@Ignore
	@Test
	public void 상세게시글조회테스트() throws Exception {
		BoardVO board = boardDao.selectBoardByNo(10);
		System.out.println(board);
	}
	
	@Ignore
	@Test
	public void 전체게시글조회테스트() throws Exception {
		List<BoardVO> list = boardDao.selectBoardAll();
		assertEquals(list.size(), 16);
	}
	
	@Test
	public void 새글등록테스트() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("spring form 테스트");
		board.setWriter("테스트");
		board.setContent("입력해봅니다");
	}
	
	
	
	
	
	
}
