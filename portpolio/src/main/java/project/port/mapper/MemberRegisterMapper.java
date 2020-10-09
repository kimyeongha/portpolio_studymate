package project.port.mapper;

import project.port.domain.MemberVO;

public interface MemberRegisterMapper {

	 public int insert(MemberVO vo);
	 
	 public int emailCheck(String email) throws Exception;
}
