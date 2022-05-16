package com.choong.spr.mapper.ex01;

import java.util.List;

import com.choong.spr.domain.ex01.BoardDto;

public interface Ex01Mapper {

	List<BoardDto> selectBoardList();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);

}
