package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.Connect;
import model.User;

public class UserDao {

	Connection conn = Connect.getConnect();
	PreparedStatement p = null;
	ResultSet r = null;
	
	public boolean save(User u) {
		String sql = "insert into user(masv) values (?)";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, u.getMsv());
			return p.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(String msv) {
		String sql = "delete from user where masv = ?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, msv);
			return p.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean login(String msv) {
		String sql = "select * from user where masv = ?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, msv);
			r = p.executeQuery();
			if(r.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
