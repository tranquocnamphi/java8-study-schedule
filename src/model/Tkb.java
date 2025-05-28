package model;

import java.sql.Date;

public class Tkb {

	private int id;
	
	private String tenMonHoc;
	
	private String gioBatDau;
	
	private String gioKetThuc;
	
	private String thu;
	
	private String tuan;
	
	private String listTuanHoc;
	
	private Date ngayHoc;
	
	private String loaiMonHoc;
	
	private String phongHoc;
	
	private String masv;

	public Tkb() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getTuan() {
		return tuan;
	}

	public void setTuan(String tuan) {
		this.tuan = tuan;
	}

	public String getListTuanHoc() {
		return listTuanHoc;
	}

	public void setListTuanHoc(String listTuanHoc) {
		this.listTuanHoc = listTuanHoc;
	}

	public Date getNgayHoc() {
		return ngayHoc;
	}

	public void setNgayHoc(Date ngayHoc) {
		this.ngayHoc = ngayHoc;
	}

	public String getLoaiMonHoc() {
		return loaiMonHoc;
	}

	public void setLoaiMonHoc(String loaiMonHoc) {
		this.loaiMonHoc = loaiMonHoc;
	}

	public String getPhongHoc() {
		return phongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	@Override
	public String toString() {
		return "Tkb [id=" + id + ", tenMonHoc=" + tenMonHoc + ", gioBatDau=" + gioBatDau + ", gioKetThuc=" + gioKetThuc
				+ ", thu=" + thu + ", tuan=" + tuan + ", listTuanHoc=" + listTuanHoc + ", ngayHoc=" + ngayHoc
				+ ", loaiMonHoc=" + loaiMonHoc + ", phongHoc=" + phongHoc + ", masv=" + masv + "]";
	}
	
	
}
