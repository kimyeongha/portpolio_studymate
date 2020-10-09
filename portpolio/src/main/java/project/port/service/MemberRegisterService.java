package project.port.service;

import project.port.domain.MemberVO;

public interface MemberRegisterService {
	public boolean register(MemberVO vo);
	public boolean emailcheck(String email) throws Exception;
	public void reply();	
}
