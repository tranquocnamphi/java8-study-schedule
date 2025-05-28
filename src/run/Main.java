package run;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
//			primaryStage.setResizable(false);
			FileInputStream file = new FileInputStream("image/LOGO1.png");
			primaryStage.getIcons().add(new Image(file));
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}