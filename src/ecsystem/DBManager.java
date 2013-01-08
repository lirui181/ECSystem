package ecsystem;

//����sql��
import java.sql.*;

/**
 * @author �����ҡ����ٷ�����ï�֡�������
 * @version 1.0
 */
// ���ݿ������
public class DBManager {
	// ���巵�ؽ����
	ResultSet rs;
	// ����ָ�����ݿ��URL
	String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\ECSystem\\ECSystem.mdb";

	// ȱʡ���췽��
	public DBManager() {
	}

	// ��ѯ���������ز�ѯ�����
	public ResultSet getResult(String sql) {
		try {
			// ������������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// ��������
			Connection conn = DriverManager.getConnection(url);
			// ����statement����
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// ִ��SQL��䣬���ؽ����
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("executeSql------" + sql);
			// ����
			return rs;
		}
		// �쳣����
		catch (Exception e) {
			System.out.println("getResult------" + e.toString());
			// �����쳣������null
			return null;
		}
	}

	// ִ�и��£�ɾ����䷽��
	public boolean executeSql(String sql) {
		try {
			// ������������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// ��������
			Connection conn = DriverManager.getConnection(url);
			// ����statement����
			Statement stmt = conn.createStatement();
			// ִ��SQL��䣬���ؽ����
			stmt.executeUpdate(sql);
			System.out.println("executeSql------" + sql);
			// �ύ�����ݿ�
			conn.commit();
			// ����true����ʾ�����ɹ�
			return true;
		} catch (Exception e) {
			System.out.println("executeSql------" + e.toString());
			// ����false����ʾ����ʧ��
			return false;
		}
	}
}
