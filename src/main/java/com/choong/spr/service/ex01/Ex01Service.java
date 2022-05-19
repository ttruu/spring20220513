package com.choong.spr.service.ex01;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choong.spr.domain.ex01.BoardDto;
import com.choong.spr.domain.ex01.PageInfoDto;
import com.choong.spr.mapper.ex01.Ex01Mapper;
import com.choong.spr.mapper.ex01.Ex02Mapper;

@Service
public class Ex01Service {
	
	@Autowired
	private Ex01Mapper mapper;

	@Autowired
	private Ex02Mapper replyMapper;
	
	public List<BoardDto> listBoard() {
		
		return mapper.selectBoardList();
	}

	public BoardDto getBoard(int id) {
		return mapper.getBoard(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		
		return cnt == 1;
	}
	
	@Transactional
	public boolean deleteBoardById(int id) {
		// 댓글 지우기(새 메소드)
		replyMapper.deleteReplyByBoardId(id);
		// 게시물 지우기
		int cnt = mapper.deleteBoard(id);
		return cnt == 1;
	}

	public boolean writeBoard(BoardDto board) {
		/*db자체에서 현재시간으로 설정해놔서 필요없다*/
		/*board.setInserted(LocalDateTime.now());*/
		
		int cnt = mapper.insertBoard(board);
		return cnt == 1;
	}

	public List<BoardDto> listBoardPage(int page, int rowPerPage) {
		int from = (page - 1) * rowPerPage;
		
		return mapper.listBoardPage(from, rowPerPage);
	}
		

	public int countBoard() {
		return mapper.countBoard();
	}
	
	
}
