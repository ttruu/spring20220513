package com.choong.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.PageInfoDto;
import com.choong.spr.domain.ReplyDto;
import com.choong.spr.service.BoardService;
import com.choong.spr.service.ReplyService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;
	
	/* 1. 보드 
	 * 보드 리스트 */ 
	@RequestMapping("list") 
	public void boardList(@RequestParam(name="type", defaultValue = "")String type, 
						  @RequestParam(name="keyword", defaultValue = "") String keyword, 
						  Model model) {
		
		List<BoardDto> list = service.listBoard(type, keyword);
		
		model.addAttribute("boardList", list);
	}

	
	/* 쓰기 */
	@GetMapping("write")
	public void wirteBoard() {
		
	}
	
	@PostMapping("write")
	public String writeBoardProcess(BoardDto board, RedirectAttributes rttr) {
		boolean success = service.writeBoard(board);
		
		if (success) {
			rttr.addFlashAttribute("message", "새 글이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "새 글이 등록되지 않았습니다.");
		}
		
		return "redirect:/board/list";
		/* return "redirect:/ex01/board/" + board.getId(); */
	}
	 
	 /* 보드 내용 보기*/
	@GetMapping("get")
	public void getBoard(int id, Model model) {
		BoardDto dto = service.getBoard(id);
		
		/* 댓글 보이기 */
		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);
		
		List<ReplyDto> replyCount = replyService.listReplyCountByBoardId(id);

		model.addAttribute("board", dto);
		
		/* 댓글 보이기 */
		model.addAttribute("reply", replyList);
		
		model.addAttribute("replyCount", replyCount);
	}
	 
	 
	 /* 수정*/
	@PostMapping("modify")
	public String modifyBoard(BoardDto board, RedirectAttributes rttr) {
		boolean success = service.updateBoard(board);
		
		// 게시물을 수정할 경우엔 RedirectAttributes 사용해줄것
		// model은 redirect하면 사라짐 
		if(success) {
			rttr.addFlashAttribute("message", "글이 수정되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "글이 수정되지 않았습니다.");
		}
		
		rttr.addAttribute("id", board.getId());
		return "redirect:/board/get";
	}
	
	
	/* 삭제 */
	@PostMapping("delete")
	public String deleteBoard(int id, RedirectAttributes rttr) {
		boolean success = service.deleteBoardById(id);
		if(success) {
			rttr.addFlashAttribute("message", "글이 삭제 되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "글이 삭제 되지않았습니다.");
		}
 		return "redirect:/board/list";
	}
	
	
	
	
	// 페이지네이션
	/* @GetMapping("list")
	public String pagination(@RequestParam(name="page", defaultValue = "1")int page, Model model) {
		
		int rowPerPage = 5;
		List<BoardDto> list = service.listBoardPage(page, rowPerPage);
		
		int totalRecords = service.countBoard();
		
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		
		model.addAttribute("boardList", list);
		model.addAttribute("pageInfo", pageInfo);
		
		
				
		return "/ex01/board/list";
	}
*/
	 
	 
}
