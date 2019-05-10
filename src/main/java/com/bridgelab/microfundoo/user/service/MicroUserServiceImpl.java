package com.bridgelab.microfundoo.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bridgelab.microfundoo.MicroUtil.EmailUtil;
import com.bridgelab.microfundoo.MicroUtil.Response;
import com.bridgelab.microfundoo.MicroUtil.ResponseToken;
import com.bridgelab.microfundoo.MicroUtil.ResponseUtil;
import com.bridgelab.microfundoo.MicroUtil.UserToken;
import com.bridgelab.microfundoo.user.DTO.ForgotDTO;
import com.bridgelab.microfundoo.user.DTO.LoginDTO;
import com.bridgelab.microfundoo.user.DTO.MicroUserDTO;
import com.bridgelab.microfundoo.user.DTO.ResetPasswordDTO;
import com.bridgelab.microfundoo.user.Repository.MicroUserRepo;
import com.bridgelab.microfundoo.user.model.MicroUserModel;

@Service
public class MicroUserServiceImpl implements MicroUserService {
	@Autowired
	private MicroUserRepo userRepository;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private EmailUtil emailUtil = new EmailUtil();
	
	@Override
	public Response register(MicroUserDTO userDTO,HttpServletResponse httpresponse) throws Exception 
	{	
		userDTO.setCreated_date(LocalDateTime.now());
		MicroUserModel user=modelMapper.map(userDTO,MicroUserModel.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
		user.setEmail(userDTO.getEmail());
		httpresponse.addHeader("Name",userDTO.getFirstName()+userDTO.getLastName());
		user=userRepository.save(user);	
		//emailUtil.send(user.getEmail(),"mail for Registration", getUrl(user.getId()));
		Response response = ResponseUtil.getResponseNname(201,"Register Done successfully",userDTO.getFirstName()+userDTO.getLastName());
		return response;
	}

	@Override
	public ResponseToken login(LoginDTO loginuser, HttpServletResponse httpresponse) throws Exception {
		// && is_user_available.get().isVerification()
		Optional<MicroUserModel> is_user_available=userRepository.findByEmail(loginuser.getEmail());
		if(is_user_available.isPresent() && passwordEncoder.matches(loginuser.getPassword(),is_user_available.get().getPassword())) 
		{ 	
			String generatedToken = UserToken.generateToken(is_user_available.get().getId());
			httpresponse.addHeader("JWT-Token",generatedToken);
			httpresponse.addHeader("email",loginuser.getEmail());
			ResponseToken response =ResponseUtil.getResponseToken(200,"Login Done successfully",generatedToken,loginuser.getEmail());
			return response; 
		} 
		else 
		{ throw new Exception("Email and Password is not found");}
	
	}

	@Override
	public String validateEmailId(String token) throws Exception {
		Long id=UserToken.verifyToken(token);
		MicroUserModel user=userRepository.findById(id).orElseThrow(()->new Exception("User not found")); 
		user.setVerification(true);
		userRepository.save(user);
		return "Successfully verified";

	}
	@Override
	public Response forgotPassword(ForgotDTO forget) throws Exception
	{	Optional<MicroUserModel> is_user_available=userRepository.findByEmail(forget.getEmailId());
	if(is_user_available.isPresent())
	{	MicroUserModel user=is_user_available.get();
	
	emailUtil.send(user.getEmail(),"E-mail varified successfully",getUrl(user.getId()));
	Response response=ResponseUtil.getResponse(200,"Success");
	return response;
	}
	else
	{throw new Exception("Email not found");}

	}
	@Override
	public Response resetPassword(String token, ResetPasswordDTO password) throws Exception
	{	
		Long id=UserToken.verifyToken(token);
		MicroUserModel user=userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
		System.out.println(password.getConfirm_password());
		if(password.getRe_password().equals(password.getConfirm_password()))
		{
			user.setPassword(passwordEncoder.encode(password.getRe_password()));
			user.setConfirmPassword(passwordEncoder.encode(password.getConfirm_password()));
			userRepository.save(user);
			Response response=ResponseUtil.getResponse(201,"Success");
			return response;
		}
		else
		{	throw new Exception("Email not found"); 
		}

	}
	public String getUrl(Long id) throws Exception
	{
		return "http://localhost:8086/validation/"+UserToken.generateToken(id);
	}
	public MicroUserModel getUser(String token) throws Exception
	{	
		Long id=UserToken.verifyToken(token);
		MicroUserModel user=userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
		return user;
	}
	
}
