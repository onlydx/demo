package com.oracle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	public void SelectUser() {

		// 设定数据库驱动，数据库连接地址、端口、名称，用户名，密码
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // test为数据库名称，1521为连接数据库的默认端口
		String user = "guiyang"; // aa为用户名
		String password = "guiyang"; // 123为密码

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 数据库连接对象
		Connection conn = null;

		try {
			// 反射Oracle数据库驱动程序类
			Class.forName(driverName);

			// 获取数据库连接
			conn = DriverManager.getConnection(url, user, password);

			// 输出数据库连接
			System.out.println(conn);

			// 定制sql命令
			String sql = "select * from dcms_cws_case_count";

			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql);

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();

			// 将指针移到下一行，判断rs中是否有数据
			if (rs.next()) {
				// 输出查询结果
				System.out.println("查询到名为【" + rs.getString("streetname") + "】的信息");
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
