package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 이 클래스가 데이터베이스와 상호작용하는 DAO임을 스프링에 알립니다.
@Repository 
public class UserDAO {

    // MyBatis와 스프링을 연결해주는 핵심 객체입니다.
    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 신규 사용자를 DB에 등록합니다.
     * @param userUid Firebase에서 발급받은 고유 UID
     * @param email 사용자의 이메일
     * @param userName 사용자의 이름
     */
    public void insertUser(String userUid, String email, String userName) {
        Map<String, Object> params = new HashMap<>();
        params.put("userUid", userUid);   // XML의 #{userUid}와 일치
        params.put("email", email);       // XML의 #{email}와 일치
        params.put("userName", userName); // XML의 #{userName}와 일치
        
        sqlSession.insert("kr.ac.kopo.dao.UserDAO.insertUser", params);
    }
    
    /**
     * UID를 이용해 사용자 정보를 조회합니다.
     * @param userUid 조회할 사용자의 UID
     * @return 조회된 사용자 정보가 담긴 Map 객체
     */
    public Map<String, Object> selectUserByUid(String userUid) {
        return sqlSession.selectOne("kr.ac.kopo.dao.UserDAO.selectUserByUid", userUid);
    }

    /**
     * 사용자의 역할(권한)을 변경합니다.
     * @param userUid 역할을 변경할 사용자의 UID
     * @param userRole 새로 부여할 역할 (예: "ADMIN")
     */
    public void updateUserRole(String userUid, String userRole) {
        Map<String, Object> params = new HashMap<>();
        params.put("userUid", userUid);   // XML의 #{userUid}와 일치
        params.put("userRole", userRole); // XML의 #{userRole}와 일치
        
        sqlSession.update("kr.ac.kopo.dao.UserDAO.updateUserRole", params);
    }
}
