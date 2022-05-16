package com.choong.spr.controller.ex01;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.ex01.BoardDto;
import com.choong.spr.domain.ex01.ReplyDto;
import com.choong.spr.service.ex01.Ex01Service;
import com.choong.spr.service.ex01.Ex02Service;

@Controller
@RequestMapping("ex01")
public class Ex01Controller {

	@Autowired
	private Ex01Service service;
	
	@Autowired
	private Ex02Service replyService;
	
	/* 1. 보드 
	 * 보드 리스트 */ 
	@RequestMapping("/board/list") 
	public void boardList(Model model) {
		List<BoardDto> list = service.listBoard();
		
		model.addAttribute("boardList", list);
	}
	
	 
	 /* 보드 내용 보기*/
	@GetMapping("/board/{id}")
	public String getBoard(@PathVariable("id") int id, Model model) {
		BoardDto dto = service.getBoard(id);
		
		/* 댓글 보이기 */
		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);
		
		model.addAttribute("board", dto);
		
		/* 댓글 보이기 */
		model.addAttribute("reply", replyList);


		return "/ex01/board/get";
	}
	 
	 
	 /* 수정*/
	@PostMapping("/board/modify")
	public String modifyBoard(BoardDto board, RedirectAttributes rttr) {
		boolean success = service.updateBoard(board);
		
		if(success) {
			rttr.addFlashAttribute("message", "ok");
		} else {
			rttr.addFlashAttribute("message", "false");
		}
		return "redirect:/ex01/board/" + board.getId();
	}
	
	
	/* 삭제 */
	@PostMapping("/board/delete")
	public String deleteBoard(int id) {
		boolean success = service.deleteBoardById(id);
		
		return "redirect:/ex01/board/list";
	}
	
	
	/* 쓰기 */
	@GetMapping("/board/write")
	public void wirteBoard() {
		
	}
	
	@PostMapping("/board/write")
	public String writeBoardProcess(BoardDto board) {
		boolean success = service.writeBoard(board);
		
		return "redirect:/ex01/board/list";
		/* return "redirect:/ex01/board/" + board.getId(); */
	}

	 
	 
}
