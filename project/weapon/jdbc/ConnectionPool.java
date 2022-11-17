package weapon.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;


public class ConnectionPool {
	
private static Vector<Connection> pool = new Vector<Connection>();
	
	private ConnectionPool() {
		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	private synchronized void initPool() throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance();
		int maxConn = factory.getMaxconn();
		
		for (int i = 0; i < maxConn; i++) {
			pool.add(factory.getConnection());
		}
	}
	
	// 커넥션 담고 풀에서 지우고 리턴
	// 동기화를 위해 vector를 사용 그리고 synchronized도 사용
	// 커넥션 가져오기!
	public synchronized Connection getConnection() {
		if (pool.size() == 0) {
			try {
				wait(); // 남은 커넥션이 없을때 기다리기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pool.get(0);
		pool.remove(0);
		
		return conn;
	}
	
	// 커넥션 반납하기!
	public synchronized void releaseConnection(Connection x) {
		pool.add(x);
		notify(); // 기다리는 커넥션 있다면 풀어주기
	}
	
	public synchronized void destroyPool() {
		// Connection 객체 다 닫아주기!
		for (int i = 0; i < pool.size(); i++) {
			try {
				pool.get(i).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		pool.clear();
	}
}
