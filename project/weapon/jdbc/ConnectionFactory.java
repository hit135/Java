package weapon.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private String driver, url, id, password;
	private int maxConn;
	
private static ConnectionFactory instance = new ConnectionFactory();
	
	public static ConnectionFactory getInstance() {
		return instance;
	}
	
	private ConnectionFactory() {

		Properties prop = new Properties();

		InputStream reader = getClass().getClassLoader().getResourceAsStream("config/db.properties");
		// key value로 받아오는데 전부 string 값으로 받아온다!

		try {
			prop.load(reader);

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			password = prop.getProperty("password");
			maxConn = Integer.parseInt(prop.getProperty("maxConn"));

			// 드라이버 로딩
			Class.forName(driver);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public int getMaxconn() {
		return maxConn;
	}

	// DB와 연결되는 Connection 객체를 생성해서 리턴하는 메소드
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, id, password);
		return conn;
	}
	
	
	
	
	
	
	
	
}
