package service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NgayHienTai {

	public Date ngayHienTai() {
		return Date.valueOf(LocalDate.now());
	}
	
	
	// lấy ra ngày thứ 2 của tuần hiện tại
	public Date ngayDauTuanHienTai() {
		String t = thuHienTai(LocalDate.now().toString());
		Long thu = Long.valueOf(t);
		
		Long s = System.currentTimeMillis();
		Long kt = s - (1000L * 60L * 60L * 24L * (thu-2L));
		return new Date(kt);
	}
	
	
	// lấy ra ngày chủ nhật của tuần hiện tại
	public Date ngayKtTuanHienTai() {
		String t = thuHienTai(LocalDate.now().toString());
		Long thu = Long.valueOf(t);
		
		Long s = System.currentTimeMillis();
		Long kt = s + (1000L * 60L * 60L * 24L * (8L-thu));
		return new Date(kt);
	}
	
	// lấy ra thứ hôm nay(thứ 3)
	public String thuHienTai(String ngay) {
		int year = Integer.valueOf(ngay.split("-")[0]);
		int month = Integer.valueOf(ngay.split("-")[1]);
		int day = Integer.valueOf(ngay.split("-")[2]);
		Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        Integer dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek.toString();
	}
	
	public long getTuanHocByDate(Date d) {
		NgayBatDau ngayBatDau = new NgayBatDau();
		Date nbd = ngayBatDau.getNgayBatDau();
		Long nbdlong = nbd.getTime();
		
		Long ht = d.getTime();
		
		Long x = (ht - nbdlong) / 1000L / 60L / 60L / 24L / 7L +1L;
		return x;
		
	}
	
	
	// hàm trả ra ngày đầu tuần và cuối tuần của 1 tuần
	public List<Date> getNgayBatDauKetThuc(int tuanCanLay){
		NgayBatDau ngayBatDau = new NgayBatDau();
		Date nbd = ngayBatDau.getNgayBatDau();
		// tuan thu 1
		Long nbdlong = nbd.getTime();
		// tuan thu n
		Long tuannlong = nbdlong + (1000L * 60L * 60L * 24L * 7L) * (tuanCanLay-1);
		
		Long tuannketthuclong = tuannlong + (1000L * 60L * 60L * 24L * 6L);
		
		Date nbdTuanCanLay = new Date(tuannlong);
		Date nktTuanCanLay = new Date(tuannketthuclong);
		System.out.println(nbdTuanCanLay);
		System.out.println(nktTuanCanLay);
		List<Date> list = new ArrayList<Date>();
		list.add(nbdTuanCanLay);
		list.add(nktTuanCanLay);
		return list;
	}
	
}
