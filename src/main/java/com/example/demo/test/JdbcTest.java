package com.example.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;


@Component
public class JdbcTest {
	public void test() throws SQLException, ClassNotFoundException {
		// 1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获得数据库链接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mike?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
		// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from girl");
		// 4.处理数据库的返回结果(使用ResultSet类)
		while (rs.next()) {
			System.out.println(rs.getString("id") + " " + rs.getString("name"));
		}

		// 关闭资源
		rs.close();
		st.close();
		conn.close();
	}
}