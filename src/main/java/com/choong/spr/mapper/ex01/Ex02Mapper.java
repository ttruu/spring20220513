package com.choong.spr.mapper.ex01;

import java.util.List;

import com.choong.spr.domain.ex01.ReplyDto;

public interface Ex02Mapper {

	int insertReply(ReplyDto reply);

	List<ReplyDto> selectReplyByBoardId(int boardId);
	
	List<ReplyDto> selectReplyByBoardCountId(int id);

	int deleteReplyById(int id);

	int updateReply(ReplyDto reply);
	
	/*댓글이 있는 게시물 지우기 위한*/
	void deleteReplyByBoardId(int BoardId);

}
