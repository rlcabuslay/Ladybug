package ladybug;

import javafx.scene.image.Image;

public class Insect extends Sprite{
	private String name;
	private boolean alive;
	
	public final static Image INSECT_IMAGE1 = new Image("images/Sprites/Characters/Insects/Insect1d.png",Insect.INSECT_WIDTH,Insect.INSECT_WIDTH,false,false);
	private final static int INSECT_WIDTH = 50;

	public Insect(String name, int x, int y){
		super(x,y);
		this.name = name;
		this.alive = true;
		
		this.loadImage(Insect.INSECT_IMAGE1);
	}
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 
	public String getName(){
		return this.name;
	}

	public void die(){
    	this.alive = false;
    }

	public void move() {
    	this.x += this.dx;
    	this.y += this.dy;
	}
	
	//method to correct the position if INSECT is going off-screen
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

