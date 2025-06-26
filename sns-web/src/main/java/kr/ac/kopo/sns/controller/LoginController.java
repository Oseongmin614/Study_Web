package kr.ac.kopo.sns.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        // ViewResolver 설정에 따라 prefix/suffix가 붙어서
        // /WEB-INF/jsp/login.jsp로 이동
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password, 
                       Model model) {
        // 간단한 로그인 로직 (실제 구현에서는 데이터베이스와 연동)
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("username", username);
            return "redirect:/index"; // 로그인 성공 시 메인 페이지로 이동
        } else {
            model.addAttribute("error", "아이디 또는 패스워드가 올바르지 않습니다.");
            return "login"; // 로그인 실패 시 다시 로그인 페이지
        }
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}