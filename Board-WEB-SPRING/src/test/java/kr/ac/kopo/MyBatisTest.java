package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MyBatisTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate session;

	
	@Test
	public void 로그인테스트() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("user");
		member.setPassword("user");
		
		MemberVO userVO = session.selectOne("member.dao.MemberDAO.login", member);
		assertNotNull(userVO);
	}
	
	@Ignore
	@Test
	public void 전체게시글조회테스트() throws Exception {
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAllBoard");
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	@Ignore
	@Test
	public void sqlSession객체생성테스트() throws Exception {
		
		assertNotNull(session);
	}
	
	@Ignore
	@Test
	public void ds테스트() throws Exception {
		
		assertNotNull(ds);
		
	}
}
