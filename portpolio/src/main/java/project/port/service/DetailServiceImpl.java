package project.port.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.port.domain.MemberForLeaderVO;
import project.port.domain.MemberVO;
import project.port.domain.ReplyVO;
import project.port.domain.ReviewVO;
import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;
import project.port.mapper.DetailMapper;
import project.port.mapper.StudyMapper;

@Service
public class DetailServiceImpl implements DetailService {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DetailMapper mapper;
	

	@Override
	public List<StudyVO> forstudentList(String email) {
		logger.info("service계층에서email"+email);
		
		return mapper.forstudentList(email);
		
	}

	@Override
	public List<MemberForLeaderVO> forLeaderList(String email) {
		// TODO Auto-generated method stub
		return mapper.forLeaderList(email);
	}

	@Override
	public List<StudyVO> formodify(String email) {
		// TODO Auto-generated method stub
		return mapper.studyInfoList(email);
	}

	@Override
	public boolean leaderAutho(ReplyVO vo) {
		// TODO Auto-generated method stub
		if(mapper.leaderAutho(vo)==1) {
			return true;
		}else {
			return false;
		}
		
		
		
		
	}

	@Override
	public void studentdelete(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.studentdelete(vo);
	}

	@Override
	public void leaderdelte(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.leaderdelete(vo);
		
	}

	@Override
	public StudyVO studyModifylist(int studyno) {
		// TODO Auto-generated method stub
		
		
		return mapper.studyModifyList(studyno);
	}

	@Override
	public boolean modifyAutho(ReplyVO vo) {
		
		if(mapper.modifyAutho(vo)==1) {
			return true;
		}else {
			return false;
		}
		
	}
   @Transactional
	@Override
	public boolean studymodify(StudyVO vo) {
	    StudyAttachVO attchvo = new StudyAttachVO ();
	    
	    attchvo.setFileName( vo.getFileName());
	    attchvo.setUuid( vo.getUuid());
	    attchvo.setStudyno(vo.getStudyno());
	    attchvo.setFileName(vo.getFileName());
	    attchvo.setUploadPath(vo.getUploadPath());
	    
	  System.out.println("DetailServiceImpl에서StudyAttachVO는"+attchvo);
	    if((mapper.studyModifyAttach(attchvo)&mapper.studyModify(vo))==1) { 
	    	
	    	
	    	
			return true;
		}else {
			return false;
		}
		
	    

	}
@Transactional
@Override
public boolean studydelete(int studyno) {
	// TODO Auto-generated method stub
	 System.out.println("mapper에서studyno는"+studyno);
	 System.out.println("mapper에서studydelete결과는"+mapper.studydelete(studyno));
	// System.out.println("mapper에서studydeleteAttach결과는"+mapper.studydeleteAttach(studyno));
	    if(((mapper.studydelete(studyno))&mapper.studydeleteTomember(studyno))==1) { 
	    
	
	    	
				return true;
			}else {
				return false;
			}
			
		      
		}

@Override
public boolean reviewAttho(ReplyVO vo) {
	// TODO Auto-generated method stub
	
	
	if(mapper.reviewAutho(vo)==1) {
		return true;
	}else {
		return false;
	}
	
}

@Override
public boolean review(ReviewVO vo) {
	// TODO Auto-generated method stub
	if(mapper.review(vo)==1) {
		return true;
	}else {
		return false;
	}
	

}
	
	

	


}
