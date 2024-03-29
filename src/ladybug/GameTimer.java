package ladybug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class GameTimer extends AnimationTimer{
	private ArrayList<Rectangle> barrier;
	private GraphicsContext gc;
	private Scene theScene;
	private Ladybug ladybug;
	private ArrayList<Insect> insects;
	private ArrayList<Collectible> flowers;
	private ArrayList<Collectible> hearts;
	private ArrayList<Collectible> skulls;
	private ArrayList<Collectible> letters; 
	private ArrayList<Collectible> vegetable;
	private ArrayList<Gate> gates;
	private long startSpawn;
	private long frozenSec;
	private long frozenMilli;
	private long totalFreeze;
	private boolean disabled;
	private int[][] gameBoard;
	private static boolean allInsectReleased=false;
	private static String currentDisplay;
	private static int currentDisplayX;
	private static int currentDisplayY;
	
	public static int multiplier;
	public static int score;
	public static int currentLevel;
	public static int lives;
	public static long interval;
	public static int insectTime;
	public static boolean deathTransition;
	public static boolean levelTransition;
	public static boolean powerTransition;
	public static boolean vegetablePresent;
	public static boolean takenX;
	public static boolean takenT;
	public static boolean takenR;
	public static boolean takenS;
	public static boolean takenP;
	public static boolean takenC;
	public static boolean takenI;
	public static boolean takenL;
	public static boolean takenAextra;
	public static boolean takenEextra;
	public static boolean takenAspecial;
	public static boolean takenEspecial;
	public static ArrayList<Character> extra;
	public static ArrayList<Character> special;

	
	private Font font = Font.loadFont(getClass().getResourceAsStream("PressStart2P-Regular.ttf"),  25);
	private Font font2 = Font.loadFont(getClass().getResourceAsStream("PressStart2P-Regular.ttf"),  20);
	
	public static Image SpS = new Image("images/Sprites/Letters/SpS.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpP = new Image("images/Sprites/Letters/SpP.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpE = new Image("images/Sprites/Letters/SpE.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpC = new Image("images/Sprites/Letters/SpC.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpI = new Image("images/Sprites/Letters/SpI.png", 8*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpA = new Image("images/Sprites/Letters/SpA.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image SpL = new Image("images/Sprites/Letters/SpL.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);

	public static Image ExE = new Image("images/Sprites/Letters/ExE.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image ExX = new Image("images/Sprites/Letters/ExX.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image ExT = new Image("images/Sprites/Letters/ExT.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image ExR = new Image("images/Sprites/Letters/ExR.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image ExA = new Image("images/Sprites/Letters/ExA.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);

	public static Image MuX = new Image("images/Sprites/Letters/MuX.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image Mu2 = new Image("images/Sprites/Letters/Mu2.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image Mu3 = new Image("images/Sprites/Letters/Mu3.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	public static Image Mu5 = new Image("images/Sprites/Letters/Mu5.png", 9*GameStage.PIXEL_SIZE, 9*GameStage.PIXEL_SIZE, false, false);
	
	GameTimer(GraphicsContext gc, Scene theScene, ArrayList<Rectangle> barrier){
		this.gc = gc;
		this.theScene = theScene;
		this.barrier = barrier;
		
		this.ladybug = new Ladybug("Buggy", GameStage.locateXGrid(6), GameStage.locateYGrid(9));
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.letters = new ArrayList<Collectible>();
		this.vegetable = new ArrayList<Collectible>();
		this.gates = new ArrayList<Gate>();
		
		
		GameStage.IS_GAME_DONE = false;
		GameTimer.multiplier=1;
		GameTimer.score=0;
		GameTimer.currentLevel=0;
		GameTimer.lives=3;
		GameTimer.interval = 30; //6, 9, 18
		GameTimer.insectTime=1;
		GameTimer.deathTransition=false;
		GameTimer.levelTransition=false;
		GameTimer.powerTransition=false;
		GameTimer.vegetablePresent=false;
		GameTimer.takenX=false;
		GameTimer.takenT=false;
		GameTimer.takenR=false;
		GameTimer.takenS=false;
		GameTimer.takenP=false;
		GameTimer.takenC=false;
		GameTimer.takenI=false;
		GameTimer.takenL=false;
		GameTimer.takenAextra=false;
		GameTimer.takenEextra=false;
		GameTimer.takenAspecial=false;
		GameTimer.takenEspecial=false;
		GameTimer.extra = new ArrayList<Character>();
		GameTimer.special = new ArrayList<Character>();
		
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		
		this.gameBoard = new int[11][11];
		initGameBoard();
		
		// ==================== FOR MAX COLLECTIBLES ==================== //  
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(this.gameBoard[i][j]==0){
					this.flowers.add(new Collectible("Flower", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==1||this.gameBoard[i][j]==2||this.gameBoard[i][j]==3) {
					this.hearts.add(new Collectible("RedHeart", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==4) {
					this.letters.add(new Collectible("XTR", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==5) {
					this.letters.add(new Collectible("SPCIL", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==6) {
					this.letters.add(new Collectible("AE", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==7) {
					this.skulls.add(new Collectible("Skull", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==8) {
					this.skulls.add(new Collectible("Skull", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
			}
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				this.gates.add(new Gate("Gate", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
			}
		}
		
		// ==================== FOR LESS COLLECTIBLES ==================== //  
//		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+30));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+60));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+90));
//		
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2));
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+50));
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+100));
//		
// 		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-120));
// 		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-170));
//		
// 		this.letters.add(new Collectible("XTR", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2));
// 		this.letters.add(new Collectible("SPCIL", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+50));
// 		this.letters.add(new Collectible("AE", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+100));
		
		this.startSpawn = System.nanoTime();
		this.frozenSec=0;
		this.frozenMilli=0;
		this.totalFreeze=0;
		
		this.disabled=false;
		
		this.handleKeyPressEvent();
		
	}

	@Override
	public void handle(long currentNanoTime) {
		long currentMilli = TimeUnit.NANOSECONDS.toMillis(currentNanoTime);
		if(GameTimer.levelTransition==false&&GameTimer.deathTransition==false&&GameTimer.powerTransition==false) {
		
			//for game timer // to be merged
			long currentSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime-this.totalFreeze);
			long startSec = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn);
			int timer = (int)((TimeUnit.NANOSECONDS.toMillis((currentNanoTime-this.totalFreeze)*GameTimer.interval) - TimeUnit.NANOSECONDS.toMillis(this.startSpawn*interval) + (60f/92f))/1000);
			
			//clear and redraw background elements
			this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
			this.gc.setFill(Color.BLACK);
			this.gc.fillRect(0, 0, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
			this.gc.drawImage(GameStage.top, 0, 0);
			
			//Background Square
			if(timer%184 < 92) this.gc.setFill(Color.WHITE);
			else this.gc.setFill(Color.LIME);
			this.gc.fillRect(0, GameStage.CELL_SIZE, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT-(GameStage.CELL_SIZE*3));
			
			//Timer Bar
			if(timer%184 < 92) this.gc.setFill(Color.LIME);
			else this.gc.setFill(Color.WHITE);
			
			if(timer%92 < 12)
				this.gc.fillRect(GameStage.WINDOW_WIDTH/2, GameStage.CELL_SIZE, (timer%92)*GameStage.CELL_SIZE/2, 28);
			else if(timer%92 < 34)
				this.gc.fillRect(GameStage.WINDOW_WIDTH/2, GameStage.CELL_SIZE, 12*GameStage.CELL_SIZE/2, GameStage.GAME_BOUND_WALL+((timer%92)-12)*GameStage.CELL_SIZE/2);
			else
				this.gc.fillRect(GameStage.WINDOW_WIDTH/2, GameStage.CELL_SIZE, 12*GameStage.CELL_SIZE/2, GameStage.GAME_BOUND_WALL+(34-12)*GameStage.CELL_SIZE/2);
			
			if(timer%92 < 58)
				this.gc.fillRect(GameStage.WINDOW_WIDTH-(((timer%92)-34)*GameStage.CELL_SIZE/2), GameStage.WINDOW_WIDTH+GameStage.CELL_SIZE/2, 24*GameStage.CELL_SIZE/2, GameStage.GAME_BOUND_WALL);
			else
				this.gc.fillRect(0, GameStage.WINDOW_WIDTH+GameStage.CELL_SIZE/2, 24*GameStage.CELL_SIZE/2, GameStage.GAME_BOUND_WALL);
			
			if(timer%92 > 58 && timer%92 < 81)
				this.gc.fillRect(0, GameStage.WINDOW_WIDTH+4-(((timer%92)-59)*GameStage.CELL_SIZE/2), GameStage.GAME_BOUND_WALL, GameStage.GAME_BOUND_WALL+(((timer%92)-59)*GameStage.CELL_SIZE/2));
			else if(timer%92 > 58 && timer%92 != 0)
				this.gc.fillRect(0, GameStage.CELL_SIZE, GameStage.GAME_BOUND_WALL+(((timer%92)-81)*GameStage.CELL_SIZE/2), GameStage.GAME_BOUND_WALL+(34-12)*GameStage.CELL_SIZE/2);
			
			this.gc.drawImage(GameStage.bg, 0, GameStage.CELL_SIZE);
			
			for(int i=0;i<GameTimer.lives-1;i++)
				this.gc.drawImage(Ladybug.LADYBUG_IMAGE_RIGHT, GameStage.GAME_BOUND_WALL+(GameStage.CELL_SIZE*i), 824);
			
			this.gc.setFont(this.font);
			String strLevel = Integer.toString(GameTimer.currentLevel+1); 
			String strScore = Integer.toString(GameTimer.score); 
			this.gc.fillText("Level "+strLevel, 400, 860);
			this.gc.fillText("Score: "+strScore, 400, 900);
			
			this.ladybug.move(this.barrier);
			
			if(this.ladybug.isAlive()==false) {
				System.out.println("Game over!");
				GameStage.IS_GAME_DONE=true;
			}
			
			for(int i=0; i<this.insects.size(); i++) {
				this.insects.get(i).move(currentSec, this.gates); //gets the currentSec
				if(this.insects.get(i).collidesWith(this.ladybug)&&this.insects.get(i).getReleased()==true) {
					if(GameTimer.vegetablePresent==true) {
						this.vegetable.remove(0);
						GameTimer.vegetablePresent=false;
					}
					this.startSpawn = System.nanoTime();
					for(Insect insect:this.insects) {
						insect.die();
					}
					GameTimer.insectTime=1;
					GameTimer.allInsectReleased=false;
					GameTimer.deathTransition=true;
					this.frozenMilli=currentMilli+1500;
				}
				for (int j=0; j<this.skulls.size(); j++) {
					if(this.skulls.get(j).collidesWith(this.insects.get(i))) {
						this.skulls.get(j).collide();
						this.skulls.remove(j);
						this.insects.get(i).die();
						if(GameTimer.vegetablePresent==true) {
							this.vegetable.add(new Collectible("Vegetable", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
						}
					}
				}
				for(Gate gate:this.gates) {
					for(Insect insect:this.insects) {
						if(this.insects.get(i).collidesWith(gate)) {
							insect.move(currentSec, this.gates);
						}
					}
				}
			}
			
			
			if((timer)%(92 * GameTimer.insectTime) == 0 && timer != 0) {
				if(this.insects.get(0).getReleased()==false&&this.disabled==false) {
					this.insects.get(0).setReleased();
					if(GameTimer.allInsectReleased==false) GameTimer.insectTime++;
					else if(GameTimer.allInsectReleased==true&&GameTimer.vegetablePresent==false) {
						this.vegetable.add(new Collectible("Vegetable", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
						GameTimer.vegetablePresent=true;
					}
				}
				else if(this.insects.get(1).getReleased()==false&&this.insects.get(0).getReleased()==true) {
					this.insects.get(1).setReleased();
					if(GameTimer.allInsectReleased==false) GameTimer.insectTime++;
					else if(GameTimer.allInsectReleased==true&&GameTimer.vegetablePresent==false) {
						this.vegetable.add(new Collectible("Vegetable", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
						GameTimer.vegetablePresent=true;
					}
				}
				else if(this.insects.get(2).getReleased()==false&&(this.insects.get(1).getReleased()==true)) {
					this.insects.get(2).setReleased();
					if(GameTimer.allInsectReleased==false) GameTimer.insectTime++;
					else if(GameTimer.allInsectReleased==true&&GameTimer.vegetablePresent==false) {
						this.vegetable.add(new Collectible("Vegetable", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
						GameTimer.vegetablePresent=true;
					}
				}
				else if(this.insects.get(3).getReleased()==false&&(this.insects.get(2).getReleased()==true)) {
					this.insects.get(3).setReleased();
					GameTimer.insectTime=1;
					GameTimer.allInsectReleased=true;
					if(GameTimer.vegetablePresent==false) {
						this.vegetable.add(new Collectible("Vegetable", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
						GameTimer.vegetablePresent=true;
					}
					
				}
			}
			
			// ==================== LIGHTUP ==================== //  
			if(GameTimer.takenS == true ) this.gc.drawImage(SpS, 28 + 0*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenP == true ) this.gc.drawImage(SpP, 28 + 1*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenEspecial == true ) this.gc.drawImage(SpE, 28 + 2*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenC == true ) this.gc.drawImage(SpC, 28 + 3*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenI == true ) this.gc.drawImage(SpI, 28 + 4*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenAspecial == true ) this.gc.drawImage(SpA, 28 + 5*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenL == true ) this.gc.drawImage(SpL, 28 + 6*8*GameStage.PIXEL_SIZE, 30);

			if(GameTimer.takenEextra == true ) this.gc.drawImage(ExE, 8 + 28*3 + 7*8*GameStage.PIXEL_SIZE + 0*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenX == true ) this.gc.drawImage(ExX, 8 + 28*3 + 7*8*GameStage.PIXEL_SIZE + 1*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenT == true ) this.gc.drawImage(ExT, 8 + 28*3 + 7*8*GameStage.PIXEL_SIZE + 2*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenR == true ) this.gc.drawImage(ExR, 8 + 28*3 + 7*8*GameStage.PIXEL_SIZE + 3*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.takenAextra == true ) this.gc.drawImage(ExA, 8 + 28*3 + 7*8*GameStage.PIXEL_SIZE + 4*8*GameStage.PIXEL_SIZE, 30);

			if(GameTimer.multiplier >= 2 ) this.gc.drawImage(MuX, 12 + 28*5 + 12*8*GameStage.PIXEL_SIZE + 0*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.multiplier >= 2 ) this.gc.drawImage(Mu2, 12 +  28*5 + 12*8*GameStage.PIXEL_SIZE + 1*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.multiplier >= 3 ) this.gc.drawImage(MuX, 12 + 28*5 + 12*8*GameStage.PIXEL_SIZE + 2*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.multiplier >= 3 ) this.gc.drawImage(Mu3, 12 + 28*5 + 12*8*GameStage.PIXEL_SIZE + 3*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.multiplier >= 5 ) this.gc.drawImage(MuX, 12 + 28*5 + 12*8*GameStage.PIXEL_SIZE + 4*8*GameStage.PIXEL_SIZE, 30);
			if(GameTimer.multiplier >= 5 ) this.gc.drawImage(Mu5, 12 + 28*5 + 12*8*GameStage.PIXEL_SIZE + 5*8*GameStage.PIXEL_SIZE, 30);
			
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
					//power-up animation
					GameTimer.powerTransition=true;
					GameTimer.currentDisplay=Integer.toString(this.hearts.get(i).getDisplay());
					GameTimer.currentDisplayX=this.hearts.get(i).getX();
					GameTimer.currentDisplayY=this.hearts.get(i).getY();
					this.frozenMilli=currentMilli+500;
					this.hearts.remove(i);
					
				}
			}
			
			System.out.println((currentSec - startSec)%10 + "\n");
			
			if((currentSec - startSec)%10 == 0) {
				for(Collectible heart:this.hearts)
					heart.changeColorBlue();
				for(Collectible letter:this.letters)
					letter.changeColorBlue();
			}
			
			if((currentSec - startSec)%10 == 1) {
				for(Collectible heart:this.hearts)
					heart.changeColorRed();
				for(Collectible letter:this.letters)
					letter.changeColorRed();
			}
			
			if((currentSec - startSec)%10 == 4) {
				for(Collectible heart:this.hearts)
					heart.changeColorYellow();
				for(Collectible letter:this.letters)
					letter.changeColorYellow();
			}
			
			for(Collectible heart:this.hearts) {
				heart.render(this.gc);
			}
			
			for (int i=0; i<this.skulls.size(); i++) {
				if(this.skulls.get(i).collidesWith(this.ladybug)) {
					this.skulls.get(i).collide();
					this.skulls.remove(i);
					for(Insect insect:this.insects) {
						insect.die();
					}
					if(GameTimer.vegetablePresent==true) {
						this.vegetable.remove(0);
						GameTimer.vegetablePresent=false;
					}
					this.startSpawn = System.nanoTime();
					GameTimer.insectTime=1;
					GameTimer.allInsectReleased=false;
					GameTimer.deathTransition=true;
					this.frozenMilli=currentMilli+1500;
				}
			}
			
			for(Collectible skull:this.skulls) {
				skull.render(this.gc);
			}
			
			
			
			for (int i=0; i<this.vegetable.size(); i++) {
				if(this.vegetable.get(i).collidesWith(this.ladybug)) {
					this.vegetable.get(i).collide();
					//power-up animation
					GameTimer.powerTransition=true;
					GameTimer.currentDisplay=Integer.toString(this.vegetable.get(i).getDisplay());
					GameTimer.currentDisplayX=this.vegetable.get(i).getX();
					GameTimer.currentDisplayY=this.vegetable.get(i).getY();
					this.frozenMilli=currentMilli+500;
					this.vegetable.remove(i);
					GameTimer.vegetablePresent=false;
					this.disabled=true;
					this.frozenSec = currentSec+5;
					for(Insect insect:this.insects) {
						insect.setFrozen();
					}
				}
			}
			
			if(this.disabled==true) {
				if(currentSec==frozenSec) {
					for(Insect insect:this.insects) {
						insect.setUnFrozen();
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
					//power-up animation
					GameTimer.powerTransition=true;
					GameTimer.currentDisplay=Integer.toString(this.letters.get(i).getDisplay());
					GameTimer.currentDisplayX=this.letters.get(i).getX();
					GameTimer.currentDisplayY=this.letters.get(i).getY();
					this.frozenMilli=currentMilli+500;
					this.letters.remove(i);
				}
			}
			
			for(Collectible letter:this.letters) {
				letter.render(this.gc);
			}
			
			this.ladybug.render(this.gc);
			
			for(Insect insect:this.insects) {
				insect.render(this.gc);
			}
			
			for(Gate gate:this.gates) {
				if(this.ladybug.collidesWith(gate)) {
					gate.rotate();
				}
			}
			
			for(Gate gate:this.gates) {
				gate.render(this.gc);
			}
		
		}
		
//		System.out.println(frozenMilli);
//		System.out.println(currentMilli);
		if(currentMilli<=frozenMilli&&GameTimer.powerTransition==true) { //power-up animation
			this.gc.setFont(this.font2);
			this.gc.setFill(Color.rgb(174, 174, 255));
			this.gc.fillText(GameTimer.currentDisplay, GameTimer.currentDisplayX, GameTimer.currentDisplayY);
		}
		else if(currentMilli>this.frozenMilli&&this.frozenMilli!=0&&GameTimer.powerTransition==true) {
			GameTimer.powerTransition=false;
			this.totalFreeze+=500000000;
		}
		
		
		if((this.flowers.size()==0&&this.hearts.size()==0&&this.letters.size()==0||GameTimer.extra.size()==5||GameTimer.special.size()==7)&&GameTimer.levelTransition==false) {
			GameTimer.levelTransition=true;
			this.frozenMilli=currentMilli+1000;
		}
		
		if(currentMilli<=frozenMilli&&GameTimer.levelTransition==true) {
			this.gc.setFill(Color.BLACK);
			this.gc.fillRect(0, 64, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
			this.gc.setFont(this.font);
			String strLevel = Integer.toString(GameTimer.currentLevel+2); 
			this.gc.setFill(Color.WHITE);
			this.gc.fillText("Level "+strLevel, GameStage.WINDOW_WIDTH/2-100, GameStage.WINDOW_HEIGHT/2);
		}
		
		else if(currentMilli>=frozenMilli&&GameTimer.levelTransition==true) {
			if(GameTimer.extra.size()==5) {
				this.ladybug.increaseLife();
				GameTimer.takenX=false;
				GameTimer.takenT=false;
				GameTimer.takenR=false;
				GameTimer.takenAextra=false;
				GameTimer.takenEextra=false;
				GameTimer.extra.clear();
			}
			if(GameTimer.special.size()==7) {
				GameTimer.takenS=false;
				GameTimer.takenP=false;
				GameTimer.takenC=false;
				GameTimer.takenI=false;
				GameTimer.takenL=false;
				GameTimer.takenAspecial=false;
				GameTimer.takenEspecial=false;
				GameTimer.special.clear();
			}
			changeLevel();
		}
		
		
		if(currentMilli<=frozenMilli&&GameTimer.deathTransition==true) {
			this.ladybug.deathAnimation(currentMilli, this.frozenMilli);
			this.ladybug.render(this.gc);
		}
		else if(currentMilli>this.frozenMilli&&this.frozenMilli!=0&&GameTimer.deathTransition==true){
			this.ladybug.loadImage(Ladybug.LADYBUG_IMAGE_UP);
			this.ladybug.die();
			GameTimer.deathTransition=false;
			this.totalFreeze=0;
			this.totalFreeze+=1500000000;
		}
		
		
		if(GameStage.IS_GAME_DONE==true) {
			this.gc.drawImage(GameStage.gameover, 0, 64);
			this.stop();
		}
		
	}
	
	private void changeLevel() {
		this.ladybug = new Ladybug("Buggy", GameStage.locateXGrid(6), GameStage.locateYGrid(9));
		this.insects = new ArrayList<Insect>();
		this.flowers = new ArrayList<Collectible>();
		this.hearts = new ArrayList<Collectible>();
		this.skulls = new ArrayList<Collectible>();
		this.letters = new ArrayList<Collectible>();
		this.vegetable = new ArrayList<Collectible>();
		this.gates = new ArrayList<Gate>();
		
		
		GameStage.IS_GAME_DONE = false;
		GameTimer.multiplier=1;
		GameTimer.score=0;
		GameTimer.currentLevel=0;
		GameTimer.lives=3;
		GameTimer.interval = 25; //6, 9, 18
		GameTimer.insectTime=1;
		GameTimer.deathTransition=false;
		GameTimer.levelTransition=false;
		GameTimer.powerTransition=false;
		GameTimer.vegetablePresent=false;
		GameTimer.takenX=false;
		GameTimer.takenT=false;
		GameTimer.takenR=false;
		GameTimer.takenS=false;
		GameTimer.takenP=false;
		GameTimer.takenC=false;
		GameTimer.takenI=false;
		GameTimer.takenL=false;
		GameTimer.takenAextra=false;
		GameTimer.takenEextra=false;
		GameTimer.takenAspecial=false;
		GameTimer.takenEspecial=false;
		GameTimer.extra = new ArrayList<Character>();
		GameTimer.special = new ArrayList<Character>();
		
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		this.insects.add(new Insect("Insect", GameStage.locateXGrid(6), GameStage.locateYGrid(6)));
		
		this.gameBoard = new int[11][11];
		initGameBoard();
		
		// ==================== FOR MAX COLLECTIBLES ==================== //  
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(this.gameBoard[i][j]==0){
					this.flowers.add(new Collectible("Flower", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==1||this.gameBoard[i][j]==2||this.gameBoard[i][j]==3) {
					this.hearts.add(new Collectible("RedHeart", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==4) {
					this.letters.add(new Collectible("XTR", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==5) {
					this.letters.add(new Collectible("SPCIL", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==6) {
					this.letters.add(new Collectible("AE", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==7) {
					this.skulls.add(new Collectible("Skull", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
				else if(this.gameBoard[i][j]==8) {
					this.skulls.add(new Collectible("Skull", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
				}
			}
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				this.gates.add(new Gate("Gate", GameStage.locateXGrid(i+1), GameStage.locateYGrid(j+1)));
			}
		}
		
		// ==================== FOR LESS COLLECTIBLES ==================== //  
//		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+30));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+60));
// 		this.flowers.add(new Collectible("Flower", GameStage.WINDOW_WIDTH/2-100,GameStage.WINDOW_HEIGHT/2+90));
//		
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2));
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+50));
// 		this.hearts.add(new Collectible("RedHeart", GameStage.WINDOW_WIDTH/2-200,GameStage.WINDOW_HEIGHT/2+100));
//		
// 		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-120));
// 		this.skulls.add(new Collectible("Skull", GameStage.WINDOW_WIDTH/2-25,GameStage.WINDOW_HEIGHT/2-170));
//		
// 		this.letters.add(new Collectible("XTR", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2));
// 		this.letters.add(new Collectible("SPCIL", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+50));
// 		this.letters.add(new Collectible("AE", GameStage.WINDOW_WIDTH/2-275,GameStage.WINDOW_HEIGHT/2+100));
		
		this.startSpawn = System.nanoTime();
		this.frozenSec=0;
		this.frozenMilli=0;
		this.totalFreeze=0;
		
		this.disabled=false;
		
		GameTimer.currentLevel++;
		GameTimer.multiplier=1;
		GameTimer.insectTime=1;
		GameTimer.vegetablePresent=false;
		Collectible.numberBlueHearts=0;
		if(GameTimer.currentLevel==1) GameTimer.interval=9;
		if(GameTimer.currentLevel==4) GameTimer.interval=18;
		System.out.println(GameTimer.currentLevel);
		GameTimer.levelTransition=false;
		this.frozenMilli=0;
		
		this.handleKeyPressEvent();
	}
	
	private void initGameBoard(){
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				this.gameBoard[i][j]=0;
			}
		}
		Random r = new Random();
		int randRow;
		int randCol;
		int counter=1;
		
		for(int i=0;i<9;i++) {
			//randomizes two row and column coordinates
			randRow=r.nextInt(11);
			randCol=r.nextInt(11);
			//checks if the coordinate is already taken
			while((this.gameBoard[randRow][randCol]!=0)||(randRow==5&&randCol==8)||(randRow==5&&randCol==9)||(randRow==5&&randCol==10)||(randRow==5&&randCol==5)) {
				randRow=r.nextInt(11);
				randCol=r.nextInt(11);
			}
			//assigns a pair of numbers to the coordinates 
			this.gameBoard[randRow][randCol]=counter;
			//updates number
			counter++;
		}
		this.gameBoard[5][5]=-1;
		this.gameBoard[5][8]=-1;
		this.gameBoard[5][9]=-1;
		this.gameBoard[5][10]=-1;
		
		
		for(int i=0;i<11;i++){
			System.out.println(Arrays.toString(this.gameBoard[i]));//print final board content	
		}
	}
	
	
	
	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                moveMyLadybug(code);
			}
			
		});
		
		theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		            public void handle(KeyEvent e){
		            	KeyCode code = e.getCode();
		                stopMyLadybug(code);
		            }
		        });
    }
	
	//method that will move the ladybug depending on the key pressed
	private void moveMyLadybug(KeyCode ke) {
		{
			if(ke==KeyCode.UP) {
				this.ladybug.setDY(-8); 
				this.ladybug.loadImage(Ladybug.LADYBUG_IMAGE_UP);
			}
	
			if(ke==KeyCode.LEFT) {
				this.ladybug.setDX(-8);
				this.ladybug.loadImage(Ladybug.LADYBUG_IMAGE_LEFT);
			}
	
			if(ke==KeyCode.DOWN) {
				this.ladybug.setDY(8);
				this.ladybug.loadImage(Ladybug.LADYBUG_IMAGE_DOWN);
			}
			
			if(ke==KeyCode.RIGHT) {
				this.ladybug.setDX(8);
				this.ladybug.loadImage(Ladybug.LADYBUG_IMAGE_RIGHT);
			}
		}
   	}
	
	//method that will stop the ladybug's movement by setting DX and DY to 0
	private void stopMyLadybug(KeyCode ke){
		this.ladybug.setDX(0);
		this.ladybug.setDY(0);
	}

	
}
