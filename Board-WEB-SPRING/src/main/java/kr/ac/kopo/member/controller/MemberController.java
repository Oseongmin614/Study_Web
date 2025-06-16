package kr.ac.kopo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes({"userVO"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemberVO userVO = memberService.getMember(member);
		if(userVO == null) {
			// 로그인 실패
			mav.setViewName("redirect:/login");
			return "redirect:/login"; 
		}
		
		// 로그인 성공
//		session.setAttribute("userVO", userVO);
		model.addAttribute("userVO", userVO);
		mav.setViewName("redirect:/");
		
		return "redirect:/";
	}
}








