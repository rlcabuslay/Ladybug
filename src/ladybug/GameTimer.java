package ladybug;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
	private ArrayList<Insect> insects;
	private ArrayList<Collectible> flowers;
	private ArrayList<Collectible> hearts;
	private ArrayList<Collectible> skulls;
	private ArrayList<Collectible> vegetable; 
	private long startSpawn;
	public static int multiplier=1;
	public static int score=0;
	public static int currentLevel=0;
	private long frozenSec;
	private boolean disabled;
	
	
	GameTimer(GraphicsContext gc, Scene theScene){
		this.gc = gc;
		this.theScene = theScene;

		this.ladybug = new Ladybug("Buggy",GameStage.WINDOW_WIDTH/2-50,GameStage.WINDOW_HEIGHT/2+50);
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.vegetable = new ArrayList<Collectible>();
		
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+30));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+60));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+90));
		
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2));
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+50));
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+100));
		
		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-120));
		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-170));
		
		this.startSpawn = System.nanoTime();
		this.frozenSec=0;
		
		this.disabled=false;
		
		this.handleKeyPressEvent();
	}

	@Override
	public void handle(long currentNanoTime) {
		long currentSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime);
		long startSec = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn);
		long currentFrozenSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime);
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		this.gc.drawImage(GameStage.bg, 0, 0);
		
		this.ladybug.move();
		this.ladybug.render(this.gc);
		
		for(Insect insect:this.insects) {
			insect.move();
			if(insect.collidesWith(this.ladybug)) {
				this.ladybug.die();
			}
			for (int i=0; i<this.skulls.size(); i++) {
				if(this.skulls.get(i).collidesWith(insect)) {
					this.skulls.get(i).collide();
					this.skulls.remove(i);
					insect.die();
				}
			}
		}
		
		
		if((currentSec - startSec) == 0) {
			this.insects.get(0).setReleased();
			
		}
		
		if((currentSec - startSec) == 3) {
			this.insects.get(1).setReleased();
			
		}
		
		if((currentSec - startSec) == 6) {
			this.insects.get(2).setReleased();
			
		}
		
		if((currentSec - startSec) == 9) {
			this.insects.get(3).setReleased();
			this.vegetable.add(new Collectible("Vegetable",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		}
		
		
		for(Insect insect:this.insects) {
			insect.render(this.gc);
		}
		
		
		for (int i=0; i<this.flowers.size(); i++) {
			if(this.flowers.get(i).collidesWith(this.ladybug)) {
				this.flowers.get(i).collide();
				this.flowers.remove(i);
			}
		}
		
		for(Collectible flower:this.flowers) {
			flower.render(this.gc);
		}
		
		for (int i=0; i<this.hearts.size(); i++) {
			if(this.hearts.get(i).collidesWith(this.ladybug)) {
				this.hearts.get(i).collide();
				this.hearts.remove(i);
			}
		}
		
		
		if((currentSec - startSec) == 1 || (currentSec - startSec)%11 == 0) {
			for(Collectible heart:this.hearts) {
				heart.changeColorRed();
			}
			
		}
		
		if((currentSec - startSec) == 4 || (currentSec - startSec)%14 == 0) {
			for(Collectible heart:this.hearts) {
				heart.changeColorYellow();
			}
			
		}
		
		if((currentSec - startSec)%10 == 0) {
			for(Collectible heart:this.hearts) {
				heart.changeColorBlue();
			}

		}
		
		for(Collectible heart:this.hearts) {
			heart.render(this.gc);
		}
		
		
		
		for(Collectible skull:this.skulls) {
			if(this.ladybug.collidesWith(skull)) {
				this.ladybug.die();
				skull.collide();
			}
		}
		
		for(Collectible skull:this.skulls) {
			skull.render(this.gc);
		}
		
		
		
		for (int i=0; i<this.vegetable.size(); i++) {
			if(this.vegetable.get(i).collidesWith(this.ladybug)) {
				this.vegetable.get(i).collide();
				this.vegetable.remove(i);
				this.disabled=true;
				frozenSec = currentSec+4;
				for(Insect insect:this.insects) {
					insect.setFrozen();
				}
			}
		}
		
		if(this.disabled==true) {
			if(currentSec==frozenSec) {
				for(Insect insect:this.insects) {
					insect.setReleased();
				}
				this.disabled=false;
			}
		}
		
		
		for(Collectible vegetable:this.vegetable) {
			vegetable.render(this.gc);
		}
		
		if(this.flowers.size()==0&&this.hearts.size()==0) {
			changeLevel(this.gc,this.theScene);
			GameTimer.currentLevel++;
		}
		
		System.out.println(currentSec);
		System.out.println(frozenSec);
	}
	
	private void changeLevel(GraphicsContext gc, Scene theScene) {
		this.gc = gc;
		this.theScene = theScene;

		this.ladybug = new Ladybug("Buggy",GameStage.WINDOW_WIDTH/2-50,GameStage.WINDOW_HEIGHT/2+50);
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.vegetable = new ArrayList<Collectible>();
		
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		this.insects.add(new Insect("Insect",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
		
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+30));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+60));
		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+90));
		
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2));
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+50));
		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+100));
		
		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-120));
		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-170));
		
		this.startSpawn = System.nanoTime();
		
		this.disabled=false;
		this.frozenSec=0;
		
		this.handleKeyPressEvent();
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
			if(ke==KeyCode.UP) this.ladybug.setDY(-10);                 
	
			if(ke==KeyCode.LEFT) this.ladybug.setDX(-10);
	
			if(ke==KeyCode.DOWN) this.ladybug.setDY(10);
			
			if(ke==KeyCode.RIGHT) this.ladybug.setDX(10);
			
			
			if(ke==KeyCode.SPACE) {
			}
		}
		
		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyHunter(KeyCode ke){
		this.ladybug.setDX(0);
		this.ladybug.setDY(0);
	}

	
}
