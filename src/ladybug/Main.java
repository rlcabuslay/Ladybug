package ladybug;

import javafx.application.Application;
import javafx.stage.Stage;
import ladybug.GameStage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage){
		SplashStage theSplashStage = new SplashStage();
		theSplashStage.setStage(stage);
	}

}
