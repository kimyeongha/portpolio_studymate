package project.port.mapper;




import project.port.domain.StudyVO;

public interface StudyMapper {
	public int  insert(StudyVO vo);
	public int leaderlimit(String email);
	public int studyno();
}
