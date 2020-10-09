package project.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.port.domain.ReviewVO;
import project.port.domain.StudyVO;
import project.port.mapper.IndexMapper;
@Service
public class IndexServiceImpl implements IndexService {
  @Autowired 
  IndexMapper mapper;
	@Override
	public List<StudyVO> getList() {
		// TODO Auto-generated method stub
		return  mapper.getList();
	}
	@Override
	public List<ReviewVO>reviewList(){
		return mapper.reviewList();
	}

}
