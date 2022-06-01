package com.choong.spr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choong.spr.domain.MemberDto;
import com.choong.spr.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public boolean addMember(MemberDto member) {
		return mapper.insertMember(member) == 1;
	}

	public boolean hasMemberId(String id) {
		return mapper.countMemberId(id) > 0;
	}

	public boolean hasMemberEmail(String email) {
		return mapper.countMemberEmail(email) > 0;
	}

	public boolean hasMemberNickName(String nickName) {
		return mapper.countMemberNickName(nickName) > 0;
	}

	public List<MemberDto> listMember() {
		return mapper.selectAllMember();
	}

	public MemberDto getMemberById(String id) {
		return mapper.selectMemberById(id);
	}

	public boolean removeMember(MemberDto dto) {
		// 기존에 있는 멤버의 아이디를 얻어오고
		MemberDto member = mapper.selectMemberById(dto.getId());
		
		// 기존 멤버의 패스워드가 모달창에서 받은 패스워드와 같을때만 지워지도록
		if(member.getPassword().equals(dto.getPassword())) {
			return mapper.deleteMemberById(dto.getId()) == 1;			
		}
		return false;
	}

}
