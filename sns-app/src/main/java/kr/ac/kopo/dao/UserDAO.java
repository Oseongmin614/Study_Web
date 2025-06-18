package kr.ac.kopo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;
    
    public void createUser(String uid, String email, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("email", email);
        params.put("name", name);
        
        sqlSession.insert("kr.ac.kopo.dao.UserDAO.insertUser", params);
    }
    
    public Map<String, Object> getUserByUid(String uid) {
        return sqlSession.selectOne("kr.ac.kopo.dao.UserDAO.selectUserByUid", uid);
    }
    
    public void updateUserRole(String uid, String role) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("role", role);
        
        sqlSession.update("kr.ac.kopo.dao.UserDAO.updateUserRole", params);
    }
}
