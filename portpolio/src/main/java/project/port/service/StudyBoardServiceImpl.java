package project.port.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.port.domain.Criteria;
import project.port.domain.ReplyVO;
import project.port.domain.StudyVO;
import project.port.mapper.StudyBoardMapper;

@Service
public class StudyBoardServiceImpl implements StudyBoardService {
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	  @Autowired
		private StudyBoardMapper mapper;
	
	
	@Override
	public List<StudyVO> list(Criteria cri) {
		// TODO Auto-generated method stub
       
	
		  
	List<StudyVO> list =mapper.list(cri);
	logger.info("service계층에서list는"+mapper.list(cri));
	
	logger.info("service에서 list값은"+list);
	System.out.println("service에서 list값은"+list);
	
	return list;
	
	
	}
	
	public List<StudyVO> listSubject(Criteria cri) {
		// TODO Auto-generated method stub
      
			  
	List<StudyVO> list =mapper.listSubject(cri);
	logger.info("service계층에서list는"+mapper.listSubject(cri));
	System.out.println("servicesubject:"+cri);
	return list;
	
	

  }

	@Override
	public void reply(ReplyVO vo) {
	   
		logger.info("replyservice에서vo는"+vo);
		mapper.reply(vo);
	   
		
	}

	@Override
	public int quotaCount(int studyno) {
		// TODO Auto-generated method stub
		return mapper.quotaCount(studyno);
	}

	
	/*
	 * @Override
	public void addStudyCnt() {
		// TODO Auto-generated method stub
		mapper.addStudyCnt();
	}
	*/

	@Override
	public int studyCnt(String email) {
		// TODO Auto-generated method stub
		return mapper.studyCnt(email);
	}

	@Override
	public int studytotalForMain() {
		  
		return mapper.studytotalForMain();
	}

	@Override
	public int studytotalForSubject(String subject) {
		// TODO Auto-generated method stub
		return mapper.studytotalForSubject(subject);
	}


}