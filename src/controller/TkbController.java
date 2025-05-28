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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Tkb;
import service.NgayHienTai;
import service.UserSession;

public class TkbController implements Initializable {

	@FXML
	private Label lbNgay;

	@FXML
	private Label lbXinChao;

	@FXML
	private HBox hboxMain;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private AnchorPane anchopane;

	@FXML
	private ComboBox<String> choice_tuan;

	@FXML
	private DatePicker cal_ngay;

	private static List<Tkb> listTkb = new ArrayList<Tkb>();

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

		addtkb.addEventHandler(ActionEvent.ACTION, ev -> {
			popOver.hide();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/themtkb.fxml"));
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

	
	// xử lý nút xem bằng select tuần 
	@FXML
	void actXem(ActionEvent event) {
		String ngay = choice_tuan.getValue();
		List<Date> list = new NgayHienTai().getNgayBatDauKetThuc(Integer.valueOf(ngay.split(" ")[1]));
		listTkb.clear();
		listTkb = new TkbDao().getTkbByDate(list.get(0), list.get(1));
		setBlockTuan();
	}
	
	
	// xử lý nút xem bằng lịch ngày
	@FXML
	void actXemNgay(ActionEvent event) {
		listTkb.clear();
		Date date = Date.valueOf(cal_ngay.getValue());
		listTkb = new TkbDao().getTkbByADay(date);
		setBlockTuan();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbXinChao.setText("xin chào: " + UserSession.userId);
		setValueTuan();
		setNgayHt();
		setDsDefault();
		setBlockTuan();
	}

	
	// hiển thị mặc định danh sách tuần hiện tại
	public void setDsDefault() {
		TkbDao tkbDao = new TkbDao();
		NgayHienTai ngayHienTai = new NgayHienTai();
		Date s1 = ngayHienTai.ngayDauTuanHienTai();
		Date s2 = ngayHienTai.ngayKtTuanHienTai();
		listTkb = tkbDao.getTkbByDate(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
		listTkb.forEach(p -> {
			System.out.println(p);
		});
	}

	
	// hiển thị dữ liệu các buổi học ra màn hình
	public void setBlockTuan() {
		anchopane.getChildren().clear();
		VBox vBox = new VBox();
		vBox.setPrefWidth(430);
		vBox.setPrefHeight(2000);
		anchopane.getChildren().add(vBox);

		Tkb tkb = null;
		for (Tkb t : listTkb) {
			if (tkb != null) {
				if (!t.getThu().equalsIgnoreCase(tkb.getThu())) {
					Label thu = new Label(t.getThu());
					thu.setFont(Font.font("aria", FontWeight.BOLD, 16));
					vBox.getChildren().add(thu);
				}
			} else {
				Label thu = new Label(t.getThu());
				thu.setFont(Font.font("aria", FontWeight.BOLD, 16));
				vBox.getChildren().add(thu);
			}
			HBox hBox = new HBox();
			hBox.setStyle("-fx-background-color:#fff");
			hBox.setPrefWidth(430);
			hBox.setPrefHeight(80);

			VBox time = new VBox();
			time.setPrefWidth(60);
			time.setMinWidth(60);
			time.setPrefHeight(80);
			hBox.getChildren().add(time);
			Label gioBd = new Label(t.getGioBatDau());
			Label gioKt = new Label(t.getGioKetThuc());
			time.getChildren().add(gioBd);
			time.getChildren().add(gioKt);
			time.setAlignment(Pos.CENTER);
			gioBd.setFont(Font.font("aria", FontWeight.findByName("Italic"), 16));
			gioKt.setFont(Font.font("aria", FontWeight.findByName("Italic"), 16));
			Separator separator = new Separator();
			separator.setOrientation(Orientation.VERTICAL);
			hBox.getChildren().add(separator);
			hBox.setMargin(separator, new Insets(15, 0, 15, 0));

			VBox monhoc = new VBox();
			monhoc.setPrefWidth(350);
			monhoc.setPrefHeight(80);
			monhoc.setAlignment(Pos.CENTER_LEFT);
			hBox.getChildren().add(monhoc);
			Label tenmh = new Label(t.getTenMonHoc());
			Label dstuanhoc = new Label(t.getListTuanHoc() + "(" + t.getLoaiMonHoc() + ")");
			monhoc.getChildren().add(tenmh);
			monhoc.getChildren().add(dstuanhoc);

			tenmh.setFont(Font.font("aria", FontWeight.BOLD, 16));
			dstuanhoc.setFont(Font.font("aria", FontWeight.NORMAL, 16));

			Label phonghoc = new Label(t.getPhongHoc());
			hBox.getChildren().add(phonghoc);
			phonghoc.setMinWidth(70);
			hBox.setAlignment(Pos.CENTER_LEFT);
			phonghoc.setTextFill(Color.CORAL);
			phonghoc.setFont(Font.font("aria", FontWeight.NORMAL, 16));

			vBox.getChildren().add(hBox);
			vBox.setMargin(hBox, new Insets(5, 0, 0, 0));
			tkb = t;
			
			hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				 if (event.getButton() == MouseButton.SECONDARY)
		            {
						PopOver popOver = new PopOver();
						popOver.setArrowLocation(ArrowLocation.TOP_RIGHT);
						VBox vBox2 = new VBox();
						vBox2.setPrefWidth(100);
						vBox2.setPrefHeight(50);
						Button button = new Button("xóa MH");
						button.setPrefWidth(100);
						button.setPrefHeight(50);
						vBox2.getChildren().add(button);
						
						popOver.setContentNode(vBox2);
						popOver.show((Node) event.getSource(), -15);
						
						
						button.addEventHandler(MouseEvent.MOUSE_CLICKED, ev -> {
							Tkb delete = t;
							try {
								new TkbDao().delete(delete.getTenMonHoc(), delete.getLoaiMonHoc());
								listTkb.clear();
								setDsDefault();
								setBlockTuan();
								Message.getMess("xóa môn học: "+delete.getTenMonHoc()+" thành công", 1);
							} catch (Exception e) {
								Message.getMess("xóa môn học: "+delete.getTenMonHoc()+" thất bại", 2);
							}
						});
		            } 
			});
		}

	}

	
	// hàm set giá trị cho select box chọn tuần
	public void setValueTuan() {
		ObservableList<String> listTuan = FXCollections.observableArrayList();
		for (int i = 1; i < 28; i++) {
			listTuan.add("tuần " + i);
		}
		choice_tuan.setItems(listTuan);
	}

	
	// lấy ngày hiện tại hiển thị ra giao diện
	public void setNgayHt() {
		NgayHienTai ngayHienTai = new NgayHienTai();
		Date nht = ngayHienTai.ngayHienTai();
		String thuht = ngayHienTai.thuHienTai(nht.toString());
		lbNgay.setText("thứ " + thuht + ", " + nht.toString());
	}

}
