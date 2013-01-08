package ecsystem;

//引入sql包
import java.sql.*;

/**
 * @author 李新忠、徐琴芳、范茂林、刘书齐
 * @version 1.0
 */
// 数据库操作类
public class DBManager {
	// 定义返回结果集
	ResultSet rs;
	// 创建指定数据库的URL
	String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\ECSystem\\ECSystem.mdb";

	// 缺省构造方法
	public DBManager() {
	}

	// 查询方法，返回查询结果集
	public ResultSet getResult(String sql) {
		try {
			// 加载驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// 创建连接
			Connection conn = DriverManager.getConnection(url);
			// 创建statement对象
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 执行SQL语句，返回结果集
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("executeSql------" + sql);
			// 返回
			return rs;
		}
		// 异常处理
		catch (Exception e) {
			System.out.println("getResult------" + e.toString());
			// 若有异常，返回null
			return null;
		}
	}

	// 执行更新，删除语句方法
	public boolean executeSql(String sql) {
		try {
			// 加载驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// 创建连接
			Connection conn = DriverManager.getConnection(url);
			// 创建statement对象
			Statement stmt = conn.createStatement();
			// 执行SQL语句，返回结果集
			stmt.executeUpdate(sql);
			System.out.println("executeSql------" + sql);
			// 提交到数据库
			conn.commit();
			// 返回true，表示操作成功
			return true;
		} catch (Exception e) {
			System.out.println("executeSql------" + e.toString());
			// 返回false，表示操作失败
			return false;
		}
	}
}
