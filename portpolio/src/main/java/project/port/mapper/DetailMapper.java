package project.port.mapper;

import java.util.List;

import project.port.domain.MemberForLeaderVO;
import project.port.domain.ReplyVO;
import project.port.domain.ReviewVO;
import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;

public interface DetailMapper {

	public List<StudyVO> forstudentList(String email);
	public List<MemberForLeaderVO> forLeaderList(String email);
	public List<StudyVO> studyInfoList(String email);
	public int leaderAutho(ReplyVO vo);
	public int modifyAutho(ReplyVO vo);
	public int reviewAutho(ReplyVO vo);
	public void  studentdelete(ReplyVO vo);
	public void leaderdelete(ReplyVO vo);
	public StudyVO studyModifyList(int studyno);
	public int studyModify(StudyVO vo);
	public int studyModifyAttach(StudyAttachVO vo);
	public int studydelete(int studyno);
	//public int studydeleteAttach(int studyno);  외래키 설정으로 인해 스터디만 없어줘도 자동으로 사라짐
	public int studydeleteTomember(int studyno);
	public int review(ReviewVO vo);
	
	
	


	
	

	
}
