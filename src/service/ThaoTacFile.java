package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThaoTacFile {

	
	// không dùng
	public boolean checkNull() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("ngaybatdau.txt")));
			if (br.readLine() == null) {
				return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
