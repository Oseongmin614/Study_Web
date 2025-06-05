package kr.ac.kopo.member.service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.dao.MemberDAOImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao = new MemberDAOImpl();
	}

	public MemberVO login(MemberVO member) throws Exception {
		return memberDao.selectMemberByIDPassword(member);
	}
}
