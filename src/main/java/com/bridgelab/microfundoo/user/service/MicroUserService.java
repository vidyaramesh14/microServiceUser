package com.bridgelab.microfundoo.user.service;

//import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.bridgelab.microfundoo.MicroUtil.Response;
import com.bridgelab.microfundoo.MicroUtil.ResponseToken;
import com.bridgelab.microfundoo.user.DTO.ForgotDTO;
import com.bridgelab.microfundoo.user.DTO.LoginDTO;
import com.bridgelab.microfundoo.user.DTO.MicroUserDTO;
import com.bridgelab.microfundoo.user.DTO.ResetPasswordDTO;
//import com.bridgelab.microfundoo.user.model.MicroUserModel;

public interface MicroUserService {
	public Response register(MicroUserDTO userDTO,HttpServletResponse httpresponse) throws Exception;
	public ResponseToken login(LoginDTO loginuser,HttpServletResponse resp) throws Exception ;
	public String validateEmailId(String token) throws Exception; 
	public Response forgotPassword(ForgotDTO forget) throws Exception;
	public Response resetPassword(String token,ResetPasswordDTO password) throws Exception;
	//public List<MicroUserModel> getusers();
}
