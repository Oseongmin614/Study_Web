package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	public MemberVO getMember(MemberVO loginVO) throws Exception {
		return memberDao.selectMemberByIDPassword(loginVO);
	}
}
