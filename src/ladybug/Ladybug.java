package ladybug;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ladybug extends Sprite{
	private String name;
	private boolean alive;
	
	public final static Image LADYBUG_IMAGE = new Image("images/Sprites/Characters/LadyBug/LadyBugR.gif",Ladybug.LADYBUG_WIDTH,Ladybug.LADYBUG_WIDTH,false,false);
	private final static int LADYBUG_WIDTH = 64;

	public Ladybug(String name, int x, int y){
		super(x,y);
		this.name = name;
		this.alive = true;
		
		this.loadImage(Ladybug.LADYBUG_IMAGE);
	}
	//getters

	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 
	public String getName(){
		return this.name;
	}
	
	public void increaseLife() {
		GameTimer.lives++;
	}

	public void die(){
		GameTimer.lives--;
		System.out.println("Lives: "+GameTimer.lives);
		if(GameTimer.lives==0) {
			this.alive = false;
		}
		else {
			this.setX(GameStage.WINDOW_WIDTH/2-50);
			this.setY(GameStage.WINDOW_HEIGHT/2+50);
		}
    }
	

	public void move() {
		int tempX = this.x + this.dx;
		int tempY = this.y + this.dy;

		if(tempX + 8 > 28 && tempX < GameStage.WINDOW_WIDTH - (28+60))
			this.x = tempX;
		if(tempY + 8 > 28 + 64 && tempY < GameStage.WINDOW_HEIGHT - (28+64+64+60))
			this.y = tempY;    
	}
}
