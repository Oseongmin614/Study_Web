package kr.ac.kopo.sns.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.kopo.sns.service.UserService;
import kr.ac.kopo.sns.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String registerPage() {
        return "user/register";
    }
    
    @PostMapping("/register")
    @ResponseBody
    public String register(UserVO user) {
        boolean result = userService.registerUser(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }
    
    @PostMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(@RequestParam String email) {
        UserVO user = userService.getUserByEmail(email);
        if (user != null) {
            return "exists";
        } else {
            return "available";
        }
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        UserVO user = userService.login(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            return "success";
        } else {
            return "fail";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
    @GetMapping("/mypage")
    public String mypage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/user/login";
        }
        
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login";
        }
        
        UserVO user = userService.getUserById(loginUser.getUserId());
        model.addAttribute("user", user);
        return "user/mypage";
    }
    
    @PostMapping("/update")
    @ResponseBody
    public String updateProfile(UserVO user, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "unauthorized";
        }
        
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "unauthorized";
        }
        
        user.setUserId(loginUser.getUserId());
        boolean result = userService.updateProfile(user);
        if (result) {
            UserVO updatedUser = userService.getUserById(loginUser.getUserId());
            session.setAttribute("loginUser", updatedUser);
            return "success";
        } else {
            return "fail";
        }
    }
    
    @GetMapping("/admin/users")
    public String adminUsers(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/user/login";
        }
        
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null || !"ADMIN".equals(loginUser.getRole())) {
            return "redirect:/user/login";
        }
        
        List<UserVO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }
    
    @PostMapping("/admin/changeStatus")
    @ResponseBody
    public String changeUserStatus(@RequestParam Long userId, @RequestParam String status, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "unauthorized";
        }
        
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null || !"ADMIN".equals(loginUser.getRole())) {
            return "unauthorized";
        }
        
        boolean result = userService.changeUserStatus(userId, status);
        return result ? "success" : "fail";
    }
    
    @PostMapping("/admin/delete")
    @ResponseBody
    public String deleteUser(@RequestParam Long userId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "unauthorized";
        }
        
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null || !"ADMIN".equals(loginUser.getRole())) {
            return "unauthorized";
        }
        
        boolean result = userService.deleteUser(userId);
        return result ? "success" : "fail";
    }
}
