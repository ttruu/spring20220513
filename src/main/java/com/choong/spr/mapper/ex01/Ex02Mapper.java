package com.choong.spr.mapper.ex01;

import java.util.List;

import com.choong.spr.domain.ex01.ReplyDto;

public interface Ex02Mapper {

	int insertReply(ReplyDto reply);

	List<ReplyDto> selectReplyByBoardId(int boardId);

	int deleteReplyById(int id);

	int updateReply(ReplyDto reply);

}
