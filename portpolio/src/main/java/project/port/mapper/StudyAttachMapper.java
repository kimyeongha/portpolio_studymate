package project.port.mapper;

import java.util.List;

import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;

public interface StudyAttachMapper {

  public void insert(StudyVO vo);
  
  public void delete(String uuid);
  
  public StudyAttachVO  showAttach(int bno);
  
  public List<StudyAttachVO> getOldFiles();
  
	
}
