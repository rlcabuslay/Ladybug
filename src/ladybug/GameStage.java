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

public class GameStage {
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GridPane map;
	private GameTimer gametimer;
		
	public final static int MAP_WIDTH = 400;
	public final static int MAP_HEIGHT = 400;
	public final static boolean IS_GAME_DONE = false;
	public final static int WINDOW_WIDTH = 1000;
	public final static int WINDOW_HEIGHT = 1000;
	
	public final static Image bg = new Image("images/LadyBugMaze.png",1000,1000,false,false);
	private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
	
	public GameStage() {
		this.root = new Group();
		this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT,Color.WHITE);	
		this.canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);	
		this.gc = canvas.getGraphicsContext2D();
		this.map = new GridPane();
		this.gametimer = new GameTimer(this.gc,this.scene);
	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;
		//draw the background to the canvas at location x=0, y=60
		this.gc.drawImage( bg, 0, 0 );				     
		
        Button play_btn = new Button("back tayo");
  
        play_btn.setLayoutX(373);
        play_btn.setLayoutY(455);
        
        play_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
            	back();
            	play_btn.setStyle(STYLE_PRESSED);
                System.out.println("Back");
            }
        });
		this.gametimer.start();
		//set stage elements here	     
		this.root.getChildren().add(canvas);
		this.root.getChildren().add(map);		
		this.root.getChildren().add(play_btn);
		this.stage.setTitle("Ladybug Arcade Game");
		this.stage.setScene(this.scene);
		
		this.stage.show();

	}

//	private void addToStage(Element elem, ImageView iv) {
//		elem.render(iv);
//	}
	

	//method to set size and location of the grid pane 
	private void setGridPaneProperties(){
		this.map.setPrefSize(GameStage.MAP_WIDTH, GameStage.MAP_HEIGHT);
		this.map.setLayoutX(GameStage.WINDOW_WIDTH*0.15);
	    this.map.setLayoutY(GameStage.WINDOW_WIDTH*0.15);
	}
	
	private boolean isGameDone(){
		return false;
	}
	
	public void setGameOver(){
		
		PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				GameOverStage gameover = new GameOverStage();
				stage.setScene(gameover.getScene());
			}
		});
		pause.play();
	}
	
	Scene getScene(){
		return this.scene;
	}
	
	public void back(){
		
		PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				SplashStage theSplashStage = new SplashStage();
				theSplashStage.setStage(stage);
			}
		});
		pause.play();
	}
	
	//======================EVENT HANDLERS===================================
	
	
}

