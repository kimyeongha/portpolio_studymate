package project.port.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.port.domain.Criteria;
import project.port.domain.ReviewVO;
import project.port.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ReviewMapper mapper;
	
	List<ReviewVO> list;
	
	@Override
	public List<ReviewVO> reviewPaging(Criteria cri) {
		// TODO Auto-generated method stub
		System.out.println("service에서 cri는"+cri);
		
		list = mapper.getReviewPaging(cri);
		logger.info("service="+mapper.getReviewPaging(cri));
		
		
		
		return list;
	}
	@Override
	public List<ReviewVO> reviewPagingMain(Criteria cri) {
		// TODO Auto-generated method stub
		list= mapper.getReviewMainpaging(cri);
		
		return list;
	}
	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		
		return mapper.getTotalCount(cri) ;
	}
	@Override
	public int getTotalCountMain(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCountMain(cri);
	}

}
