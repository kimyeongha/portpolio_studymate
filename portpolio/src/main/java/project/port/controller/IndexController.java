package project.port.controller;






import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.port.domain.MemberVO;
import project.port.domain.ReviewVO;
import project.port.domain.StudyVO;
import project.port.service.IndexService;
import project.port.service.LoginService;
import project.port.service.MemberRegisterService;
import project.port.service.StudyBoardService;





@Controller

public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
   @Autowired 
   private MemberRegisterService service;
   @Autowired 
   private LoginService servicelog;
   @Autowired 
   private IndexService indexService;
   private StudyBoardService boardservice;
		
   
	@RequestMapping("/index")
     public String list(Model model) throws Exception {
    List<StudyVO> vo =	indexService.getList();
    List<ReviewVO>revo = indexService.reviewList();
    
	
    model.addAttribute("list", vo);
    model.addAttribute("reviewlist", revo);
	
		
    logger.info("index에서vo는?"+vo);
    logger.info("성공했습니다.");
    	 
    
    	
    return "/index";
    }
    	
   	

	@PostMapping("/login")
	public String login(HttpSession session,MemberVO vo,RedirectAttributes rttr) {
	
		 MemberVO client = servicelog.login(vo);
		if(client==null) {
		
			rttr.addFlashAttribute("msg","ログインに失敗しました。もう一度確認お願いします。");
			 return "redirect:/login";
		}else {
		    rttr.addFlashAttribute("msg", client.getName()+"様　　ようこそ！");
		
		    session.setAttribute("userInpo",client);
			
			return "redirect:/index";
		}
	
	}
	
	
	
	
	@GetMapping("/login")
	public void login() {
		logger.info("로그인화면으로");
	}
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		logger.info("로그아웃화면으로");
		session.invalidate();
		return "redirect:/index";
	}
	@GetMapping("/register")
	public void register() {
		logger.info("등록창!!");
	}
	@PostMapping("/memberregister")
  public String memberRegister(RedirectAttributes rttr,MemberVO vo) {
		
	   String email=  vo.getEmail();
	     
    try {
    	
		boolean result =  service.emailcheck(email);
		
		if(result) {
			rttr.addFlashAttribute("msg", "重複確認ボタンを押してください");   
			return "redirect:/register";
			    
		}else{
			logger.info("회원가입");
	 		  if (service.register(vo)) {
	 			  rttr.addFlashAttribute("msg", "会員登録　おめでとうございます!");
	 		  }else {
	 			  rttr.addFlashAttribute("msg", "会員登録に　失敗しました。!");
	 		  }	
		}
		
	} catch (Exception e) {
	
		e.printStackTrace();
	} 
    		
 		
     
    return "redirect:/index";
    	
     }
		
	
	
	
	 @ResponseBody
	 @RequestMapping(value="/emailChk",method=RequestMethod.POST)
	 public boolean emailChk(String email) throws Exception {
		  
		boolean result =  service.emailcheck(email); 
		 
		return result ;
	 }

	
	












}
