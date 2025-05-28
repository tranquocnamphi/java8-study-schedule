package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.UserDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserSession;

public class LoginController implements Initializable{

	private UserDao userDao = new UserDao();
	
    @FXML
    private TextField txt_msv;
    
    @FXML
    private Label lbdn;

    
    // xu ly khi ng dùng ấn nút đăng nhập
    @FXML
    void actDangNhap(ActionEvent event) {
    	if(txt_msv.getText().equals("")) {
    		Message.getMess("Mã sinh viên không được để trống", 2);
    	}
    	else {
    		if(userDao.login(txt_msv.getText())) {
    			UserSession.userId = txt_msv.getText();
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
    		else {
    			Message.getMess("Mã sinh viên không tồn tại trong hệ thống", 2);
    		}
    	}
    }

    
    // xử lý việc thêm mới sinh viên
    @FXML
    void actThemMoi(ActionEvent event) {
    	if(txt_msv.getText().equals("")) {
    		Message.getMess("Mã sinh viên không được để trống", 2);
    	}
    	else {
    		if(userDao.save(new User(txt_msv.getText()))) {
    			Message.getMess("Thêm mã sinh viên thành công!", 1);
    		}
    		else {
    			Message.getMess("Mã sinh viên đã tồn tại trong hệ thống", 2);
    		}
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> lbdn.requestFocus());
	}

}
