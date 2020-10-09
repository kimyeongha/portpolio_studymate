package project.port.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadPathTest {
	private static final Logger logger = LoggerFactory.getLogger(UploadPathTest.class);
	@RequestMapping(value = "/test", method = RequestMethod.GET)

	public ModelAndView test(HttpServletRequest request) 

	{

//		Set pathSet = request.getSession().getServletContext().getResourcePaths("/");

//		System.out.println(pathSet);	



		String pdfPath = request.getSession().getServletContext().getRealPath("/resources/upload/s_d73a80f4-743d-402c-bd74-29cde8881e10_photo_default200.jpg");

		System.out.println(new File(pdfPath).exists());	



		return null;

	}


	
	
	
}
