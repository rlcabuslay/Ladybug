package ladybug;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class About {
	public static final String ABOUT_CONTENT =
			"	Lady Bug is identical to Pac-Man in many ways, including a unique back story. The main character, which is a ladybug ironically named Lady Bug, lives in a small, confined space with several other species of insects. Since space and food is in short supply, Lady Bug must get her fair share of the goods before she gets left out in the cold.\r\n\n" + 
			"	Lady Bug walks along a maze, collecting flowers, food and bonus icons. She cannot come in contact with any of her opponents or she will lose a life. Although each maze is pre-determined, there are doors that can be used to shift the layout around.\r\n\n" + 
			"	There are 18 original levels in Lady Bug, but the game is designed to go on infinitely. Only certain enemy insects will appear on certain levels, but no more than four bugs will appear on any given stage. The vegetable bonus can only appear when all four enemies have entered the board\r\n\n" + 
			"	The major difference separating Lady Bug and Pac-Man is the way in which mazes are constructed. There are barriers similar to those seen in Pac-Man, but the ones that appear in Lady Bug are color coded. Purple barriers are fixed, meaning that they cannot be moved, altered or shifted. However, green barriers can be moved at virtually any time by players.\r\n\n" + 
			"	While Lady Bug has no special powers or weapons, moving green barriers can stop enemies from pursuing, and give the main character a safe place to hide. Lady Bug also operates on a timer system, which determines when enemies will enter and exit the board. You can also use green barriers to shift your enemy's path and lead them to skulls, which will cause them to die.\r\n\n" + 
			"	Skulls are thought to represent insecticide, which is dangerous to all bugs alike. The number of skulls present on each level ranges from two to five. The further you progress in Lady Bug, the more skulls that appear on every stage.\r\n\n" + 
			"	The timer, or clock, actually ticks around the perimeter of the screen, going from green to white. Every time the clock makes a complete color change, a new enemy will appear or disappear, or a vegetable will be made available. The vegetable bonus is also time sensitive.\r\n\n" + 
			"	All bonuses are color coded and tied to a multiplier. The colors are blue, yellow and red, and the multiplier can be as high as 5X. Red letters have a base value of 500 points, and blue and yellow letters have a value of 100 and 300 points, respectively.\r\n\n" + 
			"	Flowers, which are the most numerous in Lady Bug, have a value of 10 points each. Hearts are the same color as their coordinating multiplier value. Red hearts are worth 800 points by themselves, and blue hearts have a value of 100 points. Yellow hearts are worth 300 points.\r\n\n" + 
			"	You can lose a life if you run into an enemy or accidentally pick up a skull icon. The skull symbol represents instant death, and enemy bugs are equivalent to the ghosts that Pac-Man frequently encounters. Complete each stage by grabbing all of the flowers, represented by tiny X's, and 'win' the game by getting the highest score.\r\n\n" + 
			"\r\n\n" + 
			"Special Features\r\n\n" + 
			"	Many of the special features in Lady Bug are connected to the letters that appear in the maze itself. For every stage that you complete, there will be three opportunities to pick up a new letter. The objective is to either spell out the word 'special' or 'extra.'\r\n\n" + 
			"	When the word 'special' is spelled out, players either get an extra game credit, or the opportunity to play a bonus level. The extra game credit applies to the arcade version of Lady Bug, while bonus level play is exclusive to the home console port of Lady Bug. After the text 'extra' is revealed, an extra life will be added to your total number of lives remaining in both versions of the game.\r\n\n" + 
			"	The heart bonus plays a major role in the multiplier feature. For every heart that is collected, your multiplier score will increase. Additionally, hearts cause the letters to change color. Get all three hearts within a maze in order to max out your current multiplier bonus.\r\n\n" + 
			"	The vegetable bonuses not only yield extra points, but an extra layer of defense. As soon as a bonus icon is collected, your enemies will freeze in place. This temporary freeze only lasts a few seconds, but it will give you the opportunity to grab a lot of flowers.\r\n\n" + 
			"\r\n\n"
	;
	
	private Scene scene;
	
	public void switchScene(Stage primaryStage, SplashStage menu) {
		Stage window = primaryStage;
//		Creating the text for the content of Help
		Text helpContent = new Text(About.ABOUT_CONTENT);
		helpContent.setTextAlignment(TextAlignment.JUSTIFY);
		helpContent.setWrappingWidth(800);
		helpContent.setStyle("-fx-font-size: 30px");
		
//		Creating the scrollpane for the text
		ScrollPane sp = new ScrollPane();
		sp.setPrefSize(900, 900);
		sp.setMaxSize(900, 900);
		sp.setPadding(new Insets(40,40,40,40));
		
//		Adding the text to the scrollpane
		sp.setContent(helpContent);
        Text aboutTitle = new Text("About");
        aboutTitle.setId("title");
        
//      Creating the the back button
        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> window.setScene(menu.getScene()));
        
//      Adding all help elements to vbox
        VBox box = new VBox(20);
        box.getChildren().add(aboutTitle);
        box.getChildren().add(sp);
        box.getChildren().add(backButton);
        box.setAlignment(Pos.CENTER);
        
        box.setId("pane");
//      Creating the help scene
        
		this.scene = new Scene(box,SplashStage.WINDOW_WIDTH,SplashStage.WINDOW_HEIGHT);
		this.scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
		window.setScene(this.scene);
	}
}
