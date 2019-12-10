package ladybug;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Ladybug extends Sprite{
	private String name;
	private boolean alive;
	
	public final static Image LADYBUG_IMAGE_UP = new Image("images/Sprites/Characters/LadyBug/LadyBugU.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE_DOWN = new Image("images/Sprites/Characters/LadyBug/LadyBugD.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE_LEFT = new Image("images/Sprites/Characters/LadyBug/LadyBugL.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE_RIGHT = new Image("images/Sprites/Characters/LadyBug/LadyBugR.gif", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	
	public final static Image LADYBUG_IMAGE2 = new Image("images/Sprites/Characters/LadyBug/LadyBug7.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE3 = new Image("images/Sprites/Characters/LadyBug/LadyBug8.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE4 = new Image("images/Sprites/Characters/LadyBug/LadyBug9.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE5 = new Image("images/Sprites/Characters/LadyBug/LadyBug10.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE6 = new Image("images/Sprites/Characters/LadyBug/LadyBug11.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE7 = new Image("images/Sprites/Characters/LadyBug/LadyBug12.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE8 = new Image("images/Sprites/Characters/LadyBug/LadyBug13.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE9 = new Image("images/Sprites/Characters/LadyBug/LadyBug14.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE10 = new Image("images/Sprites/Characters/LadyBug/LadyBug15.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE11 = new Image("images/Sprites/Characters/LadyBug/LadyBug16.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE12 = new Image("images/Sprites/Characters/LadyBug/LadyBug17.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE13 = new Image("images/Sprites/Characters/LadyBug/LadyBug18.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);
	public final static Image LADYBUG_IMAGE14 = new Image("images/Sprites/Characters/LadyBug/LadyBug19.png", Sprite.SPRITE_SIZE, Sprite.SPRITE_SIZE, false, false);

	public Ladybug(String name, int x, int y){
		super(x,y);
		this.name = name;
		this.alive = true;
		
		this.loadImage(Ladybug.LADYBUG_IMAGE_UP);
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
	
	public void deathAnimation(long currentMilli, long frozenMilli) {
		if(1400<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1500) {
			this.loadImage(Ladybug.LADYBUG_IMAGE2);
		}
		else if(1300<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1400) {
			this.loadImage(Ladybug.LADYBUG_IMAGE3);
		}
		else if(1200<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1300) {
			this.loadImage(Ladybug.LADYBUG_IMAGE4);
		}
		else if(1100<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1200) {
			this.loadImage(Ladybug.LADYBUG_IMAGE5);
		}
		else if(1000<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1100) {
			this.loadImage(Ladybug.LADYBUG_IMAGE6);
		}
		else if(900<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=1000) {
			this.loadImage(Ladybug.LADYBUG_IMAGE7);
		}
		else if(800<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=900) {
			this.loadImage(Ladybug.LADYBUG_IMAGE8);
		}
		else if(700<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=800) {
			this.loadImage(Ladybug.LADYBUG_IMAGE9);
		}
		else if(600<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=700) {
			this.loadImage(Ladybug.LADYBUG_IMAGE10);
		}
		else if(500<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=600) {
			this.loadImage(Ladybug.LADYBUG_IMAGE11);
		}
		else if(400<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=500) {
			this.loadImage(Ladybug.LADYBUG_IMAGE12);
		}
		else if(300<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=400) {
			this.loadImage(Ladybug.LADYBUG_IMAGE13);
		}
		else if(200<=frozenMilli-currentMilli&&frozenMilli-currentMilli<=300) {
			this.loadImage(Ladybug.LADYBUG_IMAGE14);
		}
		
	}
	

	public void move() {
		int tempX = this.x + this.dx;
		int tempY = this.y + this.dy;

		if(tempX > GameStage.GAME_BOUND_LEFT && tempX < GameStage.GAME_BOUND_RIGHT) {
			this.x = tempX;
			for (Rectangle b : barrier) {
				if(this.collidesWith(b)) {
					this.x -= this.dx;
					break;
				
				}
			}
		}
		if(tempY > GameStage.GAME_BOUND_UP && tempY < GameStage.GAME_BOUND_DOWN) {
			this.y = tempY;   
			for (Rectangle b : barrier) {
				if(this.collidesWith(b)) {
					this.y -= this.dy;
					break;
					
				}
			}
		} 
	}
}

