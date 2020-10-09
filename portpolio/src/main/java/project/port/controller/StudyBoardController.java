package project.port.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.port.domain.Criteria;
import project.port.domain.MemberVO;
import project.port.domain.PageDTO;
import project.port.domain.ReplyVO;
import project.port.service.DetailService;
import project.port.service.StudyBoardService;

@Controller

public class StudyBoardController {
	private static final Logger logger = LoggerFactory.getLogger(StudyBoardController.class);

	@Autowired
  private StudyBoardService service;
	
	@Autowired
	DetailService dtservice;
	
	
	
	
	/*
@RequestMapping("/studyboard/main")
	public String list(Model model,HttpSession session) {
	MemberVO vo = (MemberVO) session.getAttribute("userInpo");
	  if(vo !=null) {
			logger.info("controller에서 servicelist는? " + service.list());
			model.addAttribute("list", service.list());
			System.out.println("ddddd");
	  return "/studyboard"; 
	  }else {
		  System.out.println("kkkkkk");
		  logger.info("스터디보드 왔지만 왔지만 로그인이 안되있기떄문에 로그인 화면으로 !");
			 model.addAttribute("msg","로그인이 필요한 화면입니다 로그인을 해주세요");
			 return "/login";
	  }


}
*/

	
	@RequestMapping("/studyboard")
	public String listSubject(Model model, @RequestParam("subject") String subject ,HttpSession session,Criteria cri,HttpServletRequest request) {
		MemberVO vo = (MemberVO) session.getAttribute("userInpo");
		String uploadFolder = request.getSession().getServletContext().getRealPath("/webapp/resources/upload");   
		logger.info("studyboard에서vo는"+vo);
		   
		 if(vo !=null) {
			 String	email =vo.getEmail();	
			 if (subject.equals("main")) {
				   int total =  service.studytotalForMain();
					model.addAttribute("studylimit",service.studyCnt(email));
					 model.addAttribute("uploadFolder",uploadFolder);        
					model.addAttribute("list", service.list(cri));
			         model.addAttribute("subject", subject); //pagemakerForm에쓰기 위해
			         model.addAttribute("pageMaker",new PageDTO(cri,total,subject));
			 		logger.info("studyboardcontroll에서 과목 목록은" + service.list(cri));
			          	
			 
			 }
		
				else {
					   int total =  service.studytotalForSubject(subject);
					   cri.setSubject(subject);
					model.addAttribute("list", service.listSubject(cri));
					model.addAttribute("studylimit",service.studyCnt(email));
					 model.addAttribute("subject", subject); 
					 model.addAttribute("pageMaker",new PageDTO(cri,total,subject));                     
					logger.info("studyboardcontroll에서 과목 목록은" + service.listSubject(cri));
				}
		  return "/studyboard"; 
		  }else {
			 
			 
				 model.addAttribute("msg","ログインが必要です。");
				 return "/login";
		  }
		
	
	}
	@RequestMapping("/replystudy")
	public String reply(@RequestParam("studyno") int studyno,@RequestParam("email") String email,RedirectAttributes rttr,@RequestParam("name") String name,@RequestParam("level") String level,@RequestParam("studyname") String studyname,@RequestParam("subject") String subject,@RequestParam("leader") String leader,@RequestParam("quota") String quota,@RequestParam("local") String local,@RequestParam("content") String content ,@RequestParam("leaderemail") String leaderemail,HttpSession session) {
		
		int StudyCnt = service.studyCnt(email); //자신이 지원할수 있는 스터디 최대 4개까지 
		logger.info("지금현재StudyCnt는?"+StudyCnt);
		int limit = Integer.parseInt(quota);   // 쿼터 (스터디원 최대수)
		ReplyVO vo=new ReplyVO();
		
		vo.setEmail(email);
		vo.setStudyno(studyno);
		vo.setLevel(level);
		vo.setName(name);
		vo.setStudyname(studyname);
		vo.setSubject(subject);
		vo.setLeader(leader);
	    vo.setLocal(local);
	    vo.setQuota(quota);
	    vo.setContent(content);
	    vo.setLeaderemail(leaderemail);
	    
	    
		if(dtservice.leaderAutho(vo)==true) {
			rttr.addFlashAttribute("msg", "本人のスタディーには参加できません");
			 return "redirect:/studyboard?subject=main" ;
		}else if(dtservice.reviewAttho(vo)==true) {
			rttr.addFlashAttribute("msg", "既に参加しているスタディーです。.");
			 return "redirect:/studyboard?subject=main" ;
		}else {
		
			
			logger.info("quota는?"+quota);
			   int limit_now =service.quotaCount(studyno);
			                  
			   logger.info("limitnow는?"+limit_now);
			
			   if(StudyCnt>=5) {
				   rttr.addFlashAttribute("msg", "スタディーは最大4個です。");	
					 return "redirect:/studyboard?subject=main" ;
				   			   
			   }else {
				  
				   if(limit>limit_now) {
						logger.info("지원하기에서studyno는"+studyno);
						logger.info("지원하기에서email는"+email);
						rttr.addFlashAttribute("msg", "参加しました");	
						 //service.addStudyCnt();
					

						service.reply(vo);
						logger.info("replycontroller에서vo는"+vo);
						
						return "redirect:/index";
					}else {
						System.out.println("");
						rttr.addFlashAttribute("msg", "定員オーバーです。");	
						 return "redirect:/studyboard?subject=main" ;
					}
				   
				   
			   }
		}
		

		   		
	}
		
	
}
