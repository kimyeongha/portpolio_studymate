package project.port.service;

import project.port.domain.StudyVO;

public interface StudyRegisterService {
    public boolean Register(StudyVO vo);
    public int leaderlimit(String email);
}
