package com.choong.spr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping("reply")
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	/* 2. 리플라이 
	 * 댓글 쓰기*/ 
	@RequestMapping("add")
	public String addReply(ReplyDto reply) {
		boolean success = service.addReply(reply);
		
		return "redirect:board/" + reply.getBoardId();
	}
		
	
	/* 댓글 삭제*/
	@PostMapping("delete")
	public String deleteReply(ReplyDto reply) {
		boolean success = service.deleteReplyById(reply.getId());
		
		return "redirect:board/" + reply.getBoardId();
	}
	
	/*댓글 수정*/
	@PostMapping("modify")
	public String modifyReply(ReplyDto reply) {
		boolean success = service.updateReply(reply);
		return "redirect:board/" + reply.getBoardId();
	}
	
}
