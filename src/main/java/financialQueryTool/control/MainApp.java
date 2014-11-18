package main.java.financialQueryTool.control;

import java.io.IOException;

import main.java.financialQueryTool.view.fxmllayouts.RootLayoutController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

	private Stage primaryStage;
	private Group mainGroup;
	private BorderPane borderPane;
	private Scene scene;
	Image iconImg = new Image("file:resources/images/icons/addressBook.png");

	public Group getMainGroup() {
		return this.mainGroup;
	}
	
	public Scene getMainScene() {
		return this.scene;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Trial Stage-1");
		mainGroup = new Group();
//		this.primaryStage.getIcons().add(iconImg);

		initRootLayout();
	}

	public void initRootLayout() {
		try {
//			Group p = new Group();
			FXMLLoader fLoader = new FXMLLoader();
			fLoader.setLocation(MainApp.class.getResource("../view/fxmllayouts/RootLayout.fxml"));

			
			borderPane = fLoader.load();
			
			scene = new Scene(mainGroup);
			
//	        final Scene scene2 = new Scene(new Group(), 600, 450);
//	        scene.setFill(Color.WHITE);
			
			primaryStage.setScene(scene);
			
			// The following lines of Code are important
			// They tell the RootController class which MainApp Instance to use.
			// The MainApp Instance will have the primaryStage (main stage) which can be used for
			// Animations.
			RootLayoutController rlController = fLoader.getController();
			rlController.setMainApp(this);
			
			
//			final Rectangle rect = new Rectangle(20, Color.rgb(255, 255, 255));
			final Circle circle  = new Circle(40, 40, 20);
			final Rectangle rect = new Rectangle(100, 50, 100, 50);
			
			circle.setEffect(new Lighting());
//			final Text text = new Text("Hello") ;
			String string = "";
			final Text text = new Text(130, 50, "Hello");

						
			//Create a layout for circle with text inside.
//			final StackPane stack = new StackPane();
//			stack.getChildren().addAll(rect, text);
//			stack.setLayoutX(80);
//			stack.setLayoutY(30);

//			p.getChildren().add(borderPane);
//			p.getChildren().add(stack);
//			p.getChildren().addAll(borderPane,stack);
			((Group)scene.getRoot()).getChildren().addAll(borderPane, rect, circle, text);
			primaryStage.show();
			
			final Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.setAutoReverse(true);
//			final KeyValue kv = new KeyValue(circle.centerXProperty(), 800);
//			final KeyValue kv = new KeyValue(rect.xProperty(), 800);
//			final KeyValue kv = new KeyValue(rect.xProperty(), 300, Interpolator.EASE_BOTH);
			final KeyValue kv = new KeyValue(rect.xProperty(), 300, Interpolator.EASE_BOTH);
			final KeyValue kvTxt = new KeyValue(text.xProperty(), 270, Interpolator.EASE_BOTH);
			final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
			final KeyFrame kfTxt = new KeyFrame(Duration.millis(2000), kvTxt);
			timeline.getKeyFrames().addAll(kf,kfTxt);
			timeline.play();
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage () {
		return primaryStage;
	}


	public static void main(String[] args) {
		Application.launch(args);
	}

}

