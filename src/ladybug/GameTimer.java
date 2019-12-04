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
import javafx.scene.paint.Color;

public class GameTimer extends AnimationTimer{
	
	private GraphicsContext gc;
	private Scene theScene;
	private Ladybug ladybug;
	private ArrayList<Insect> insects;
	private ArrayList<Collectible> flowers;
	private ArrayList<Collectible> hearts;
	private ArrayList<Collectible> skulls;
	private ArrayList<Collectible> letters; 
	private ArrayList<Collectible> vegetable;
	private long startSpawn;
	private long frozenSec;
	private boolean disabled;
	
	public static int multiplier=1;
	public static int score=0;
	public static int currentLevel=0;
	public static int lives=3;
	public static int timeSped=15;
	public static int insectTime=1;
	public static boolean vegetablePresent=false;
	public static boolean takenX=false;
	public static boolean takenT=false;
	public static boolean takenR=false;
	public static boolean takenS=false;
	public static boolean takenP=false;
	public static boolean takenC=false;
	public static boolean takenI=false;
	public static boolean takenL=false;
	public static boolean takenAextra=false;
	public static boolean takenEextra=false;
	public static boolean takenAspecial=false;
	public static boolean takenEspecial=false;
	public static ArrayList<Character> extra = new ArrayList<Character>();
	public static ArrayList<Character> special = new ArrayList<Character>();
	
	
	
	GameTimer(GraphicsContext gc, Scene theScene){
		this.gc = gc;
		this.theScene = theScene;

		this.ladybug = new Ladybug("Buggy", 348, 604);
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.letters = new ArrayList<Collectible>();
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
		
		this.letters.add(new Collectible("XTR", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2));
		this.letters.add(new Collectible("SPCIL", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+50));
		this.letters.add(new Collectible("AE", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+100));
		
		this.startSpawn = System.nanoTime();
		this.frozenSec=0;
		
		this.disabled=false;
		
		this.handleKeyPressEvent();
	}

	@Override
	public void handle(long currentNanoTime) {
		//for game timer // to be merged
		long interval = 9;
		long currentSec2 = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime*interval);
		long startSec2 = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn*interval);
		//for insect timer // to be merged
		long currentSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime);
		long startSec = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn);
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		
		//redraw background elements
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		this.gc.drawImage(GameStage.top, 0, 0);
		
		//Time
		int time = (int)((currentSec2 - startSec2));
		
		//Background Square
		if(time%184 < 92) this.gc.setFill(Color.WHITE);
		else this.gc.setFill(Color.RED);
		this.gc.fillRect(0, 64, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT-(64*3));
		
		//Timer Bar
		if(time%184 < 92) this.gc.setFill(Color.RED);
		else this.gc.setFill(Color.WHITE);
		
		if(time%92 < 12)
			this.gc.fillRect(GameStage.WINDOW_WIDTH/2, 64, (time%92)*32, 28);
		else if(time%92 < 34)
			this.gc.fillRect(GameStage.WINDOW_WIDTH/2, 64, 12*32, 28+((time%92)-12)*32);
		else
			this.gc.fillRect(GameStage.WINDOW_WIDTH/2, 64, 12*32, 28+(34-12)*32);
		
		if(time%92 < 58)
			this.gc.fillRect(GameStage.WINDOW_WIDTH-(((time%92)-34)*32), GameStage.WINDOW_WIDTH+32, 24*32, 28);
		else
			this.gc.fillRect(0, GameStage.WINDOW_WIDTH+32, 24*32, 28);
		
		if(time%92 > 58 && time%92 < 81)
			this.gc.fillRect(0, GameStage.WINDOW_WIDTH+4-(((time%92)-59)*32), 28, 28+(((time%92)-59)*32));
		else if(time%92 > 58 && time%92 != 0)
			this.gc.fillRect(0, 64, 28+(((time%92)-81)*32), 28+(34-12)*32);
		
		this.gc.drawImage(GameStage.bg, 0, 64);
		this.gc.drawImage(Ladybug.LADYBUG_IMAGE, 28, 824);
		this.gc.drawImage(Ladybug.LADYBUG_IMAGE, 28+64, 824);
		this.gc.drawImage(Ladybug.LADYBUG_IMAGE, 28, 92);
		
		//===FONT PROPOSAL===
