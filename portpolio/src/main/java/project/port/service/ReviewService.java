package project.port.service;

import java.util.List;

import project.port.domain.Criteria;
import project.port.domain.ReviewVO;

public interface ReviewService {

 public List<ReviewVO> reviewPaging(Criteria cri);
 public List<ReviewVO> reviewPagingMain(Criteria cri);
 public int getTotalCount(Criteria cri);
 public int getTotalCountMain(Criteria cri);
}
