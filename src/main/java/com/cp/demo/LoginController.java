package com.cp.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	private MemberService memService;
	
	@PostMapping("/login")
	public String loginForm(@Validated LoginRequest login, BindingResult result, Model model) {
		if(memService.isExistByMemberId(login.getUsername())) {
			return "redirect:/login";
		}
		System.out.println("Have");
		Member mem = memService.findMemberById(login.getUsername());
		if(mem.getPassword().contentEquals(login.getPassword())) {
			Session.isLogin=true;
			Session.memId=mem.getMemId();
			System.out.println("True");
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/register")
	public String addUser(@Validated Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/register";
		}
		System.out.println(member.getPassword());
		member.setDateReg(new Date());
		memService.saveMember(member);
		return "redirect:/login";
	}
}
