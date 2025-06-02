package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;

public class BoardDAOImpl implements BoardDAO {

    @Override
    public List<BoardVO> selectBoardAll() {
        List<BoardVO> boardList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT no, title, writer, to_char(reg_date, 'yyyy-mm-dd') reg_date ");
        sql.append(" FROM tbl_board ");
        sql.append(" ORDER BY no DESC ");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int no = rs.getInt("no");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String regDate = rs.getString("reg_date");
                BoardVO board = new BoardVO(no, title, writer, regDate);
                boardList.add(board);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

    @Override
    public void insertBoard(BoardVO newBoard) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tbl_board(no, title, writer, content) ");
        sql.append("VALUES (seq_tbl_board_no.nextval, ?, ?, ?)");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setString(1, newBoard.getTitle());
            pstmt.setString(2, newBoard.getWriter());
            pstmt.setString(3, newBoard.getContent());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BoardVO selectBoardByNo(int boardNo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT no, title, writer, content, view_cnt, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
        sql.append(" FROM tbl_board ");
        sql.append(" WHERE no = ? ");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setInt(1, boardNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt("no");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                int viewCnt = rs.getInt("view_cnt");
                String regDate = rs.getString("reg_date");
                BoardVO board = new BoardVO(no, title, writer, content, viewCnt, regDate);
                rs.close();
                return board;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBoard(BoardVO board) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tbl_board ");
        sql.append("SET title = ?, writer = ?, content = ? ");
        sql.append("WHERE no = ?");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getWriter());
            pstmt.setString(3, board.getContent());
            pstmt.setInt(4, board.getNo());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBoardByNo(int boardNo) {
        String sql = "DELETE FROM tbl_board WHERE no = ?";
        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, boardNo);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
