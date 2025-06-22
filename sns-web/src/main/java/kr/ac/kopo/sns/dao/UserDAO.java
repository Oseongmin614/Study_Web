package kr.ac.kopo.sns.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.sns.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	private static final String NAMESPACE = "userMapper.";

	public int insertUser(UserVO user) {
		return sqlSession.insert(NAMESPACE + "insertUser", user);
	}

	public UserVO selectUserByEmail(String email) {
		return sqlSession.selectOne(NAMESPACE + "selectUserByEmail", email);
	}

	public UserVO selectUserById(Long userId) {
		return sqlSession.selectOne(NAMESPACE + "selectUserById", userId);
	}

	public int updateUser(UserVO user) {
		return sqlSession.update(NAMESPACE + "updateUser", user);
	}

	public List<UserVO> selectAllUsers() {
		return sqlSession.selectList(NAMESPACE + "selectAllUsers");
	}

	public int updateUserStatus(Long userId, String status) {
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setStatus(status);
		return sqlSession.update(NAMESPACE + "updateUserStatus", user);
	}

	public int deleteUser(Long userId) {
		return sqlSession.delete(NAMESPACE + "deleteUser", userId);
	}
}
