package ladybug;

import javafx.scene.image.Image;
import java.util.Random;

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
	
	public final static Image REDX_IMAGE = new Image("images/Sprites/RedX.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDT_IMAGE = new Image("images/Sprites/RedT.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDR_IMAGE = new Image("images/Sprites/RedR.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDS_IMAGE = new Image("images/Sprites/RedS.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDP_IMAGE = new Image("images/Sprites/RedP.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDC_IMAGE = new Image("images/Sprites/RedC.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDI_IMAGE = new Image("images/Sprites/RedI.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDL_IMAGE = new Image("images/Sprites/RedL.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDA_IMAGE = new Image("images/Sprites/RedA.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image REDE_IMAGE = new Image("images/Sprites/RedE.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	
	public final static Image YELLOWX_IMAGE = new Image("images/Sprites/YellowX.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWT_IMAGE = new Image("images/Sprites/YellowT.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWR_IMAGE = new Image("images/Sprites/YellowR.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWS_IMAGE = new Image("images/Sprites/YellowS.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWP_IMAGE = new Image("images/Sprites/YellowP.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWC_IMAGE = new Image("images/Sprites/YellowC.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWI_IMAGE = new Image("images/Sprites/YellowI.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWL_IMAGE = new Image("images/Sprites/YellowL.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWA_IMAGE = new Image("images/Sprites/YellowA.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image YELLOWE_IMAGE = new Image("images/Sprites/YellowE.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	
	public final static Image BLUEX_IMAGE = new Image("images/Sprites/BlueX.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUET_IMAGE = new Image("images/Sprites/BlueT.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUER_IMAGE = new Image("images/Sprites/BlueR.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUES_IMAGE = new Image("images/Sprites/BlueS.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEP_IMAGE = new Image("images/Sprites/BlueP.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEC_IMAGE = new Image("images/Sprites/BlueC.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEI_IMAGE = new Image("images/Sprites/BlueI.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEL_IMAGE = new Image("images/Sprites/BlueL.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEA_IMAGE = new Image("images/Sprites/BlueA.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	public final static Image BLUEE_IMAGE = new Image("images/Sprites/BlueE.png",Collectible.LETTER_WIDTH,Collectible.LETTER_WIDTH,false,false);
	private final static int LETTER_WIDTH = 50;
	
	public Collectible(String name, int x, int y){
		super(x,y);
		this.name = name;
		Random r = new Random();
		
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
		else if(this.name=="XTR") {
			int rand=r.nextInt(3);
			if(rand==0) {
				this.loadImage(Collectible.REDX_IMAGE);
				this.name="RedX";
			}
			else if(rand==1) {
				this.loadImage(Collectible.REDT_IMAGE);
				this.name="RedT";
			}
			else if(rand==2) {
				this.loadImage(Collectible.REDR_IMAGE);
				this.name="RedR";
			}
		}
		else if(this.name=="SPCIL") {
			int rand=r.nextInt(5);
			if(rand==0) {
				this.loadImage(Collectible.REDS_IMAGE);
				this.name="RedS";
			}
			else if(rand==1) {
				this.loadImage(Collectible.REDP_IMAGE);
				this.name="RedP";
			}
			else if(rand==2) {
				this.loadImage(Collectible.REDC_IMAGE);
				this.name="RedC";
			}
			else if(rand==3) {
				this.loadImage(Collectible.REDI_IMAGE);
				this.name="RedI";
			}
			else if(rand==4) {
				this.loadImage(Collectible.REDL_IMAGE);
				this.name="RedL";
			}
		}
		else if(this.name=="AE") {
			int rand=r.nextInt(2);
			if(rand==0) {
				this.loadImage(Collectible.REDA_IMAGE);
				this.name="RedA";
			}
			else if(rand==1) {
				this.loadImage(Collectible.REDE_IMAGE);
				this.name="RedE";
			}
			
		}
	}
	
	public void collide() {
		if(this.name=="Flower") {
			GameTimer.score+=10*(GameTimer.multiplier);
		}
		else if(this.name=="Vegetable") {
			GameTimer.score+=1000+(GameTimer.currentLevel*500);
		}
		else if(this.name=="BlueHeart"||this.name=="BlueX"||this.name=="BlueT"||this.name=="BlueR"||this.name=="BlueS"||this.name=="BlueP"||this.name=="BlueC"||this.name=="BlueI"||this.name=="BlueL"||this.name=="BlueA"||this.name=="BlueE") {
			GameTimer.score+=100*(GameTimer.multiplier);
			if(this.name=="BlueHeart") {
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
		}
		else if(this.name=="YellowHeart"||this.name=="YellowX"||this.name=="YellowT"||this.name=="YellowR"||this.name=="YellowS"||this.name=="YellowP"||this.name=="YellowC"||this.name=="YellowI"||this.name=="YellowL"||this.name=="YellowA"||this.name=="YellowE") {
			GameTimer.score+=300*(GameTimer.multiplier);
			if(this.name=="YellowX") {
				if(GameTimer.takenX==false) {
					GameTimer.extra.add('X');
					GameTimer.takenX=true;
				}
			}
			else if(this.name=="YellowT") {
				if(GameTimer.takenT==false) {
					GameTimer.extra.add('T');
					GameTimer.takenT=true;
				}
			}
			else if(this.name=="YellowR") {
				if(GameTimer.takenR==false) {
					GameTimer.extra.add('R');
					GameTimer.takenR=true;
				}
			}
			else if(this.name=="YellowA") {
				if(GameTimer.takenAextra==false) {
					GameTimer.extra.add('A');
					GameTimer.takenAextra=true;
				}
			}
			else if(this.name=="YellowE") {
				if(GameTimer.takenEextra==false) {
					GameTimer.extra.add('E');
					GameTimer.takenEextra=true;
				}
			}
			for(Character c:GameTimer.extra) {
				System.out.println("Extra: "+c);
			}
			for(Character c:GameTimer.special) {
				System.out.println("Special: "+c);
			}
		}
		else if(this.name=="RedHeart"||this.name=="RedX"||this.name=="RedT"||this.name=="RedR"||this.name=="RedS"||this.name=="RedP"||this.name=="RedC"||this.name=="RedI"||this.name=="RedL"||this.name=="RedA"||this.name=="RedE") {
			GameTimer.score+=800*(GameTimer.multiplier);
			if(this.name=="RedS") {
				if(GameTimer.takenS==false) {
					GameTimer.special.add('S');
					GameTimer.takenS=true;
				}
			}
			else if(this.name=="RedP") {
				if(GameTimer.takenP==false) {
					GameTimer.special.add('P');
					GameTimer.takenP=true;
				}
			}
			else if(this.name=="RedC") {
				if(GameTimer.takenC==false) {
					GameTimer.special.add('C');
					GameTimer.takenC=true;
				}
			}
			else if(this.name=="RedI") {
				if(GameTimer.takenI==false) {
					GameTimer.special.add('I');
					GameTimer.takenI=true;
				}
			}
			else if(this.name=="RedL") {
				if(GameTimer.takenL==false) {
					GameTimer.special.add('L');
					GameTimer.takenL=true;
				}
			}
			else if(this.name=="RedA") {
				if(GameTimer.takenAspecial==false) {
					GameTimer.special.add('A');
					GameTimer.takenAspecial=true;
				}
			}
			else if(this.name=="RedE") {
				if(GameTimer.takenEspecial==false) {
					GameTimer.special.add('E');
					GameTimer.takenEspecial=true;
				}
			}
			for(Character c:GameTimer.extra) {
				System.out.println("Extra: "+c);
			}
			for(Character c:GameTimer.special) {
				System.out.println("Special: "+c);
			}
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
		else if(this.name=="RedX") {
			this.name="YellowX";
			this.loadImage(Collectible.YELLOWX_IMAGE);
		}
		else if(this.name=="RedT") {
			this.name="YellowT";
			this.loadImage(Collectible.YELLOWT_IMAGE);
		}
		else if(this.name=="RedR") {
			this.name="YellowR";
			this.loadImage(Collectible.YELLOWR_IMAGE);
		}
		else if(this.name=="RedS") {
			this.name="YellowS";
			this.loadImage(Collectible.YELLOWS_IMAGE);
		}
		else if(this.name=="RedP") {
			this.name="YellowP";
			this.loadImage(Collectible.YELLOWP_IMAGE);
		}
		else if(this.name=="RedC") {
			this.name="YellowC";
			this.loadImage(Collectible.YELLOWC_IMAGE);
		}
		else if(this.name=="RedI") {
			this.name="YellowI";
			this.loadImage(Collectible.YELLOWI_IMAGE);
		}
		else if(this.name=="RedL") {
			this.name="YellowL";
			this.loadImage(Collectible.YELLOWL_IMAGE);
		}
		else if(this.name=="RedA") {
			this.name="YellowA";
			this.loadImage(Collectible.YELLOWA_IMAGE);
		}
		else if(this.name=="RedE") {
			this.name="YellowE";
			this.loadImage(Collectible.YELLOWE_IMAGE);
		}
	}
	
	public void changeColorYellow() {
		if(this.name=="YellowHeart") {
			this.name="BlueHeart";
			this.loadImage(Collectible.BLUEHEART_IMAGE);
		}
		else if(this.name=="YellowX") {
			this.name="BlueX";
			this.loadImage(Collectible.BLUEX_IMAGE);
		}
		else if(this.name=="YellowT") {
			this.name="BlueT";
			this.loadImage(Collectible.BLUET_IMAGE);
		}
		else if(this.name=="YellowR") {
			this.name="BlueR";
			this.loadImage(Collectible.BLUER_IMAGE);
		}
		else if(this.name=="YellowS") {
			this.name="BlueS";
			this.loadImage(Collectible.BLUES_IMAGE);
		}
		else if(this.name=="YellowP") {
			this.name="BlueP";
			this.loadImage(Collectible.BLUEP_IMAGE);
		}
		else if(this.name=="YellowC") {
			this.name="BlueC";
			this.loadImage(Collectible.BLUEC_IMAGE);
		}
		else if(this.name=="YellowI") {
			this.name="BlueI";
			this.loadImage(Collectible.BLUEI_IMAGE);
		}
		else if(this.name=="YellowL") {
			this.name="BlueL";
			this.loadImage(Collectible.BLUEL_IMAGE);
		}
		else if(this.name=="YellowA") {
			this.name="BlueA";
			this.loadImage(Collectible.BLUEA_IMAGE);
		}
		else if(this.name=="YellowE") {
			this.name="BlueE";
			this.loadImage(Collectible.BLUEE_IMAGE);
		}
	}
	
	public void changeColorBlue() {
		if(this.name=="BlueHeart") {
			this.name="RedHeart";
			this.loadImage(Collectible.REDHEART_IMAGE);
		}
		else if(this.name=="BlueX") {
			this.name="RedX";
			this.loadImage(Collectible.REDX_IMAGE);
		}
		else if(this.name=="BlueT") {
			this.name="RedT";
			this.loadImage(Collectible.REDT_IMAGE);
		}
		else if(this.name=="BlueR") {
			this.name="RedR";
			this.loadImage(Collectible.REDR_IMAGE);
		}
		else if(this.name=="BlueS") {
			this.name="RedS";
			this.loadImage(Collectible.REDS_IMAGE);
		}
		else if(this.name=="BlueP") {
			this.name="RedP";
			this.loadImage(Collectible.REDP_IMAGE);
		}
		else if(this.name=="BlueC") {
			this.name="RedC";
			this.loadImage(Collectible.REDC_IMAGE);
		}
		else if(this.name=="BlueI") {
			this.name="RedI";
			this.loadImage(Collectible.REDI_IMAGE);
		}
		else if(this.name=="BlueL") {
			this.name="RedL";
			this.loadImage(Collectible.REDL_IMAGE);
		}
		else if(this.name=="BlueA") {
			this.name="RedA";
			this.loadImage(Collectible.REDA_IMAGE);
		}
		else if(this.name=="BlueE") {
			this.name="RedE";
			this.loadImage(Collectible.REDE_IMAGE);
		}
	}

}
