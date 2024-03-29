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
import javafx.scene.shape.Rectangle;
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
	private ArrayList<Rectangle> barrier;
	
	public final static int PIXEL_SIZE = 4;
	
	public final static int CELL_SIZE = 16 * GameStage.PIXEL_SIZE;
	public final static int WALL_SIZE = 2*GameStage.PIXEL_SIZE;
	public final static int WALL_WIDTH = Sprite.SPRITE_SIZE - GameStage.PIXEL_SIZE*2;
	
	public final static int MAP_WIDTH = 190 * GameStage.PIXEL_SIZE;
	public final static int MAP_HEIGHT = 190 * GameStage.PIXEL_SIZE;
	public final static int WINDOW_WIDTH = 190 * GameStage.PIXEL_SIZE;
	public final static int WINDOW_HEIGHT = 238 * GameStage.PIXEL_SIZE;
	
	public final static int GAME_BOUND_WALL = 7 * GameStage.PIXEL_SIZE;
	public final static int GAME_BOUND_RIGHT = GameStage.WINDOW_WIDTH - (GameStage.GAME_BOUND_WALL + GameStage.CELL_SIZE - 2*GameStage.PIXEL_SIZE);
	public final static int GAME_BOUND_DOWN = GameStage.WINDOW_HEIGHT - (GameStage.GAME_BOUND_WALL + GameStage.CELL_SIZE + GameStage.CELL_SIZE + GameStage.CELL_SIZE - 2*GameStage.PIXEL_SIZE);	
	public final static int GAME_BOUND_UP = GameStage.GAME_BOUND_WALL + GameStage.CELL_SIZE;
	public final static int GAME_BOUND_LEFT = GameStage.GAME_BOUND_WALL;
	
	public static boolean IS_GAME_DONE = false;
	
	public final static Image bg = new Image("images/LadyBugMaze.png", GameStage.MAP_WIDTH, GameStage.MAP_HEIGHT, false, false);
	public final static Image top = new Image("images/Sprites/Arcade - Lady Bug - Maze (4).png", GameStage.MAP_WIDTH, GameStage.CELL_SIZE, false, false);
	public final static Image gameover = new Image("images/Sprites/GameOver.png", GameStage.MAP_WIDTH, GameStage.MAP_HEIGHT, false, false);
	
	public GameStage() {
		this.root = new Group();
		this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT,Color.WHITE);	
		this.canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);	
		this.gc = canvas.getGraphicsContext2D();
		this.map = new GridPane();
		this.barrier = new ArrayList<Rectangle>();
		this.gametimer = new GameTimer(this.gc,this.scene,this.barrier);
		this.initBarrier();
	}
	
	public void initBarrier() {
		for(int i = 1 ; i < 10; i = i+2) {
			for(int j = 1 ; j < 10 ; j = j+3) {
				this.barrier.add(new Rectangle(this.locXGrid(i),this.locYGrid(j),GameStage.WALL_SIZE,GameStage.WALL_WIDTH));
			}
		}
	}
	

	//method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;
		//draw the background to the canvas at location x=0, y=60
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		this.gc.drawImage(top, 0, 0);
		this.gc.drawImage(bg, 0, 64);			     
		
		Button play_btn = new Button("back tayo");

		play_btn.setLayoutX(0);
        	play_btn.setLayoutY(0);

		play_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
			back();
			System.out.println("Back");
		    }
		});
		
		this.gametimer.start();
		//set stage elements here	     
		this.root.getChildren().add(canvas);
		this.root.getChildren().add(map);		
		this.root.getChildren().add(play_btn);
		for(Rectangle b: this.barrier) {
			b.setFill(Color.ANTIQUEWHITE);
			this.root.getChildren().add(b);
		}
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
	
	public static int locateXGrid(int locX) {
		return GameStage.GAME_BOUND_WALL + (locX-1)*GameStage.CELL_SIZE + GameStage.PIXEL_SIZE;
	}
	
	public static int locateYGrid(int locY) {
		return GameStage.GAME_BOUND_WALL + locY*GameStage.CELL_SIZE + GameStage.PIXEL_SIZE;
	}
	
	public int locXGrid(int locX) {
		return GameStage.GAME_BOUND_LEFT + GameStage.PIXEL_SIZE + locX*(Sprite.SPRITE_SIZE + GameStage.WALL_SIZE);
	}
	
	public int locYGrid(int locY) {
		return GameStage.GAME_BOUND_LEFT + GameStage.PIXEL_SIZE + (locY+1)*(Sprite.SPRITE_SIZE + GameStage.WALL_SIZE);
	}
	//======================EVENT HANDLERS===================================
	
	
}

