package com.ws.note.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.mtmasws.service.MasWS;

public class MtmasWSTest {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(MasWS.class);
		factoryBean.setAddress("http://211.139.6.203:8010/mtmasws/service/MasWS?wsdl");
		MasWS client = (MasWS) factoryBean.create();
		System.out.println(client.sendMsgs("gycgxt", "gycgxt08927", "18286142540", "���Ų���", "", "��������", null, null));
	}
}
