package ladybug;

import javafx.scene.image.Image;

public class Collectible extends Sprite{
	private String name;
	public static int numberBlueHearts=0;
	
	public final static Image FLOWER_IMAGE = new Image("images/Sprites/Flower.png",Collectible.FLOWER_WIDTH,Collectible.FLOWER_WIDTH,false,false);
	private final static int FLOWER_WIDTH = 30;
	
	public final static Image BLUEHEART_IMAGE = new Image("images/Sprites/BlueHeart.png",Collectible.HEART_WIDTH,Collectible.HEART_WIDTH,false,false);
	public final static Image YELLOWHEART_IMAGE = new Image("images/Sprites/YellowHeart.png",Collectible.HEART_WIDTH,Collectible.HEART_WIDTH,false,false);
	public final static Image REDHEART_IMAGE = new Image("images/Sprites/RedHeart.png",Collectible.HEART_WIDTH,Collectible.HEART_WIDTH,false,false);
	private final static int HEART_WIDTH = 50;
	
	public final static Image SKULL_IMAGE = new Image("images/Sprites/Skull.png",Collectible.SKULL_WIDTH,Collectible.SKULL_WIDTH,false,false);
	private final static int SKULL_WIDTH = 50;
	
	public final static Image VEGETABLE1_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable1.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE2_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable2.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE3_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable3.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE4_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable4.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE5_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable5.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE6_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable6.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE7_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable7.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE8_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable8.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE9_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable9.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE10_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable10.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE11_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable11.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE12_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable12.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE13_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable13.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE14_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable14.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE15_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable15.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE16_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable16.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE17_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable17.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE18_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable18.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	public final static Image VEGETABLE19_IMAGE = new Image("images/Sprites/Characters/Vegetables/vegetable19.png",Collectible.VEGETABLE_WIDTH,Collectible.VEGETABLE_WIDTH,false,false);
	private final static int VEGETABLE_WIDTH = 50;
	
	
	public Collectible(String name, int x, int y){
		super(x,y);
		this.name = name;
		
		if(this.name=="Flower") this.loadImage(Collectible.FLOWER_IMAGE);
		else if(this.name=="BlueHeart") this.loadImage(Collectible.BLUEHEART_IMAGE);
		else if(this.name=="YellowHeart") this.loadImage(Collectible.YELLOWHEART_IMAGE);
		else if(this.name=="RedHeart") this.loadImage(Collectible.REDHEART_IMAGE);
		else if(this.name=="Skull") this.loadImage(Collectible.SKULL_IMAGE);
		else if(this.name=="Vegetable") {
			if(GameTimer.currentLevel==0) this.loadImage(Collectible.VEGETABLE1_IMAGE);
			if(GameTimer.currentLevel==1) this.loadImage(Collectible.VEGETABLE2_IMAGE);
			if(GameTimer.currentLevel==2) this.loadImage(Collectible.VEGETABLE3_IMAGE);
			if(GameTimer.currentLevel==3) this.loadImage(Collectible.VEGETABLE4_IMAGE);
			if(GameTimer.currentLevel==4) this.loadImage(Collectible.VEGETABLE5_IMAGE);
			if(GameTimer.currentLevel==5) this.loadImage(Collectible.VEGETABLE6_IMAGE);
			if(GameTimer.currentLevel==6) this.loadImage(Collectible.VEGETABLE7_IMAGE);
			if(GameTimer.currentLevel==7) this.loadImage(Collectible.VEGETABLE8_IMAGE);
			if(GameTimer.currentLevel==8) this.loadImage(Collectible.VEGETABLE9_IMAGE);
			if(GameTimer.currentLevel==9) this.loadImage(Collectible.VEGETABLE10_IMAGE);
			if(GameTimer.currentLevel==10) this.loadImage(Collectible.VEGETABLE11_IMAGE);
			if(GameTimer.currentLevel==11) this.loadImage(Collectible.VEGETABLE12_IMAGE);
			if(GameTimer.currentLevel==12) this.loadImage(Collectible.VEGETABLE13_IMAGE);
			if(GameTimer.currentLevel==13) this.loadImage(Collectible.VEGETABLE14_IMAGE);
			if(GameTimer.currentLevel==14) this.loadImage(Collectible.VEGETABLE15_IMAGE);
			if(GameTimer.currentLevel==15) this.loadImage(Collectible.VEGETABLE16_IMAGE);
			if(GameTimer.currentLevel==16) this.loadImage(Collectible.VEGETABLE17_IMAGE);
			if(GameTimer.currentLevel==17) this.loadImage(Collectible.VEGETABLE18_IMAGE);
			if(GameTimer.currentLevel>=18) this.loadImage(Collectible.VEGETABLE19_IMAGE);
		}                               
	}
	
	public void collide() {
		if(this.name=="Flower") {
			GameTimer.score+=10*(GameTimer.multiplier);
		}
		else if(this.name=="Vegetable") {
			GameTimer.score+=1000+(GameTimer.currentLevel*500);
		}
		else if(this.name=="BlueHeart") {
			GameTimer.score+=100*(GameTimer.multiplier);
			Collectible.numberBlueHearts++;
			if(Collectible.numberBlueHearts==1) {
				GameTimer.multiplier=2;
			}
			else if(Collectible.numberBlueHearts==2) {
				GameTimer.multiplier=3;
			}
			else if(Collectible.numberBlueHearts==3) {
				GameTimer.multiplier=5;
			}
		}
		else if(this.name=="YellowHeart") {
			GameTimer.score+=300*(GameTimer.multiplier);
		}
		else if(this.name=="RedHeart") {
			GameTimer.score+=800*(GameTimer.multiplier);
		}
//		this.setX(-100);
//		this.setY(-100);
		System.out.println("Score: "+GameTimer.score);
		System.out.println("Multiplier: "+GameTimer.multiplier);
	}
	
	public void changeColorRed() {
		if(this.name=="RedHeart") {
			this.name="YellowHeart";
			this.loadImage(Collectible.YELLOWHEART_IMAGE);
		}
	}
	
	public void changeColorYellow() {
		if(this.name=="YellowHeart") {
			this.name="BlueHeart";
			this.loadImage(Collectible.BLUEHEART_IMAGE);
		}
	}
	
	public void changeColorBlue() {
		if(this.name=="BlueHeart") {
			this.name="RedHeart";
			this.loadImage(Collectible.REDHEART_IMAGE);
		}
	}
	
	
	
	
	
}
