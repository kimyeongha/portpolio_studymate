package project.port.service;

import java.util.List;

import project.port.domain.ReviewVO;
import project.port.domain.StudyVO;

public interface IndexService {
 public List<StudyVO> getList();
 public List<ReviewVO> reviewList();
}
