package project.port.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.coobird.thumbnailator.Thumbnailator;

import project.port.domain.MemberForLeaderVO;
import project.port.domain.MemberVO;
import project.port.domain.ReplyVO;
import project.port.domain.ReviewVO;
import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;
import project.port.service.DetailService;



@Controller
public class DetailController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	
	@Autowired
	DetailService service;
	
	
	
	@RequestMapping("/detail")
	public String detail(HttpSession session,Model model) {
	 MemberVO vo = (MemberVO) session.getAttribute("userInpo");
	   	 //session に　emailがいるとログインがされてるってこと
	 if(vo !=null) {
		//今　現在参加しているスタディー
		 String email = vo.getEmail();
		List<StudyVO> list = service.forstudentList(email);		
		
		
		model.addAttribute("student", list);
		 //リーダーであるスタディーの参加管理
		 
		   List<MemberForLeaderVO> leaders_list = service.forLeaderList(email);
		;
		   model.addAttribute("leader",leaders_list);
		
		// スタディー　条件管理   
		 
		   List<StudyVO> modifylist =service.formodify(email) ;
		   
		   model.addAttribute("studyinpo",modifylist);
		
		   return  "/detail2";
	 }else {
		 
	
		 model.addAttribute("msg","ログインが必要です。");
		 return "/login";
	 }
		
		
	}
	//스터디 정보 수정
	@RequestMapping("/studymodify")
	public String studymodify(int studyno,String email,RedirectAttributes rttr,HttpSession session,Model model) {
		MemberVO memvo = (MemberVO) session.getAttribute("userInpo");
		String leaderemail = memvo.getEmail(); //권한 확인을 위해 session  값 가져오고
	
		ReplyVO vo =new ReplyVO() ;  
		vo.setStudyno(studyno);
		vo.setEmail(leaderemail);
		  logger.info("Detailcontroller에서vo는"+vo);
		boolean autho =service.modifyAutho(vo);
		 //logger.info("modifyauto");
	if(autho) {
			StudyVO studyvo=service.studyModifylist(studyno); // studyno 를 통해 스터디 정보 가져오고 
		  model.addAttribute("modifyinpo", studyvo);
			return "/StudyModify";
		}else {
			rttr.addFlashAttribute("msg", "正しくないアクセスです。");
			return "redirect:/index";
		}
		

	}
	
	@PostMapping("/studymodify")
	public String studymodifyEx(StudyVO vo ,Model model,RedirectAttributes rttr,MultipartFile[] uploadFile,HttpServletRequest request) {
		
		StudyVO stvo = new StudyVO(); 
				stvo= vo;
		String uploadFolder = request.getSession().getServletContext().getRealPath("/resources/upload");    
		String uploadFolderPath = getFolder();
				  	
				File uploadPath = new File(uploadFolder,uploadFolderPath);
			
				logger.info("uploadPath :"+uploadPath);
				if(uploadPath.exists()==false) {
					uploadPath.mkdirs();
				}  //make yyyy/MM/dd folder 
			 
			   for(MultipartFile multipartFile :uploadFile) {			
				  logger.info("---------------------");
				  logger.info("upload File Name:"+multipartFile.getOriginalFilename());
				  logger.info("uploadSize:"+multipartFile.getSize());
				  String uploadFileName = multipartFile.getOriginalFilename();
				  stvo.setFileName(uploadFileName);
		
				  UUID uuid = UUID.randomUUID();				     
				  uploadFileName = uuid.toString() + "_"+uploadFileName;
							  
			   try {
				  File saveFile = new File(uploadPath ,uploadFileName);
				   multipartFile.transferTo(saveFile);
				   stvo.setUuid(uuid.toString());
				   stvo.setUploadPath(uploadFolderPath);
				   System.out.println("PostMapping/StudymodifyStudyVO는"+stvo);   
				     boolean result = service.studymodify(stvo);
								   	   
				   //check image type file 
				   if(checkImageType(saveFile)) {  
					   FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					   FileOutputStream thumbnailIndex = new FileOutputStream(new File(uploadPath,"Index_"+uploadFileName));				  		  	   
					   Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,400,400);  //thumbnail for studyboard
					   Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnailIndex,200,200);   // thumbnail for mainPage					 
					   thumbnail.close();
				   }
					if(result) {
						rttr.addFlashAttribute("msg", "修正完了しました。"); 
				
						}else {
							rttr.addFlashAttribute("msg", "正しくないアクセスです。"); 
							
					  }
				   	   
			   }catch(Exception e) {
				   logger.error(e.getMessage());
			   }//end catch
			   			   
			   }//end for
			
			  return  "redirect:/detail";
	}
		
		
		
		

		
	
	
	//학생이 듣고있는 스터디 삭제 
	@RequestMapping("/studentdelete")
	public String studentdelete(int studyno,RedirectAttributes rttr,HttpSession session) {
		
		//본인만 삭제가능하게 하기 위해 세션에서의 값고 jsp에서 보낸값과 비교
	
		MemberVO memvo = (MemberVO) session.getAttribute("userInpo");
		  String studentemail= memvo.getEmail();
		ReplyVO vo = new ReplyVO() ;
		System.out.println("deleteStudyno는"+studyno);
	   
		vo.setStudyno(studyno);
		vo.setEmail(studentemail); //세션에서 가져온 email을 넣고  그것으로 본인이 듣고 있는 study인지 확인 service.reviewAttho(vo)
		 
		
		
		logger.info("DetailController에서ReplyVO는"+vo);
		//boolean autho =service.studentautho(vo);
       
		if( service.reviewAttho(vo)) {
			service.studentdelete(vo);
			rttr.addFlashAttribute("msg", "削除できませんでした。");
			
			return "redirect:/detail";
		}else {
			rttr.addAttribute("msg", "正しくないアクセスです。");
			return "redirect:/index";
		}
		
		
		

	
	}
	
	
	//스터디원 강퇴
	@RequestMapping("/leaderdelete")
  public String leaderdelete(int studyno,String email,HttpSession session,RedirectAttributes rttr) {
		MemberVO memvo = (MemberVO) session.getAttribute("userInpo");
	String leaderemail	= memvo.getEmail();
	 ReplyVO vo = new ReplyVO();  
	 //vo.setLeaderemail(leaderemail);
	 vo.setEmail(leaderemail); //권한 확인을 위해 
	 vo.setStudyno(studyno);
	if(service.leaderAutho(vo)==true) {
		vo.setEmail(email); //삭제할떄는studyno의 해당학생의email을 넣어서 삭제 
		service.leaderdelte(vo);
		
		rttr.addFlashAttribute("msg", "脱退させました。");
		return "redirect:/detail";
	}else {
		
		rttr.addFlashAttribute("msg", "正しくないアクセスです。");
		
		return "redirect:/index";
	}
	
	
		
	
  }
	@RequestMapping("/studydelete")
	public String studydelte(int studyno,HttpSession session,RedirectAttributes rttr) {
		MemberVO memvo = (MemberVO) session.getAttribute("userInpo"); 
		 ReplyVO vo = new ReplyVO();  
		String leaderemail	= memvo.getEmail();
		 vo.setEmail(leaderemail);;
          vo.setStudyno(studyno);
           System.out.println("Detail에서Studydelete의 VO는"+vo);
           System.out.println("Detail에서Studydelete의 권한은"+service.leaderAutho(vo));
          
           if(service.leaderAutho(vo)==true) {
      		
      		service.studydelete(studyno);
      		
      		rttr.addFlashAttribute("msg", "スタディーが廃棄できました。");
      		return "redirect:/detail";
      	}else {
      		
      		rttr.addFlashAttribute("msg", "正しくないアクセスです。");
      		
      		return "redirect:/index";
      	}
          
		
		
	}
	
	@RequestMapping("/reviewWrite")
	public String  reviewWrite(int studyno, HttpSession session,RedirectAttributes rttr,Model model) {
		MemberVO memvo = (MemberVO) session.getAttribute("userInpo");
		ReplyVO vo= new ReplyVO();
		String reviewer =memvo.getEmail();
		 vo.setStudyno(studyno);
		 vo.setEmail(reviewer);
		if(service.reviewAttho(vo)==true) {
		
				StudyVO studyvo=service.studyModifylist(studyno); // studyno 를 통해 스터디 정보 가져오고 
			  model.addAttribute("modifyinpo", studyvo);
				
		
		
			
			
			return "reviewWrite";
		}else {
			rttr.addFlashAttribute("msg", "正しくないアクセスです。");
		 
		return   "redirect:/index";
	   }
	}
	    // 리뷰작성완료  
		@PostMapping("/reviewWriteEx" )
		public String  reviewWriteEx(ReviewVO vo, HttpSession session,RedirectAttributes rttr,@RequestParam("studyno") int studyno) {
			MemberVO memvo = (MemberVO) session.getAttribute("userInpo");
			ReplyVO rlyvo = new ReplyVO();
			String reviewer =memvo.getEmail();
			logger.info("review에서studyno"+studyno);
			rlyvo.setStudyno(studyno);
			rlyvo.setEmail(reviewer);
			if(service.reviewAttho(rlyvo)==true) {
		        logger.info("reviewVO에 넣으려고 하는 정보는 이것입니다 !!"+vo);
				if(service.review(vo)) {
					logger.info("review등록성공");
					rttr.addFlashAttribute("msg", "レビュー作成　ありがとうございます。");
				}else {
					rttr.addFlashAttribute("msg", "もう一度確認お願い致します。");
				}
		        
		        
		        
		        return "redirect:/review?subject=main";
			}else {
				rttr.addFlashAttribute("msg", "正しくないアクセスです。");
			 
			return   "redirect:/index?subject=main";
		}
	
	
	}
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		
		return str.replace("-", File.separator);
	}
	
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false ;
	}
	
	
	
	
	

}
