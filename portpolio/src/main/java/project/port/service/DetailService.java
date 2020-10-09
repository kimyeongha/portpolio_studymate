package project.port.service;

import java.util.List;

import project.port.domain.MemberForLeaderVO;
import project.port.domain.ReplyVO;
import project.port.domain.ReviewVO;
import project.port.domain.StudyVO;

public interface DetailService {


	
	public List<StudyVO> forstudentList(String email);
	public List<MemberForLeaderVO> forLeaderList(String email);
	public List<StudyVO> formodify(String email);
	public boolean leaderAutho(ReplyVO vo);
	public boolean modifyAutho(ReplyVO vo);
	public boolean reviewAttho(ReplyVO vo);
	public void studentdelete(ReplyVO vo);
	public void leaderdelte(ReplyVO vo);
	public StudyVO studyModifylist(int studyno);
	public boolean  studymodify(StudyVO vo);
	public boolean studydelete(int studyno);
	public boolean review(ReviewVO vo);
	
}
