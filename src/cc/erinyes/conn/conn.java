package cc.erinyes.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {

	public Connection getCon() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				System.out.println("找不到驱动程序类 ，加载驱动失败！");   
			    e.printStackTrace() ;
			}
			String url = "jdbc:mysql://localhost:3306/mysys?characterEncoding=utf-8";
			String user = "root";
			String password = "root";
			try {
				Connection conn = DriverManager.getConnection(url, user, password);	
				System.out.println(conn.getMetaData().getURL());
				return conn;
			} catch (SQLException se) {
				// TODO: handle exception
				System.out.println("数据库连接失败！");   
			    se.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

}
