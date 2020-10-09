package project.port.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;
import project.port.mapper.StudyAttachMapper;
import project.port.mapper.StudyMapper;
@Service
public class StudyRegisterServiceImpl implements StudyRegisterService{
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
     @Autowired
		private StudyMapper mapper;
	  
	 @Autowired
	  private StudyAttachMapper attachmapper;
	  
      @Transactional
	  @Override
	public boolean Register(StudyVO vo) {
	          
	
	
		 int mapperresult =  mapper.insert(vo);
	      
		     int studyno=     mapper.studyno();
		   
		     vo.setStudyno(studyno);	    
	
		     attachmapper.insert(vo);
		     boolean result;
			 if(mapperresult>=1) {   
		    	 result=true;
		      }else {
		    	  result=false;
		      }
		 
		return result;
	}


	@Override
	public int leaderlimit(String email) {
		// TODO Auto-generated method stub
		return mapper.leaderlimit(email);
	}

}
