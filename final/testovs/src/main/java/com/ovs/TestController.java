package com.ovs;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ovs.services.LoginService;
import com.twilio.sdk.TwilioRestException;

@Controller
@RequestMapping("/login")
public class TestController {
	@Autowired	
	private LoginService loginService;

	@RequestMapping(value="/test",method = RequestMethod.GET)
	public @ResponseBody boolean test(){
		System.out.println("connnection sucessfull");
		return true;
	}
	
	@RequestMapping(value="/genOTP/{userId}",method = RequestMethod.POST)
	public @ResponseBody String genOTP(@PathVariable("userId") String userId) throws TwilioRestException, SQLException{
		System.out.println("in genOTP (TestController)");
		return loginService.genOTP(userId);
	}
	
	@RequestMapping(value="/validate/{userId}/{otp}",method = RequestMethod.POST)
	public @ResponseBody boolean validate(@PathVariable("userId") String userId, @PathVariable("otp") String otp) throws SQLException{
		System.out.println("in validate (TestController)");
		return loginService.validation(userId, otp);
	}
}
