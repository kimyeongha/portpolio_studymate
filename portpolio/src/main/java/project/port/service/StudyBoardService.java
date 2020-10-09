package project.port.service;

import java.util.List;

import project.port.domain.Criteria;
import project.port.domain.ReplyVO;
import project.port.domain.StudyVO;

public interface StudyBoardService {
    public List<StudyVO> list(Criteria cri);
    public List<StudyVO> listSubject(Criteria cri);
    public void reply(ReplyVO vo);
    public int quotaCount(int studyno);
    public int studyCnt(String email);
   // public void addStudyCnt();
   // public int removeStudyCnt(int studyCnt);
   // public int addLeaderCnt(int leaderCnt);
   // public int removeLeaderCnt(int leaderCnt);
	public int studytotalForMain();
	public int studytotalForSubject(String subject);
	
}
