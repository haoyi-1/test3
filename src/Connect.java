import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class connect{
	private String driverName;
	private String dbURL;
	private String userName;
	private String userPwd;
	Connection dbConn;
	Statement stmt;
	public connect(String driverName, String dbURL, String userName, String userPwd) {
		super();
		this.driverName = driverName;
		this.dbURL = dbURL;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	public void init() {
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//����
	public void insert(String s) {
		try {
			stmt = dbConn.createStatement();
			int m = stmt.executeUpdate(s);
			if(m>0) {
				JOptionPane.showMessageDialog(null,"��ӳɹ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//��ѯ
	public ResultSet query(String s){
		try{
			stmt = dbConn.createStatement();
			ResultSet rset = stmt.executeQuery(s);
			return rset;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//ɾ��
	public void delete(String s) {
		try {
			stmt = dbConn.createStatement();
			int m = stmt.executeUpdate(s);
			if(m>0) {
				JOptionPane.showMessageDialog(null,"ɾ���ɹ���");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����
		public void update(String s) {
			try {
				stmt = dbConn.createStatement();
				int m = stmt.executeUpdate(s);
				if(m>0) {
					//JOptionPane.showMessageDialog(null,"��Ϣ�޸ĳɹ���");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	//�ر�
	public void close() {
		try {
			dbConn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}