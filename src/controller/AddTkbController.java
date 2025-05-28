package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;

import dao.TkbDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Tkb;
import service.NgayHienTai;
import service.UserSession;
import service.XuLyTuanHoc;

public class AddTkbController implements Initializable {

	@FXML
	private Label lbNgay;

	@FXML
	private Label lbXinChao;

	@FXML
	private HBox hboxMain;

	@FXML
	private TextField txt_ten;

	@FXML
	private TextField txt_giobd;

	@FXML
	private TextField txt_giokt;

	@FXML
	private TextField txt_thu;

	@FXML
	private TextField txt_dstuan;

	@FXML
	private TextField txt_loaimh;

	@FXML
	private TextField txt_phonghoc;

	@FXML
	void actMoChucNang(MouseEvent event) {
		PopOver popOver = new PopOver();
		popOver.setArrowLocation(ArrowLocation.TOP_RIGHT);

		VBox vBox = new VBox();
		vBox.setPrefWidth(150);
		vBox.setPrefHeight(150);

		Button addtkb = new Button("Thêm thời khóa biểu");
		addtkb.setPrefHeight(50);
		addtkb.setPrefWidth(150);

		Button viewTkb = new Button("Xem thời khóa biểu");
		viewTkb.setPrefHeight(50);
		viewTkb.setPrefWidth(150);

		Button login = new Button("Về đăng nhập");
		login.setPrefHeight(50);
		login.setPrefWidth(150);

		vBox.getChildren().add(addtkb);
		vBox.getChildren().add(viewTkb);
		vBox.getChildren().add(login);

		popOver.setContentNode(vBox);
		popOver.show((Node) event.getSource(), -15);

		viewTkb.addEventHandler(ActionEvent.ACTION, ev -> {
			popOver.hide();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/tkb.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		login.addEventHandler(ActionEvent.ACTION, ev -> {
			popOver.hide();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	
	// xử lý thêm môn học mới
	@FXML
	void actThemMonHoc(ActionEvent event) {
		if (checkInput()) {
			TkbDao tkbDao = new TkbDao();
			List<Tkb> tkb = createListTkb();
			for(Tkb t : tkb) {
				tkbDao.save(t);
			}
			Message.getMess("Thêm thời khóa biểu thành công", 1);
			Parent root;
			Scene scene;
			Stage stage;
			try {
				root = FXMLLoader.load(getClass().getResource("../view/tkb.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// xử lý thêm môn học mới
	public List<Tkb> createListTkb() {
		List<Tkb> list = new ArrayList<Tkb>();
		XuLyTuanHoc xuLyTuanHoc = new XuLyTuanHoc();
		List<Date> dsNgayHoc = xuLyTuanHoc.getListDate(txt_dstuan.getText(), Integer.valueOf(txt_thu.getText().split(" ")[1]));
		for(Date d : dsNgayHoc) {
			Tkb tkb = new Tkb();
			tkb.setGioBatDau(txt_giobd.getText());
			tkb.setGioKetThuc(txt_giokt.getText());
			tkb.setListTuanHoc(txt_dstuan.getText());
			tkb.setLoaiMonHoc(txt_loaimh.getText());
			tkb.setMasv(UserSession.userId);
			tkb.setNgayHoc(d);
			tkb.setPhongHoc(txt_phonghoc.getText());
			tkb.setTenMonHoc(txt_ten.getText());
			tkb.setThu(txt_thu.getText());
			tkb.setTuan(xuLyTuanHoc.getTuanHocByDate(d));
			list.add(tkb);
		}
		
		return list;
	}

	
	// kiểm tra xem các ô nhập có bị để trống không
	public boolean checkInput() {
		if (txt_dstuan.getText().equals("")) {
			Message.getMess("không được để trống danh sách tuần", 2);
			return false;
		}
		if (txt_giobd.getText().equals("")) {
			Message.getMess("không được để trống giờ bắt đầu", 2);
			return false;
		}
		if (txt_giokt.getText().equals("")) {
			Message.getMess("không được để trống giờ kết thúc", 2);
			return false;
		}
		if (txt_loaimh.getText().equals("")) {
			Message.getMess("không được để trống loại môn học", 2);
			return false;
		}
		if (txt_phonghoc.getText().equals("")) {
			Message.getMess("không được để trống phòng học", 2);
			return false;
		}
		if (txt_ten.getText().equals("")) {
			Message.getMess("không được để trống tên môn học", 2);
			return false;
		}
		if (txt_thu.getText().equals("")) {
			Message.getMess("không được để trống thứ trong tuần", 2);
			return false;
		}
		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbXinChao.setText("xin chào: " + UserSession.userId);
		setNgayHt();
	}

	public void setNgayHt() {
		NgayHienTai ngayHienTai = new NgayHienTai();
		Date nht = ngayHienTai.ngayHienTai();
		String thuht = ngayHienTai.thuHienTai(nht.toString());
		lbNgay.setText("thứ " + thuht + ", " + nht.toString());
	}
}
