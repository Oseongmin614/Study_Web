package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.util.ConnectionFactory;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberVO selectMemberByIDPassword(MemberVO loginVO) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, type ");
		sql.append("  from tbl_member ");
		sql.append(" where id = ? and password = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setName(name);
				member.setType(type);
				
				return member;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
