package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	// kết nối csdl
	public static Connection getConnect() {
		Connection connect = null;
		try {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltkb", "root", "");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return connect;
	}
	

}
