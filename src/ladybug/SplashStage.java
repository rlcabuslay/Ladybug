package ladybug;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashStage {
	private Stage window;
	private Scene scene;
	private Help help;
	private About about;
		
	public final static int MAP_WIDTH = 400;
	public final static int MAP_HEIGHT = 400;
	public final static boolean IS_GAME_DONE = false;
	public final static int WINDOW_WIDTH = 1000;
	public final static int WINDOW_HEIGHT = 1000;
	
	private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
	
	public SplashStage() {
		this.help = new Help();
		this.about = new About();
	}

	//method to add the stage elements
	public void setStage(Stage primaryStage) {
		this.window = primaryStage;
//		Creating the Play Button
		Button playButton = new Button("Play");
		playButton.setOnAction(e -> startGame());
		
//		Creating the Help Button
		Button helpButton = new Button("Help");
		helpButton.setOnAction(e -> this.help.switchScene(primaryStage,this));
		
//		Creating the About Button
		Button aboutButton = new Button("About");
		aboutButton.setOnAction(e -> this.about.switchScene(primaryStage,this));
		
//		Creating the layout for buttons
		VBox menuBox = new VBox(50);
		menuBox.setPadding(new Insets(300,0,0,0));
		
//		Adding the buttons to the layout
		menuBox.getChildren().addAll(playButton,helpButton,aboutButton);
		
//		Aligning the buttons to the center
		menuBox.setAlignment(Pos.CENTER);
		
//		Setting the id name for styling
		menuBox.setId("pane");
		this.scene =  new Scene(menuBox,SplashStage.WINDOW_WIDTH,SplashStage.WINDOW_HEIGHT);
		this.scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		this.window.setScene(this.scene);
		this.window.setTitle("LadyBug Arcade Game");
		this.window.show();
	}
	
	public void startGame(){
		
		PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				GameStage theGameStage = new GameStage();
				theGameStage.setStage(window);
				window.setScene(theGameStage.getScene());
			}
		});
		pause.play();
	}
	
	public Scene getScene(){
		return this.scene;
	}
	
				   
}

