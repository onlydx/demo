package com.http.test;

import java.util.concurrent.CountDownLatch;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpAsyncClientTest {

	@Test
	public void test001() throws IOReactorException, InterruptedException {
		ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
		PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
		cm.setMaxTotal(100);
		CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(cm).build();
		httpAsyncClient.start();
		String[] urisToGet = { "http://www.chinaso.com/", "http://www.so.com/", "http://www.qq.com/", };
		final CountDownLatch latch = new CountDownLatch(urisToGet.length);
		for (final String uri : urisToGet) {
			final HttpGet httpget = new HttpGet(uri);
			httpAsyncClient.execute(httpget, new FutureCallback<HttpResponse>() {
				public void completed(final HttpResponse response) {
					latch.countDown();
					System.out.println(httpget.getRequestLine() + "->" + response.getStatusLine());
				}

				public void failed(final Exception ex) {
					latch.countDown();
					System.out.println(httpget.getRequestLine() + "->" + ex);
				}

				public void cancelled() {
					latch.countDown();
					System.out.println(httpget.getRequestLine() + " cancelled");
				}
			});
		}
		latch.await();
	}

	@Test
	public void test002() throws Exception {
		
		ChuanglanSMS client = new ChuanglanSMS("N2424471", "af923819");
		CloseableHttpResponse response = client.sendMessage("18585543142", "你的验证码是：20512051");
		if (response != null && response.getStatusLine().getStatusCode() == 200) {
			System.out.println(EntityUtils.toString(response.getEntity()));
		}

		// 查询余额
		response = client.queryBalance();
		if (response != null && response.getStatusLine().getStatusCode() == 200) {
			System.out.println(EntityUtils.toString(response.getEntity()));
		}

		client.close();
	}
}
