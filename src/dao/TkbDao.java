package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import model.Tkb;
import service.UserSession;

public class TkbDao {

	Connection conn = Connect.getConnect();
	PreparedStatement p = null;
	ResultSet r = null;
	
	public boolean save(Tkb t) {
		String sql = "insert into tkb(tenMonHoc,gioBatDau,gioKetThuc,thu,tuan,listTuanHoc,ngayHoc,loaiMonHoc,phongHoc,masv ) "
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, t.getTenMonHoc());
			p.setString(2, t.getGioBatDau());
			p.setString(3, t.getGioKetThuc());
			p.setString(4, t.getThu());
			p.setString(5, t.getTuan());
			p.setString(6, t.getListTuanHoc());
			p.setDate(7, t.getNgayHoc());
			p.setString(8, t.getLoaiMonHoc());
			p.setString(9, t.getPhongHoc());
			p.setString(10, t.getMasv());
			return p.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(String tenmh, String loaiMh) {
		String sql = "delete from tkb where tenMonHoc = ? and masv = ? and loaiMonHoc = ?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, tenmh);
			p.setString(2, UserSession.userId);
			p.setString(3, loaiMh);
			return p.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Tkb> getTkbByDate(Date s1, Date s2){
		List<Tkb> list = new ArrayList<Tkb>();
		String sql = "select * from tkb where ngayHoc >= ? and ngayHoc <= ? and masv = ? order by thu asc";
		try {
			p = conn.prepareStatement(sql);
			p.setDate(1, s1);
			p.setDate(2, s2);
			p.setString(3, UserSession.userId);
			r = p.executeQuery();
			while(r.next()) {
				Tkb t = new Tkb();
				t.setId(r.getInt("id"));
				t.setGioBatDau(r.getString("gioBatDau"));
				t.setGioKetThuc(r.getString("gioKetThuc"));
				t.setListTuanHoc(r.getString("listTuanHoc"));
				t.setLoaiMonHoc(r.getString("loaiMonHoc"));
				t.setMasv(r.getString("masv"));
				t.setPhongHoc(r.getString("phongHoc"));
				t.setTenMonHoc(r.getString("tenMonHoc"));
				t.setThu(r.getString("thu"));
				t.setTuan(r.getString("tuan"));
				t.setNgayHoc(r.getDate("ngayHoc"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tkb> getTkbByADay(Date s1){
		List<Tkb> list = new ArrayList<Tkb>();
		String sql = "select * from tkb where ngayHoc = ? and masv = ? order by thu asc";
		try {
			p = conn.prepareStatement(sql);
			p.setDate(1, s1);
			p.setString(2, UserSession.userId);
			r = p.executeQuery();
			while(r.next()) {
				Tkb t = new Tkb();
				t.setId(r.getInt("id"));
				t.setGioBatDau(r.getString("gioBatDau"));
				t.setGioKetThuc(r.getString("gioKetThuc"));
				t.setListTuanHoc(r.getString("listTuanHoc"));
				t.setLoaiMonHoc(r.getString("loaiMonHoc"));
				t.setMasv(r.getString("masv"));
				t.setPhongHoc(r.getString("phongHoc"));
				t.setTenMonHoc(r.getString("tenMonHoc"));
				t.setThu(r.getString("thu"));
				t.setTuan(r.getString("tuan"));
				t.setNgayHoc(r.getDate("ngayHoc"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
