package project.port.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.port.domain.MemberVO;
import project.port.mapper.MemberRegisterMapper;



@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired 
	MemberRegisterMapper mapper;
	 
	 @Override
	public boolean register(MemberVO vo) {
		
		
		System.out.println("insertR에들어갈vo는"+vo);
	int result=	mapper.insert(vo);
		if(result>=1) {
			
			return true;
		}else {
			return false;
		}
		
		
		
	}

	@Override
	public boolean emailcheck(String email) throws Exception {
		// TODO Auto-generated method stub
		 int result = mapper.emailCheck(email);
		
		if(result==1) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public void reply() {
		// TODO Auto-generated method stub
		
	}
    
}
