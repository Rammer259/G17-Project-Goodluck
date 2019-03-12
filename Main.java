
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Login.fxml"));
		Pane mainPane = loader.load();
		
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
	}

}
