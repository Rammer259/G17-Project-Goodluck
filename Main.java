

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{
	
	public void start(Stage stage)throws Exception{
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/Login.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Employee Management System");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
