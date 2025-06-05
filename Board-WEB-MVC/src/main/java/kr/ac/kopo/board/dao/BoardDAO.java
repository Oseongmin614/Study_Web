package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

/**
 * DB와 ACCESS 하는 CRUD 
 * @author User
 */
public interface BoardDAO {

	/**
	 * 전체게시글 조회
	 * @return 조회된게시글(BoardVO) 목록
	 */
	List<BoardVO> selectBoardAll();
	
	/**
	 * 새글등록
	 * @param newBoard 등록될 게시글
	 */
	void insertBoard(BoardVO newBoard);
	
	/**
	 * 게시판번호로 게시글조회
	 * @param boardNo 조회할게시글번호
	 * @return 조회된 게시글(BoardVO) 단, 조회된 게시물이 없으면 null 반환
	 */
	BoardVO selectBoardByNo(int boardNo);
	
	/**
	 * 게시글 수정(1개 이상)
	 * @param board 수정할게시글
	 */
	void updateBoard(BoardVO board);
	
	/**
	 * 게시글 삭제
	 * @param boardNo 삭제할 게시글번호
	 */
	void deleteBoardByNo(int boardNo);
}
