package ladybug;

import javafx.scene.image.Image;
import java.util.Random;


public class Insect extends Sprite{
	private boolean turn;
	private String name;
	private boolean released;
	
	public final static Image INSECT_IMAGE1 = new Image("images/Sprites/Characters/Insects/Insect1c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE2 = new Image("images/Sprites/Characters/Insects/Insect2c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE3 = new Image("images/Sprites/Characters/Insects/Insect3c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE4 = new Image("images/Sprites/Characters/Insects/Insect4c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE5 = new Image("images/Sprites/Characters/Insects/Insect5c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE6 = new Image("images/Sprites/Characters/Insects/Insect6c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE7 = new Image("images/Sprites/Characters/Insects/Insect7c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	public final static Image INSECT_IMAGE8 = new Image("images/Sprites/Characters/Insects/Insect8c.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	private final static int INSECT_WIDTH = 64;

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
	}
	
	public String getName(){
		return this.name;
	}

	public void die(){
		this.released=false;
		this.turn=false;
		this.setDY(0);
		this.setDX(0);
		this.setX(GameStage.WINDOW_WIDTH/2-25);
		this.setY(GameStage.WINDOW_HEIGHT/2-70);
    }
	
	public void setReleased() {
		this.released=true;
	}
	
	public boolean getReleased() {
		return this.released;
	}
	
	public void setFrozen() {
		this.released=false;
	}

	public void move() {
		if(this.released==true) {
//			Random r = new Random();
//			int rand=r.nextInt(4);
//			if(rand==0) this.setDX(1);
//			else if(rand==1) this.setDX(-1);
//			else if(rand==2) this.setDY(1);
//			else if(rand==3) this.setDY(-1);
//			this.setDY(-1);
//			this.x += this.dx;
//	    	this.y += this.dy;
			
			if(this.turn==false) this.setDY(-1*(GameTimer.currentLevel+1));
			
			int tempX = this.x + this.dx;
			int tempY = this.y + this.dy;

			if(tempX + 8 > 28 && tempX < GameStage.WINDOW_WIDTH - (28+60)) {
				this.x = tempX;
			}
			else {
				this.turn=true;
				Random r = new Random();
				int rand=r.nextInt(3);
				if(rand==0) {
					this.setDY(1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==1) {
					this.setDY(-1*(GameTimer.currentLevel+1));
					this.setDX(0);
				}
				else if(rand==2) this.setDX(this.getDX()*-1);
				
			}
				
			if(tempY + 8 > 28 + 64 && tempY < GameStage.WINDOW_HEIGHT - (28+64+64+60)) {
				this.y = tempY;
			}
			else {
				this.turn=true;
				Random r = new Random();
				int rand=r.nextInt(3);
				if(rand==0) {
					this.setDX(1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
				else if(rand==1) {
					this.setDX(-1*(GameTimer.currentLevel+1));
					this.setDY(0);
				}
				else if(rand==2) this.setDY(this.getDY()*-1);
				
			}
		}
    	
	}
}

