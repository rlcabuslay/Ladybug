package ladybug;

import javafx.scene.image.Image;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Insect extends Sprite{
	private boolean turn;
	private String name;
	private boolean released;
	private int turnTime;
	private long start;
	
	public final static Image INSECT_1U = new Image("images/Sprites/Characters/Insects/Insect1U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_2U = new Image("images/Sprites/Characters/Insects/Insect2U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_3U = new Image("images/Sprites/Characters/Insects/Insect3U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_4U = new Image("images/Sprites/Characters/Insects/Insect4U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_5U = new Image("images/Sprites/Characters/Insects/Insect5U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_6U = new Image("images/Sprites/Characters/Insects/Insect6U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_7U = new Image("images/Sprites/Characters/Insects/Insect7U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_8U = new Image("images/Sprites/Characters/Insects/Insect8U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	
	public final static Image INSECT_1D = new Image("images/Sprites/Characters/Insects/Insect1D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_2D = new Image("images/Sprites/Characters/Insects/Insect2D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_3D = new Image("images/Sprites/Characters/Insects/Insect3D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_4D = new Image("images/Sprites/Characters/Insects/Insect4D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_5D = new Image("images/Sprites/Characters/Insects/Insect5D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_6D = new Image("images/Sprites/Characters/Insects/Insect6D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_7D = new Image("images/Sprites/Characters/Insects/Insect7D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_8D = new Image("images/Sprites/Characters/Insects/Insect8D.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	
	public final static Image INSECT_1L = new Image("images/Sprites/Characters/Insects/Insect1L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_2L = new Image("images/Sprites/Characters/Insects/Insect2L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_3L = new Image("images/Sprites/Characters/Insects/Insect3L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_4L = new Image("images/Sprites/Characters/Insects/Insect4L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_5L = new Image("images/Sprites/Characters/Insects/Insect5L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_6L = new Image("images/Sprites/Characters/Insects/Insect6L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_7L = new Image("images/Sprites/Characters/Insects/Insect7L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_8L = new Image("images/Sprites/Characters/Insects/Insect8L.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	
	public final static Image INSECT_1R = new Image("images/Sprites/Characters/Insects/Insect1R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_2R = new Image("images/Sprites/Characters/Insects/Insect2R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_3R = new Image("images/Sprites/Characters/Insects/Insect3R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_4R = new Image("images/Sprites/Characters/Insects/Insect4R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_5R = new Image("images/Sprites/Characters/Insects/Insect5R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_6R = new Image("images/Sprites/Characters/Insects/Insect6R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_7R = new Image("images/Sprites/Characters/Insects/Insect7R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_8R = new Image("images/Sprites/Characters/Insects/Insect8R.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);

	public Insect(String name, int x, int y){
		super(x,y);
		this.name = name;
		Random r = new Random();
		int rand=r.nextInt(8);
		
		if(rand==0) {
			this.loadImage(Insect.INSECT_1U);
			this.name="Insect1";
		}
		else if(rand==1) {
			this.loadImage(Insect.INSECT_2U);
			this.name="Insect2";
		}
		else if(rand==2) {
			this.loadImage(Insect.INSECT_3U);
			this.name="Insec3";
		}
		else if(rand==3) {
			this.loadImage(Insect.INSECT_4U);
			this.name="Insect4";
		}
		else if(rand==4) {
			this.loadImage(Insect.INSECT_5U);
			this.name="Insect5";
		}
		else if(rand==5) {
			this.loadImage(Insect.INSECT_6U);
			this.name="Insect6";
		}
		else if(rand==6) {
			this.loadImage(Insect.INSECT_7U);
			this.name="Insect7";
		}
		else if(rand==7) {
			this.loadImage(Insect.INSECT_8U);
			this.name="Insect8";
		}
		
		this.released=false;
		this.turn=false;
		this.turnTime=1; 
	}
	
	public String getName(){
		return this.name;
	}

	public void die(){
		this.released=false;
		this.turn=false;
		this.setDY(0);
		this.setDX(0);
		this.setX(GameStage.locateXGrid(6));
		this.setY(GameStage.locateYGrid(6));
		this.turnTime=1; //resets time interval
    }
	
	public void setReleased() {
		this.released=true;
		this.start = System.nanoTime(); //gets the time when it was released
	}
	
	public boolean getReleased() {
		return this.released;
	}
	
	public void setFrozen() {
		this.released=false;
	}

	public void move(long currentSec) {
		if(this.released==true) {
			
			if(this.getDY()<0) {
				if(this.name=="Insect1") {
					this.loadImage(INSECT_1U);
				}
				else if(this.name=="Insect2") {
					this.loadImage(INSECT_2U);
				}
				else if(this.name=="Insect3") {
					this.loadImage(INSECT_3U);
				}
				else if(this.name=="Insect4") {
					this.loadImage(INSECT_4U);
				}
				else if(this.name=="Insect5") {
					this.loadImage(INSECT_5U);
				}
				else if(this.name=="Insect6") {
					this.loadImage(INSECT_6U);
				}
				else if(this.name=="Insect7") {
					this.loadImage(INSECT_7U);
				}
				else if(this.name=="Insect8") {
					this.loadImage(INSECT_8U);
				}
			}
			
			else if(this.getDY()>0) {
				if(this.name=="Insect1") {
					this.loadImage(INSECT_1D);
				}
				else if(this.name=="Insect2") {
					this.loadImage(INSECT_2D);
				}
				else if(this.name=="Insect3") {
					this.loadImage(INSECT_3D);
				}
				else if(this.name=="Insect4") {
					this.loadImage(INSECT_4D);
				}
				else if(this.name=="Insect5") {
					this.loadImage(INSECT_5D);
				}
				else if(this.name=="Insect6") {
					this.loadImage(INSECT_6D);
				}
				else if(this.name=="Insect7") {
					this.loadImage(INSECT_7D);
				}
				else if(this.name=="Insect8") {
					this.loadImage(INSECT_8D);
				}
			}
			
			else if(this.getDX()<0) {
				if(this.name=="Insect1") {
					this.loadImage(INSECT_1L);
				}
				else if(this.name=="Insect2") {
					this.loadImage(INSECT_2L);
				}
				else if(this.name=="Insect3") {
					this.loadImage(INSECT_3L);
				}
				else if(this.name=="Insect4") {
					this.loadImage(INSECT_4L);
				}
				else if(this.name=="Insect5") {
					this.loadImage(INSECT_5L);
				}
				else if(this.name=="Insect6") {
					this.loadImage(INSECT_6L);
				}
				else if(this.name=="Insect7") {
					this.loadImage(INSECT_7L);
				}
				else if(this.name=="Insect8") {
					this.loadImage(INSECT_8L);
				}
			}
			
			else if(this.getDX()>0) {
				if(this.name=="Insect1") {
					this.loadImage(INSECT_1R);
				}
				else if(this.name=="Insect2") {
					this.loadImage(INSECT_2R);
				}
				else if(this.name=="Insect3") {
					this.loadImage(INSECT_3R);
				}
				else if(this.name=="Insect4") {
					this.loadImage(INSECT_4R);
				}
				else if(this.name=="Insect5") {
					this.loadImage(INSECT_5R);
				}
				else if(this.name=="Insect6") {
					this.loadImage(INSECT_6R);
				}
				else if(this.name=="Insect7") {
					this.loadImage(INSECT_7R);
				}
				else if(this.name=="Insect8") {
					this.loadImage(INSECT_8R);
				}
			}
			
			
			Random r = new Random();
			int randSec=r.nextInt(5)+1; //maximum of 5 seconds without changing direction
			long startSec = TimeUnit.NANOSECONDS.toSeconds(this.start);
			
			if(this.turn==false) this.setDY(-1*(GameTimer.currentLevel+1));
			
			int tempX = this.x + this.dx;
			int tempY = this.y + this.dy;

			if(tempX > GameStage.GAME_BOUND_LEFT && tempX < GameStage.GAME_BOUND_RIGHT) {
				this.x = tempX;
			}
			else {
				this.turn=true;
				int rand=r.nextInt(3);
				if(rand==0) { //turns down
					this.setDY(1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==1) { //turns up
					this.setDY(-1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==2) this.setDX(this.getDX()*-1); //changes from left to right or right to left
				
			}
				
			if(tempY > GameStage.GAME_BOUND_UP && tempY < GameStage.GAME_BOUND_DOWN) {
				this.y = tempY;
			}
			else {
				this.turn=true;
				int rand=r.nextInt(3);
				if(rand==0) { //turns right
					this.setDX(1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
				else if(rand==1) { //turns left
					this.setDX(-1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
				else if(rand==2) this.setDY(this.getDY()*-1); //changes from up to down or down to up
				
			}
			
			//currentSec - second it was released 
			if((currentSec-startSec) == (randSec*(this.turnTime))) {
				this.turn=true;
				this.turnTime++;
				int rand=r.nextInt(4);
				if(rand==0) { //turns up
					this.setDY(1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==1) { //turns down
					this.setDY(-1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==2) { //turns right
					this.setDX(1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
				else if(rand==3) { //turns left
					this.setDX(-1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
			}
		}
    	
	}
}

