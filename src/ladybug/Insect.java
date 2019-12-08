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
	
	public final static Image INSECT_IMAGE1 = new Image("images/Sprites/Characters/Insects/Insect1U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE2 = new Image("images/Sprites/Characters/Insects/Insect2U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE3 = new Image("images/Sprites/Characters/Insects/Insect3U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE4 = new Image("images/Sprites/Characters/Insects/Insect4U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE5 = new Image("images/Sprites/Characters/Insects/Insect5U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE6 = new Image("images/Sprites/Characters/Insects/Insect6U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE7 = new Image("images/Sprites/Characters/Insects/Insect7U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image INSECT_IMAGE8 = new Image("images/Sprites/Characters/Insects/Insect8U.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);

	public Insect(String name, int x, int y){
		super(x,y);
		this.name = name;
		Random r = new Random();
		int rand=r.nextInt(8);
		
		if(rand==0) this.loadImage(Insect.INSECT_IMAGE1);
		else if(rand==1) this.loadImage(Insect.INSECT_IMAGE2);
		else if(rand==2) this.loadImage(Insect.INSECT_IMAGE3);
		else if(rand==3) this.loadImage(Insect.INSECT_IMAGE4);
		else if(rand==4) this.loadImage(Insect.INSECT_IMAGE5);
		else if(rand==5) this.loadImage(Insect.INSECT_IMAGE6);
		else if(rand==6) this.loadImage(Insect.INSECT_IMAGE7);
		else if(rand==7) this.loadImage(Insect.INSECT_IMAGE8);
		else this.loadImage(Insect.INSECT_IMAGE1);
		
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

