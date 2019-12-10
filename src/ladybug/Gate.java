package ladybug;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Gate extends Sprite{
	private String name;
	
	
	public final static Image GATE_UP = new Image("images/Sprites/GateUp.png", Gate.GATE_HEIGHT, Gate.GATE_WIDTH, false, false);
	public final static Image GATE_DOWN = new Image("images/Sprites/GateDown.png", Gate.GATE_WIDTH, Gate.GATE_HEIGHT, false, false);
	private final static int GATE_WIDTH = 120;
	private final static int GATE_HEIGHT = 8;
	
	public Gate(String name, int x, int y){
		super(x,y);
		
		Random r = new Random();
		int rand=r.nextInt(8);
		
		if(rand==0) {
			this.loadImage(Gate.GATE_UP);
			this.name="Up";
		}
		else if(rand==1) {
			this.loadImage(Gate.GATE_DOWN);
			this.name="Down";
		}
		
	}
	
	public void rotate() {
		if(this.name=="Up") {
			this.loadImage(Gate.GATE_DOWN);
			this.name="Down";
			this.setX(this.getX()-Gate.GATE_WIDTH/2);
			this.setY(this.getY()+Gate.GATE_WIDTH/2);
		}
		else if(this.name=="Down") {
			this.loadImage(Gate.GATE_UP);
			this.name="Up";
			this.setX(this.getX()+Gate.GATE_WIDTH/2);
			this.setY(this.getY()-Gate.GATE_WIDTH/2);
		}
	}
}