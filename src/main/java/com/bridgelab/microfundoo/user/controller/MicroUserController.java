package com.bridgelab.microfundoo.user.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelab.microfundoo.MicroUtil.Response;
import com.bridgelab.microfundoo.MicroUtil.ResponseToken;
import com.bridgelab.microfundoo.user.DTO.ForgotDTO;
import com.bridgelab.microfundoo.user.DTO.LoginDTO;
import com.bridgelab.microfundoo.user.DTO.MicroUserDTO;
import com.bridgelab.microfundoo.user.DTO.ResetPasswordDTO;
import com.bridgelab.microfundoo.user.model.MicroUserModel;
import com.bridgelab.microfundoo.user.service.MicroUserServiceImpl;

@RestController
public class MicroUserController {
	@Autowired  
	private MicroUserServiceImpl userServices;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@Valid @RequestBody MicroUserDTO userDTO,HttpServletResponse httpresponse) throws Exception {		
		Response response = userServices.register(userDTO,httpresponse);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@GetMapping("/validation/{token}")
	public String emailValidation(@PathVariable String token) throws Exception {
		System.out.println(token);
		String result = userServices.validateEmailId(token);
		return result;
	}
	@PostMapping("/login")
	public ResponseEntity<ResponseToken> login(@Valid @RequestBody LoginDTO loginDTO,	HttpServletResponse httpresponse) throws Exception {
		ResponseToken response = userServices.login(loginDTO, httpresponse);
		return new ResponseEntity<ResponseToken>(response, HttpStatus.OK);
	}
	@PostMapping("/forgotPassword")
	public ResponseEntity<Response> forgotPassword(@RequestBody ForgotDTO forget) throws Exception {
		
		Response response = userServices.forgotPassword(forget);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/resetPassword/{token}")
	public ResponseEntity<Response> resetPassword(@PathVariable String token, @RequestBody ResetPasswordDTO re_password)throws Exception {
		
		Response user = userServices.resetPassword(token, re_password);
		return new ResponseEntity<Response>(user, HttpStatus.OK);
	}
	@GetMapping("/getUser")
	public MicroUserModel getUser(@RequestHeader(name="JWT-Token")String token) throws Exception {
		MicroUserModel user= userServices.getUser(token);
		System.out.println("###############"+user);
		return user;
	}
}
