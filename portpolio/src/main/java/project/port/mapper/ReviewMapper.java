package project.port.mapper;

import java.util.List;

import project.port.domain.Criteria;
import project.port.domain.ReviewVO;

public interface ReviewMapper {
 

public List<ReviewVO> getReviewPaging(Criteria cri);
public List<ReviewVO> getReviewMainpaging(Criteria cri);
public int getTotalCount(Criteria cri);
public int getTotalCountMain(Criteria cri);



   
}
