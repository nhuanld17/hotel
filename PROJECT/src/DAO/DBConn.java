package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
    private String status;
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String user = "root";
    private String pwd = "nhuan.142857";
    Connection con;
    
    public DBConn() {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			status = "Kết nối thành công";
		} catch (Exception e) {
			status = "Lỗi";
			e.printStackTrace();
		}
	}
    public Connection getCon() {
		return con;
	}
    public ResultSet queryDB(String query) throws Exception{
		Statement statement = this.getCon().createStatement();
		return statement.executeQuery(query);
	}
    public int updateDB(String query) throws Exception {
        Statement st=this.getCon().createStatement();
        return st.executeUpdate(query);
    }
}
