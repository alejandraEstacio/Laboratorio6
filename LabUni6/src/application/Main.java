package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Evento;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
private static Evento evento;
	
	public Main() {
		evento=new Evento();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Ventana.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Evento getEvento() {
		return evento;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
