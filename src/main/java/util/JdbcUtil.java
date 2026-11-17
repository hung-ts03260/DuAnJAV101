package util;

import java.sql.*;

public class JdbcUtil {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=DuAnJava;encrypt=false";
	static String username = "sa";
	static String password = "Fx-580vnx";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// Mở kết nối
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, username, password);
	}

	// Tạo PreparedStatement
	public static PreparedStatement createPreStmt(Connection conn, String sql, Object... values) throws SQLException {

		PreparedStatement stmt = conn.prepareStatement(sql);

		for (int i = 0; i < values.length; i++) {
			stmt.setObject(i + 1, values[i]);
		}

		return stmt;
	}

	// Thêm, sửa, xóa dữ liệu
	public static int executeUpdate(String sql, Object... values) throws SQLException {

		try (Connection conn = getConnection(); PreparedStatement stmt = createPreStmt(conn, sql, values)) {
			return stmt.executeUpdate();
		}
	}

	// Truy vấn dữ liệu
	public static ResultSet executeQuery(Connection conn, String sql, Object... values) throws SQLException {

		PreparedStatement stmt = createPreStmt(conn, sql, values);
		stmt.closeOnCompletion();
		return stmt.executeQuery();
	}
}
