package com.downurl.ltdownload.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.downurl.ltdownload.utils.ResultMsg;

 

@Controller
//@RequestMapping("/livex")
public class TesthtmlController {
	
	
    @RequestMapping(value = "/test")   //@RequestParam(value = "imageFile") MultipartFile  imageFile,
    public String testH( HttpServletRequest request) {
    	System.out.println("--------------==============1111111111111111111111111");
    	//ResultMsg resultMsg =   new ResultMsg( 0, "OK","");  
    	return "testH.html";
    }

}
