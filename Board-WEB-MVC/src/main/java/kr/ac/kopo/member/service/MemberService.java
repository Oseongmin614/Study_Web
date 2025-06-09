package kr.ac.kopo.member.service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;

	
	public MemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	
		System.out.println("MemberService 객체 생성....");
	}

	public MemberVO login(MemberVO member) throws Exception {
		return memberDao.selectMemberByIDPassword(member);
	}
}
