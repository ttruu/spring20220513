package com.choong.spr.service.ex01;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.ex01.ReplyDto;
import com.choong.spr.mapper.ex01.Ex02Mapper;

@Service
public class Ex02Service {
	@Autowired
	private Ex02Mapper mapper;

	public boolean addReply(ReplyDto reply) {
		reply.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertReply(reply);
		return cnt == 1;
	}

	public List<ReplyDto> listReplyByBoardId(int boardId) {
		return mapper.selectReplyByBoardId(boardId);
	}
	
	public List<ReplyDto> listReplyCountByBoardId(int id) {
		return mapper.selectReplyByBoardCountId(id);
	}


	public boolean deleteReplyById(int id) {
		int cnt = mapper.deleteReplyById(id);
		return cnt == 1;
	}

	public boolean updateReply(ReplyDto reply) {
		int cnt = mapper.updateReply(reply);
		return cnt == 1;
	}

}
