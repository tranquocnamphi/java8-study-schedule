package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class NgayBatDau {

	public Date getNgayBatDau() {
		File file = new File("ngaybatdau.txt");
		try {
			Scanner sc = new Scanner(file);
			if (sc.hasNextLine()) {
				String date = sc.nextLine();
				Date d = Date.valueOf(date);
				return d;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void luuNgayBatDau(LocalDate localdate) {
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("ngaybatdau.txt");
			myWriter.write(localdate.toString());
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
//		new NgayBatDau().luuNgayBatDau(LocalDate.now());
//		System.out.println(new NgayBatDau().getNgayBatDau());
	}
}
