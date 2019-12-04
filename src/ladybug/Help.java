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

public class Help {
	public static final String HELP_CONTENT = 
			"	The only applicable controls in Lady Bug are the directional keys. Players can navigate Lady Bug up down, left or right. Enemies must be avoided altogether as a single touch will cause Lady Bug to lose a life. Green barriers can be manipulated to reveal new paths and keep your opponents at bay.\r\n\n" + 
			"	Keep in mind that you can stay in one place indefinitely as long as you have constructed a foolproof blockade. Eventually, the timer will cause your enemies to back go into the three sided box until only two or three are left. Moving barriers will also cause an 'attacking' enemy to change course.\r\n\n" + 
			"	Because your opponents will patrol the same areas in a looping pattern, you will need to learn how to move specific barriers. If one of your enemies is patrolling an area that contains flowers, you will not be able to go forward until you are able to 'outsmart' your foes.\r\n\n" + 
			"	You can either move the barriers so that a new path is created and dart in to collect the flowers just in time, or you can elect to close your enemy out and set him on a new path. Either way, you will need to take notice of the barriers surrounding your target as well as the barrier's current placement.\r\n\n" + 
			"	Walking over a green barrier that is running horizontally will cause it to turn sideways. Barriers running perpendicularly turn upright after Lady Bug walks over them. Lady Bug will continue to walk at the same speed, but enemies will go faster with each new board. Use logic, strategy and timing to get through the levels and maximize your multiplier bonuses.\r\n" + 
			"\r\n\n"
	;
	
	private Scene scene;
	
	public void switchScene(Stage primaryStage, SplashStage menu) {
		Stage window = primaryStage;
//		Creating the text for the content of Help
		Text helpContent = new Text(Help.HELP_CONTENT);
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
        Text helpTitle = new Text("Help");
        helpTitle.setId("title");
        
//      Creating the the back button
        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> window.setScene(menu.getScene()));
        
//      Adding all help elements to vbox
        VBox box = new VBox(20);
        box.getChildren().add(helpTitle);
        box.getChildren().add(sp);
        box.getChildren().add(backButton);
        box.setAlignment(Pos.CENTER);
        
        box.setId("pane");
//      Creating the help scene
        
		this.scene = new Scene(box,SplashStage.WINDOW_WIDTH,SplashStage.WINDOW_HEIGHT);
		this.scene.getStylesheets().addAll(this.getClass().getResource("ladybug.css").toExternalForm());
		
		window.setScene(this.scene);
	}
}
