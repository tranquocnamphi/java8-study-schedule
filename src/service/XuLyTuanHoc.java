package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class XuLyTuanHoc {

	// ds tuan hoc nhap dang : 2-10,12-15,16-21, định dạng: 8,9,12
	public List<Date> getListDate(String dsTuanHoc, int thu){
		List<Date> list = new ArrayList<Date>();
		String str[] = dsTuanHoc.split(",");
		for(int i=0; i<str.length; i++) {
			String tuan[] = str[i].split("-");
			if(tuan.length == 2) {
				List<String> tuans = new ArrayList<String>();
				for(int k = Integer.valueOf(tuan[0]); k < Integer.valueOf(tuan[1])+1; k++) {
					tuans.add(String.valueOf(k));
				}
				for(int j=0; j< tuans.size(); j++) {
					Date ngayHoc = getNgayHoc(Integer.valueOf(tuans.get(j)), thu);
					list.add(ngayHoc);
				}
			}
			else {
				Date ngayHoc = getNgayHoc(Integer.valueOf(tuan[0]), thu);
				list.add(ngayHoc);
			}
		}
		return list;
	}
	
	
	// lấy ngày học dựa vào tuần học và thứ trong tuần
	public Date getNgayHoc(int tuanCanLay, int thu){
		NgayBatDau ngayBatDau = new NgayBatDau();
		Date nbd = ngayBatDau.getNgayBatDau();
		Long nbdlong = nbd.getTime();
		
		Long ngayCanLay = nbdlong + (1000L * 60L * 60L * 24L * 7L) * (tuanCanLay-1) + (1000L * 60L * 60L * 24L)*(thu -2);
		return new Date(ngayCanLay);
	}
	
	
	
}
