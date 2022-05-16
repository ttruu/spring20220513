package com.choong.spr.service.ex01;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.ex01.BoardDto;
import com.choong.spr.mapper.ex01.Ex01Mapper;

@Service
public class Ex01Service {
	
	@Autowired
	private Ex01Mapper mapper;

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

	public boolean deleteBoardById(int id) {
		int cnt = mapper.deleteBoard(id);
		return cnt == 1;
	}

	public boolean writeBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertBoard(board);
		return cnt == 1;
	}
	
	
}
