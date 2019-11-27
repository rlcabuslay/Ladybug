package ladybug;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class GameTimer extends AnimationTimer{
	
	private GraphicsContext gc;
	private Scene theScene;
	private Ladybug ladybug;
//	private Hunter myHunter;
//	private boolean shoot;
	private boolean disabled;
//	private int countShot;
//	private ArrayList<Duck> ducks;
//	private ArrayList<Bullet> bullets;
	
	
	GameTimer(GraphicsContext gc, Scene theScene){
		this.gc = gc;
		this.theScene = theScene;
//		Random r = new Random();
		this.ladybug = new Ladybug("Buggy",GameStage.WINDOW_WIDTH/2-50,GameStage.WINDOW_HEIGHT/2+50);
		
		//randomize hunter's position
//		this.myHunter = new Hunter("Megaman",r.nextInt(GameStage.WINDOW_WIDTH-50),r.nextInt(GameStage.WINDOW_HEIGHT-50));
//		this.ducks = new ArrayList<Duck>();
//		this.bullets = new ArrayList<Bullet>();
		this.disabled=false;
//		this.countShot=0;
		
		//randomize duck's y position
//		this.ducks.add(new Duck("Duck1",GameStage.WINDOW_WIDTH/2,r.nextInt(GameStage.WINDOW_HEIGHT-100)));
//		this.ducks.add(new Duck("Duck2",GameStage.WINDOW_WIDTH/2,r.nextInt(GameStage.WINDOW_HEIGHT-100)));
//		this.ducks.add(new Duck("Duck3",GameStage.WINDOW_WIDTH/2,r.nextInt(GameStage.WINDOW_HEIGHT-100)));
		//call method to handle mouse click event
		this.handleKeyPressEvent();
	}

	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		this.gc.drawImage( GameStage.bg, 0, 0 );
		
		this.ladybug.move();
		this.ladybug.render(this.gc);
		
//		check if hunter is alive; disable movements if dead
//		if(this.myHunter.isAlive()==false) this.disabled=true;
//		
//		//checks if the hunter is about to go off-screen and corrects position
//		this.myHunter.checkBounds();
//		
//		//call the methods to move the hunter
//		if(this.disabled==false) this.myHunter.move();
//		//call the methods to move the bullet
//		for(Bullet bullet:this.bullets) {
//			if(this.disabled==false) bullet.move();
//		}
//		//call the methods to move the duck
//		for(Duck duck:this.ducks) {
//			if(this.disabled==false) duck.move();
//			//checks duck's bounds and turns duck around if reached
//			duck.checkTurn();
//			//checks duck's collision with hunter; if true, kills hunter and sets to game over loss 
//			if(duck.collidesWith(this.myHunter)) {
//				this.myHunter.die();
//				setGameOver(0);
//			}
//			//checks duck's collision with bullet; if true, sets bullet and duck position out of screen and kills duck
//			for(Bullet bullet:this.bullets) {
//				if(duck.collidesWith(bullet)) {
//					bullet.setX(-100);
//					bullet.setY(-100);
//					duck.setX(-100);
//					duck.setY(-100);
//					duck.die();
//				}
//			}
//		}
//		
//		//checks how many ducks are currently dead, and sets game over win if all 3 ducks are killed
//		this.countShot=0;
//		for(Duck duck:this.ducks) {
//			if(duck.getAlive()==false) {
//				this.countShot+=1;
//			}
//			if(this.countShot==3) {
//				this.disabled=true;
//				setGameOver(1);
//				break;
//			}
//		}
//
//		//adds a new bullet and moves it to the right
//		if(this.shoot==true) {
//			this.bullets.add(new Bullet("Bullet",this.myHunter.getX()+20,this.myHunter.getY()+20));
//			this.bullets.get(this.bullets.size()-1).setDX(20);
//			this.shoot=false;
//		}
//		
//		//render the hunter, ducks, and bullets
//		this.myHunter.render(this.gc);
//		for(Duck duck:this.ducks) {
//			duck.render(this.gc);
//		}
//		for(Bullet bullet:this.bullets) {
//			bullet.render(this.gc);
//		}
		
	}
	
	private void setGameOver(int num){
		
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(num==0) System.out.println("You lose!");
				else if(num==1) System.out.println("You win!");
				System.exit(0);
			}
		});
		pause.play();
	}
	
	
	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                moveMyHunter(code);
			}
			
		});
		
		theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		            public void handle(KeyEvent e){
		            	KeyCode code = e.getCode();
		                stopMyHunter(code);
		            }
		        });
    }
	
	//method that will move the ship depending on the key pressed
	private void moveMyHunter(KeyCode ke) {
		{
		if(this.disabled==false) {
			if(ke==KeyCode.UP) this.ladybug.setDY(-10);                 
	
			if(ke==KeyCode.LEFT) this.ladybug.setDX(-10);
	
			if(ke==KeyCode.DOWN) this.ladybug.setDY(10);
			
			if(ke==KeyCode.RIGHT) this.ladybug.setDX(10);
			
		}
			
			if(ke==KeyCode.SPACE) {
//				this.shoot=true;
			}
		}
		
		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyHunter(KeyCode ke){
		this.ladybug.setDX(0);
		this.ladybug.setDY(0);
//		this.shoot=false;
	}

	
}
