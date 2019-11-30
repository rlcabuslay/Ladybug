package ladybug;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ladybug extends Sprite{
	private String name;
	private boolean alive;
	
	public final static Image LADYBUG_IMAGE = new Image("images/Sprites/Characters/LadyBug/LadyBug5.png",Ladybug.LADYBUG_WIDTH,Ladybug.LADYBUG_WIDTH,false,false);
	private final static int LADYBUG_WIDTH = 50;

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
		//try to rotate image
		final ImageView selectedImage = new ImageView();
		selectedImage.setImage(LADYBUG_IMAGE);
		selectedImage.setRotate(90);
    	this.x += this.dx;
    	this.y += this.dy;
	}
	
	//method to correct the position if LADYBUG is going off-screen
	public void checkBounds() {
    	if(this.getX()==5||this.getX()==4||this.getX()==3||this.getX()==2||this.getX()==1||this.getX()==0||this.getX()==-1||this.getX()==-2||this.getX()==-3||this.getX()==-4) {
    		this.setDX(0);
    		this.setX(getX()+1);
    	}
    	if(this.getX()==GameStage.WINDOW_WIDTH-45||this.getX()==GameStage.WINDOW_WIDTH-44||this.getX()==GameStage.WINDOW_WIDTH-43||this.getX()==GameStage.WINDOW_WIDTH-42||this.getX()==GameStage.WINDOW_WIDTH-41||this.getX()==GameStage.WINDOW_WIDTH-40||this.getX()==GameStage.WINDOW_WIDTH-39||this.getX()==GameStage.WINDOW_WIDTH-38||this.getX()==GameStage.WINDOW_WIDTH-37||this.getX()==GameStage.WINDOW_WIDTH-36){
    		this.setDX(0);
    		this.setX(getX()-1);
    	}
    	if(this.getY()==5||this.getY()==4||this.getY()==3||this.getY()==2||this.getY()==1||this.getY()==0||this.getY()==-1||this.getY()==-2||this.getY()==-3||this.getY()==-4){
    		this.setDY(0);
    		this.setY(getY()+1);
    	}
    	if(this.getY()==GameStage.WINDOW_HEIGHT-45||this.getY()==GameStage.WINDOW_HEIGHT-44||this.getY()==GameStage.WINDOW_HEIGHT-43||this.getY()==GameStage.WINDOW_HEIGHT-42||this.getY()==GameStage.WINDOW_HEIGHT-41||this.getY()==GameStage.WINDOW_HEIGHT-40||this.getY()==GameStage.WINDOW_HEIGHT-39||this.getY()==GameStage.WINDOW_HEIGHT-38||this.getY()==GameStage.WINDOW_HEIGHT-37||this.getY()==GameStage.WINDOW_HEIGHT-36) {
    		this.setDY(0);
    		this.setY(getY()-1);
    	}
	}

}
