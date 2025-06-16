package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {

	/**
	 * 로그인 여부 판단 기능
	 * @param loginVO  사용자가 입력한 ID,PASSORD를 저장한 객체
	 * @return 로그인 성공시 회원정보를 가진 MemberVO 객체 반환, 로그인 실패시 null 반환
	 */
	public MemberVO selectMemberByIDPassword(MemberVO loginVO) throws Exception;
}
