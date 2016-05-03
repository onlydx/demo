package com.mtmasws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MasWS {

	/**
	 * WebService�ӿڷ���
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @param desphone
	 *            �ֻ���
	 * @param msg
	 *            ��Ϣ����
	 * @param extendnumber
	 *            ��չ����
	 * @param taskname
	 *            ������
	 * @param reserve1
	 *            �����ֶ�1
	 * @param reserve2
	 *            �����ֶ�2
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
