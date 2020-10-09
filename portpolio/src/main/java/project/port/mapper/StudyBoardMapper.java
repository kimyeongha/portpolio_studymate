package project.port.mapper;

import java.util.List;

import project.port.domain.Criteria;
import project.port.domain.ReplyVO;
import project.port.domain.StudyVO;

public interface StudyBoardMapper {
   
	public List<StudyVO> list(Criteria cri);
	public List<StudyVO> listSubject(Criteria cri);
	
	
	public void reply(ReplyVO vo);
	public int quotaCount(int studyno);
	//public void addStudyCnt();	
	public int studyCnt(String email);
	public int studytotalForMain();
	public int studytotalForSubject(String subject);

}
