package com.bridgelab.microfundoo.MicroUtil;

//import com.bridgelabz.fundoo.user.model.Response;
//import com.bridgelabz.fundoo.user.model.ResponseToken;

public class ResponseUtil {

	public static Response getResponse(int statusCode,String statusMessage) {
			Response response=new Response();       
			response.setStatusCode(statusCode);
			response.setStatusMessage(statusMessage);
			return response;
		}
		public static Response getResponseNname(int statusCode,String statusMessage,String Name) {
			Response response=new Response();
			response.setStatusCode(statusCode);
			response.setStatusMessage(statusMessage);
			response.setName(Name);
			return response;
		}
		public static ResponseToken getResponseToken(int statusCode,String statusMessage,String token,String email)
		{	ResponseToken res=new ResponseToken();
			res.setStatuscode(statusCode);
			res.setStatusmessage(statusMessage);
			res.setToken(token);
			res.setEmail(email);
			return res;
		}
}
