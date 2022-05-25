package com.choong.spr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.choong.spr.domain.BoardDto;
import com.choong.spr.domain.PageInfoDto;

public interface BoardMapper {

	List<BoardDto> selectBoardList(@Param("type")String type, @Param("keyword")String keyword);

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);

	List<BoardDto> listBoardPage(@Param("from")int from, @Param("row") int row);
	
	int countBoard();

}
