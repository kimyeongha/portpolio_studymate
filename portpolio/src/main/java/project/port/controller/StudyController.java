package project.port.controller;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.coobird.thumbnailator.Thumbnailator;

import project.port.domain.MemberVO;
import project.port.domain.StudyAttachVO;
import project.port.domain.StudyVO;
import project.port.service.StudyRegisterService;





@Controller


public class StudyController {
	private static final Logger logger = LoggerFactory.getLogger(StudyController.class);
	@Autowired 
	private StudyRegisterService service;

	@GetMapping("/studyregister")
     public String register(HttpSession session,Model model) {
		
		
		MemberVO vo = (MemberVO) session.getAttribute("userInpo");
		
    
		 if(vo !=null) {
			 String email =vo.getEmail();
			  int leaderlimit= service.leaderlimit(email);	
			 logger.info("성공했습니다.");
			  model.addAttribute("leaderlimit", leaderlimit);
			 return "studyRegister";
				}

				else {
					model.addAttribute("msg","ログインが必要です。");
					 return "/login";	
					
				}
	
	
    	
    	
	}
	

	@PostMapping("/studyregister")
	public String registerCo(StudyVO vo ,Model model,RedirectAttributes rttr,MultipartFile[] uploadFile,HttpServletRequest request) {
	
		if(uploadFile==null) {
			  rttr.addFlashAttribute("msg", "写真添付は必修です。" ); 
			  return  "redirect:/studyregister";
		}else {
			String uploadFolder = request.getSession().getServletContext().getRealPath("/resources/upload");     
			String email =vo.getEmail();
			String uploadFolderPath = getFolder();
			  int leaderlimit= service.leaderlimit(email);	
			  logger.info("leaderlimitd은?"+leaderlimit);
			  if(leaderlimit>=3) {
				  rttr.addFlashAttribute("msg", "スタディーは最大３個までです 。"); 
				  return  "redirect:/studyregister";
			  }else {
					File uploadPath = new File(uploadFolder,uploadFolderPath);
				
					if(uploadPath.exists()==false) {
						uploadPath.mkdirs();
					}  //make yyyy/MM/dd folder 
				  
				   for(MultipartFile multipartFile :uploadFile) {
					  String uploadFileName = multipartFile.getOriginalFilename();
					  vo.setFileName(uploadFileName);
					  UUID uuid = UUID.randomUUID();			     
					  uploadFileName = uuid.toString() + "_"+uploadFileName;
						  
				   try {
					  File saveFile = new File(uploadPath ,uploadFileName);
					   multipartFile.transferTo(saveFile);
					   vo.setUuid(uuid.toString());
					   vo.setUploadPath(uploadFolderPath);
			
					     boolean result = service.Register(vo);
							   	   
					   //check image type file 
					   if(checkImageType(saveFile)) {
						   
						   FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
						   FileOutputStream thumbnailIndex = new FileOutputStream(new File(uploadPath,"Index_"+uploadFileName));
						   				  		  
						   Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,400,400);
						   Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnailIndex,200,200);
						 
						   thumbnail.close();
					   }
						if(result) {
							
							rttr.addFlashAttribute("msg", "リーダーになりました。おめでとうございます"); 
					
							}else {
								rttr.addFlashAttribute("msg", "もう一度確認お願いします。"); 
							
						
						  }
					   
					   
				   }catch(Exception e) {
					   logger.error(e.getMessage());
				   }//end catch
				   
				   
				   
				   }//end for
				
		

				  return  "redirect:/index";


		} //else end

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
