package ladybug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;

public class SplashStage {
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GridPane map;
	private Help help;
	private About about;
		
	public final static int MAP_WIDTH = 400;
	public final static int MAP_HEIGHT = 400;
	public final static boolean IS_GAME_DONE = false;
	public final static int WINDOW_WIDTH = 1000;
	public final static int WINDOW_HEIGHT = 1000;
	
	public final Image bg = new Image("images/splashscreen.png",1000,1000,false,false);
	public final Image PLAY_IMAGE = new Image("images/play.PNG",250,100,false,false);
	public final Image HELP_IMAGE = new Image("images/help.PNG",250,100,false,false);
	public final Image ABOUT_IMAGE = new Image("images/about.PNG",250,100,false,false);
	private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
	
	public SplashStage() {
		this.root = new Group();
		this.scene = new Scene(root, SplashStage.WINDOW_WIDTH,SplashStage.WINDOW_HEIGHT,Color.WHITE);	
		this.canvas = new Canvas(SplashStage.WINDOW_WIDTH,SplashStage.WINDOW_HEIGHT);	
		this.gc = canvas.getGraphicsContext2D();
		this.map = new GridPane();
		this.help = new Help();
		this.about = new About();
	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;
		//draw the background to the canvas at location x=0, y=60
		this.gc.drawImage( bg, 0, 0 );				     
		
        Button play_btn = new Button();
        Button help_btn = new Button();
        Button about_btn = new Button();
        
        play_btn.setGraphic(new ImageView(PLAY_IMAGE));
        help_btn.setGraphic(new ImageView(HELP_IMAGE));
        about_btn.setGraphic(new ImageView(ABOUT_IMAGE));
        
        play_btn.setStyle(STYLE_NORMAL);
        help_btn.setStyle(STYLE_NORMAL);
        about_btn.setStyle(STYLE_NORMAL);
        
        play_btn.setLayoutX(373);
        play_btn.setLayoutY(455);
        
        help_btn.setLayoutX(373);
        help_btn.setLayoutY(600);
        
        about_btn.setLayoutX(373);
        about_btn.setLayoutY(745);
        
        play_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
            	startGame();
            	play_btn.setStyle(STYLE_PRESSED);
                System.out.println("Accepted Play");
            }
        });
	
	help_btn.setOnMouseClicked(e -> this.help.switchScene(this.stage,this);
	
	about_btn.setOnMouseClicked(e -> this.about.switchScene(this.stage,this);
				   
        
		//set stage elements here	     
		this.root.getChildren().add(canvas);
		this.root.getChildren().add(map);		
		this.root.getChildren().add(play_btn);
		this.root.getChildren().add(help_btn);
		this.root.getChildren().add(about_btn);
		this.stage.setTitle("Ladybug Arcade Game");
		this.stage.setScene(this.scene);
		this.stage.show();
	}
	
	public void startGame(){
		
		PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				GameStage theGameStage = new GameStage();
				theGameStage.setStage(stage);
				stage.setScene(theGameStage.getScene());
			}
		});
		pause.play();
	}
	
	public Scene getScene(){
		return this.scene;
	}
	
				   
}

