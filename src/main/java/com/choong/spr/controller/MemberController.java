package com.choong.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.MemberDto;
import com.choong.spr.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("signup")
	public void signupForm() {
		
	}
	
	@PostMapping("signup")
	public String signupProcess(MemberDto member, RedirectAttributes rttr) {
		boolean success = service.addMember(member);
		
		if(success) {
			rttr.addFlashAttribute("message", "회원가입 완료 ! ");
			return "redirect:/board/list";
		} else {
			rttr.addFlashAttribute("message", "회원가입에 실패했어요 !");
			rttr.addFlashAttribute("member", member);

			return "redirect:/member/signup";
		}
	}
	
	@GetMapping(path="check", params="id")
	@ResponseBody
	public String idCheck(String id) {
		boolean exist = service.hasMemberId(id);
		if(exist) {
			return "notOk";
		} else {
			return "ok";
		}
	}
	
	@GetMapping(path="check", params="email")
	@ResponseBody
	public String emailCheck(String email) {
		boolean exist = service.hasMemberEmail(email);
		if(exist) {
			return "notOk";
		} else {
			return "ok";
		}
	}
	
	@GetMapping(path="check", params="nickName")
	@ResponseBody
	public String nickNameCheck(String nickName) {
		boolean exist = service.hasMemberNickName(nickName);
		if(exist) {
			return "notOk";
		} else {
			return "ok";
		}
	}
	
	
}
