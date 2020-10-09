package project.port.mapper;

import java.util.List;

import project.port.domain.ReviewVO;
import project.port.domain.StudyVO;

public interface IndexMapper {
   
	 public List<StudyVO> getList(); 
	 public List<ReviewVO> reviewList();
	
}
