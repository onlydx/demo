package com.mtmasws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MasWS {

	/**
	 * WebService接口方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param desphone
	 *            手机号
	 * @param msg
	 *            信息内容
	 * @param extendnumber
	 *            扩展号码
	 * @param taskname
	 *            任务名
	 * @param reserve1
	 *            备用字段1
	 * @param reserve2
	 *            备用字段2
	 * @return
	 */
	@WebMethod(operationName = "sendMsgs")
	public String sendMsgs(
			@WebParam(name = "username", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String username,
			@WebParam(name = "password", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String password,
			@WebParam(name = "desphone", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String desphone,
			@WebParam(name = "msg", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String msg,
			@WebParam(name = "extendnumber", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String extendnumber,
			@WebParam(name = "taskname", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String taskname,
			@WebParam(name = "reserve1", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String reserve1,
			@WebParam(name = "reserve2", targetNamespace = "http://service.mtmasws.com/", mode = WebParam.Mode.IN) String reserve2);
}
