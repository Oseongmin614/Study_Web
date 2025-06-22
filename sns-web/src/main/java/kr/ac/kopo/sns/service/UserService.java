package kr.ac.kopo.sns.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.sns.dao.UserDAO;
import kr.ac.kopo.sns.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public boolean registerUser(UserVO user) {
		try {
			UserVO existingUser = userDAO.selectUserByEmail(user.getEmail());
			if (existingUser != null) {
				return false;
			}

			if (user.getRole() == null) {
				user.setRole("USER");
			}
			if (user.getStatus() == null) {
				user.setStatus("ACTIVE");
			}

			int result = userDAO.insertUser(user);
			return result > 0;
		} catch (Exception e) {
			System.err.println("회원가입 중 오류 발생: " + e.getMessage());
			return false;
		}
	}

	public UserVO login(String email, String password) {
		try {
			UserVO user = userDAO.selectUserByEmail(email);
			if (user != null && user.getPassword().equals(password) && "ACTIVE".equals(user.getStatus())) {
				return user;
			}
			return null;
		} catch (Exception e) {
			System.err.println("로그인 중 오류 발생: " + e.getMessage());
			return null;
		}
	}

	public UserVO getUserById(Long userId) {
		try {
			return userDAO.selectUserById(userId);
		} catch (Exception e) {
			System.err.println("사용자 조회 중 오류 발생: " + e.getMessage());
			return null;
		}
	}

	public UserVO getUserByEmail(String email) {
		try {
			return userDAO.selectUserByEmail(email);
		} catch (Exception e) {
			System.err.println("사용자 조회 중 오류 발생: " + e.getMessage());
			return null;
		}
	}

	public boolean updateProfile(UserVO user) {
		try {
			int result = userDAO.updateUser(user);
			return result > 0;
		} catch (Exception e) {
			System.err.println("프로필 수정 중 오류 발생: " + e.getMessage());
			return false;
		}
	}

	public List<UserVO> getAllUsers() {
		try {
			return userDAO.selectAllUsers();
		} catch (Exception e) {
			System.err.println("전체 사용자 조회 중 오류 발생: " + e.getMessage());
			return null;
		}
	}

	public boolean changeUserStatus(Long userId, String status) {
		try {
			int result = userDAO.updateUserStatus(userId, status);
			return result > 0;
		} catch (Exception e) {
			System.err.println("사용자 상태 변경 중 오류 발생: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteUser(Long userId) {
		try {
			int result = userDAO.deleteUser(userId);
			return result > 0;
		} catch (Exception e) {
			System.err.println("사용자 삭제 중 오류 발생: " + e.getMessage());
			return false;
		}
	}
}
