package kr.ac.kopo.sns.dao;

import kr.ac.kopo.sns.vo.UserVO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/config/spring/spring-mvc.xml"
})
public class UserMapperTest {

    @Autowired
    private DataSource ds;

    @Autowired
    private UserDAO userDAO;

    private UserVO testUser;

    @Before
    public void setUp() {
        testUser = new UserVO();
        testUser.setEmail("testuser@example.com");
        testUser.setPassword("pw1234");
        testUser.setNickname("테스트유저");
        testUser.setProfileImg("profile.png");
        testUser.setRole("USER");
        testUser.setProvider("local");
        testUser.setProviderId("local_test");
        testUser.setStatus("ACTIVE");

        // 기존 데이터가 있으면 삭제 (중복 방지)
        UserVO existing = userDAO.selectUserByEmail(testUser.getEmail());
        if (existing != null) {
            userDAO.deleteUser(existing.getUserId());
        }

        userDAO.insertUser(testUser);

        // INSERT 후 실제 userId를 select해서 세팅
        UserVO inserted = userDAO.selectUserByEmail(testUser.getEmail());
        assertNotNull(inserted);
        testUser.setUserId(inserted.getUserId());
    }

    @Test
    public void testSelectUserByEmail() {
        UserVO user = userDAO.selectUserByEmail(testUser.getEmail());
        assertNotNull(user);
        assertEquals("테스트유저", user.getNickname());
    }

    @Test
    public void testSelectUserById() {
        UserVO byId = userDAO.selectUserById(testUser.getUserId());
        assertNotNull(byId);
        assertEquals("testuser@example.com", byId.getEmail());
    }

    @Test
    public void testUpdateUser() {
        UserVO user = userDAO.selectUserByEmail(testUser.getEmail());
        user.setNickname("수정유저");
        user.setProfileImg("updated.png");
        int updated = userDAO.updateUser(user);
        assertEquals(1, updated);

        UserVO updatedUser = userDAO.selectUserById(user.getUserId());
        assertEquals("수정유저", updatedUser.getNickname());
        assertEquals("updated.png", updatedUser.getProfileImg());
    }

    @Test
    public void testSelectAllUsers() {
        List<UserVO> users = userDAO.selectAllUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testUpdateUserStatus() {
        int result = userDAO.updateUserStatus(testUser.getUserId(), "INACTIVE");
        assertEquals(1, result);

        UserVO updatedUser = userDAO.selectUserById(testUser.getUserId());
        assertEquals("INACTIVE", updatedUser.getStatus());
    }

    @Test
    public void testDeleteUser() {
        int deleted = userDAO.deleteUser(testUser.getUserId());
        assertEquals(1, deleted);

        UserVO shouldBeNull = userDAO.selectUserById(testUser.getUserId());
        assertNull(shouldBeNull);
    }

    @Test
    public void ds테스트() throws Exception {
        assertNotNull(ds);
    }
}
