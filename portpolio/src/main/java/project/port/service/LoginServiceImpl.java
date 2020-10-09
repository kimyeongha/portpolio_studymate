package project.port.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.port.domain.MemberVO;
import project.port.mapper.LoginMapper;


@Service
public class LoginServiceImpl implements LoginService {
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	  @Autowired
		private LoginMapper mapper;
	  
  public MemberVO login(MemberVO vo){	  
	 
	 logger.info("service계층에서vo는"+vo); 
	  return mapper.login(vo);
  }


}