//		Font font = Font.loadFont(ClassLoader.getSystemResource("fonts/PressStart2P-Regular.ttf").toExternalForm(),  32); 
//		this.gc.setFont(font);
//		this.gc.setFill(Color.RED);	
//		this.gc.fillText("SPECIAL", 0, 64);
//		this.gc.setFill(Color.YELLOW);
//		this.gc.fillText("EXTRA", 252, 64);
//		this.gc.setFill(Color.BLUE);
//		this.gc.fillText("x2x3x5", 508, 64);
		
		this.ladybug.move();

		this.ladybug.render(this.gc);
		
		if(this.ladybug.isAlive()==false) {
			System.out.println("Game over!");
			setGameOver(0);
		}
		
		for(int i=0; i<this.insects.size(); i++) {
			this.insects.get(i).move();
			if(this.insects.get(i).collidesWith(this.ladybug)) {
				this.ladybug.die();
			}
			for (int j=0; j<this.skulls.size(); j++) {
				if(this.skulls.get(j).collidesWith(this.insects.get(i))) {
					this.skulls.get(j).collide();
					this.skulls.remove(j);
					this.insects.get(i).die();
					if(GameTimer.vegetablePresent==true) {
						this.vegetable.add(new Collectible("Vegetable",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
					}
				}
			}
		}
		
		
		if((currentSec - startSec) == GameTimer.timeSped*GameTimer.insectTime) {
			if(this.insects.get(0).getReleased()==false) {
				this.insects.get(0).setReleased();
				GameTimer.insectTime++;
			}
			else if(this.insects.get(1).getReleased()==false&&this.insects.get(0).getReleased()==true) {
				this.insects.get(1).setReleased();
				GameTimer.insectTime++;
			}
			else if(this.insects.get(2).getReleased()==false&&(this.insects.get(1).getReleased()==true||this.insects.get(0).getReleased()==true)) {
				this.insects.get(2).setReleased();
				GameTimer.insectTime++;
			}
			else if(this.insects.get(3).getReleased()==false&&(this.insects.get(2).getReleased()==true||this.insects.get(1).getReleased()==true||this.insects.get(0).getReleased()==true)) {
				this.insects.get(3).setReleased();
				GameTimer.insectTime++;
				this.vegetable.add(new Collectible("Vegetable",GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-20));
				GameTimer.vegetablePresent=true;
			}
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
			for(Collectible letter:this.letters) {
				letter.changeColorRed();
			}
			
		}
		
		if((currentSec - startSec) == 4 || (currentSec - startSec)%14 == 0) {
			for(Collectible heart:this.hearts) {
				heart.changeColorYellow();
			}
			for(Collectible letter:this.letters) {
				letter.changeColorYellow();
			}
		}
		
		if((currentSec - startSec)%10 == 0) {
			for(Collectible heart:this.hearts) {
				heart.changeColorBlue();
			}
			for(Collectible letter:this.letters) {
				letter.changeColorBlue();
			}

		}
		
		for(Collectible heart:this.hearts) {
			heart.render(this.gc);
		}
		
		
		
		for(Collectible skull:this.skulls) {
			if(skull.collidesWith(this.ladybug)) {
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
		
		
		
		for (int i=0; i<this.letters.size(); i++) {
			if(this.letters.get(i).collidesWith(this.ladybug)) {
				this.letters.get(i).collide();
				this.letters.remove(i);
			}
		}
		
		for(Collectible letter:this.letters) {
			letter.render(this.gc);
		}
		
		
		if(GameTimer.extra.size()==5) {
			changeLevel();
			GameTimer.currentLevel++;
			GameTimer.multiplier=1;
			GameTimer.insectTime=1;
			GameTimer.vegetablePresent=false;
			if(GameTimer.currentLevel==1) GameTimer.timeSped-=5;
			if(GameTimer.currentLevel==4) GameTimer.timeSped-=5;
			this.ladybug.increaseLife();
			GameTimer.takenX=false;
			GameTimer.takenT=false;
			GameTimer.takenR=false;
			GameTimer.takenAextra=false;
			GameTimer.takenEextra=false;
			GameTimer.extra.clear();
		}
		
		if(GameTimer.special.size()==7) {
			changeLevel();
			GameTimer.currentLevel++;
			GameTimer.multiplier=1;
			GameTimer.insectTime=1;
			GameTimer.vegetablePresent=false;
			if(GameTimer.currentLevel==1) GameTimer.timeSped-=5;
			if(GameTimer.currentLevel==4) GameTimer.timeSped-=5;
			GameTimer.takenS=false;
			GameTimer.takenP=false;
			GameTimer.takenC=false;
			GameTimer.takenI=false;
			GameTimer.takenL=false;
			GameTimer.takenAspecial=false;
			GameTimer.takenEspecial=false;
			GameTimer.special.clear();
		}
		
		if(this.flowers.size()==0&&this.hearts.size()==0&&this.letters.size()==0) {
			PauseTransition pause = new PauseTransition(Duration.seconds(0.15));
			pause.setOnFinished(new EventHandler<ActionEvent>() {
						
				public void handle(ActionEvent arg0) {
					changeLevel();
				}
			});
			pause.play();
			GameTimer.currentLevel++;
			GameTimer.multiplier=1;
			GameTimer.insectTime=1;
			GameTimer.vegetablePresent=false;
			if(GameTimer.currentLevel==1) GameTimer.timeSped-=5;
			if(GameTimer.currentLevel==4) GameTimer.timeSped-=5;
		}
		
	}
	
	private void changeLevel() {
		this.ladybug = new Ladybug("Buggy", 348, 604);
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.letters = new ArrayList<Collectible>();
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
		
		this.letters.add(new Collectible("XTR", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2));
		this.letters.add(new Collectible("SPCIL", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+50));
		this.letters.add(new Collectible("AE", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+100));
		
		this.startSpawn = System.nanoTime();
		this.frozenSec=0;
		
		this.disabled=false;
		
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
		
//		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyHunter(KeyCode ke){
		this.ladybug.setDX(0);
		this.ladybug.setDY(0);
	}

	
}
