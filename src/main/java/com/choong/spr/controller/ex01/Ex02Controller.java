package com.choong.spr.controller.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.spr.domain.ex01.ReplyDto;
import com.choong.spr.service.ex01.Ex02Service;

@Controller
@RequestMapping("ex01")
public class Ex02Controller {

	@Autowired
	private Ex02Service service;
	
	/* 2. 리플라이 
	 * 댓글 쓰기*/ 
	@RequestMapping("reply/add")
	public String addReply(ReplyDto reply) {
		boolean success = service.addReply(reply);
		
		return "redirect:/ex01/board/" + reply.getBoardId();
	}
		
	
	/* 댓글 삭제*/
	@PostMapping("reply/delete")
	public String deleteReply(ReplyDto reply) {
		boolean success = service.deleteReplyById(reply.getId());
		
		return "redirect:/ex01/board/" + reply.getBoardId();
	}
	
	/*댓글 수정*/
	@PostMapping("reply/modify")
	public String modifyReply(ReplyDto reply) {
		boolean success = service.updateReply(reply);
		return "redirect:/ex01/board/" + reply.getBoardId();
	}
	
}
