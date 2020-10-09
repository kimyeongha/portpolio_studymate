package project.port.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.port.domain.Criteria;
import project.port.domain.PageDTO;
import project.port.service.ReviewService;
@Controller
public class ReviewController {
	@Autowired
	ReviewService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@RequestMapping("/review")

	public void review(Model model, @RequestParam("subject") String subject,Criteria cri) {
		if (subject.equals("main")) {
		    logger.info("list:"+cri);
			model.addAttribute("list", service.reviewPagingMain(cri));
			 int total =service.getTotalCountMain(cri);
			model.addAttribute("pageMaker",new PageDTO(cri,total,subject));
			 
			
		   System.out.println("main에서total은"+total);
		} 

		else {
			
			logger.info("main아 아닌 list:"+cri);
			logger.info("main이 아닌 list의subject"+subject);
			    cri.setSubject(subject);
			 model.addAttribute("list", service.reviewPaging(cri));
		
		    int total =service.getTotalCount(cri);
		    System.out.println("total은"+total);
		    model.addAttribute("pageMaker",new PageDTO(cri,total,subject));
		   
		}

	}
	
}
