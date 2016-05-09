package com.oracle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	public void SelectUser() {

		// �趨���ݿ����������ݿ����ӵ�ַ���˿ڡ����ƣ��û���������
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // testΪ���ݿ����ƣ�1521Ϊ�������ݿ��Ĭ�϶˿�
		String user = "guiyang"; // aaΪ�û���
		String password = "guiyang"; // 123Ϊ����

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// ���ݿ����Ӷ���
		Connection conn = null;

		try {
			// ����Oracle���ݿ�����������
			Class.forName(driverName);

			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(url, user, password);

			// ������ݿ�����
			System.out.println(conn);

			// ����sql����
			String sql = "select * from dcms_cws_case_count";

			// �����������µ�PreparedStatement����
			pstmt = conn.prepareStatement(sql);

			// ִ�в�ѯ��䣬�����ݱ��浽ResultSet������
			rs = pstmt.executeQuery();

			// ��ָ���Ƶ���һ�У��ж�rs���Ƿ�������
			if (rs.next()) {
				// �����ѯ���
				System.out.println("��ѯ����Ϊ��" + rs.getString("streetname") + "������Ϣ");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new OracleTest().SelectUser();
	}
}
