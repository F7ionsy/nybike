package cn.tedu.nybike.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil2 {
	static String url ="jdbc:hive2://47.100.78.24:10000/nybikedb";
	static String username = "root";
	static String password = "123";
	static {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getHiveConn() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
}
