package com.downurl.ltdownload.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.downurl.ltdownload.utils.ResultMsg;

 

@RestController
public class ToolsController {
	
	
    @RequestMapping(value = "uploadfile", method = RequestMethod.POST)   //@RequestParam(value = "imageFile") MultipartFile  imageFile,
    public Object testdown( HttpServletRequest request) {
    	ResultMsg resultMsg =   new ResultMsg( 0, "OK","");  
    	return resultMsg;
    }

}
