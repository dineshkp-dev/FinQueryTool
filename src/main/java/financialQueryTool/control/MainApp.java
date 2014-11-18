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
			FXMLLoader fLoader = new FXMLLoader();
			fLoader.setLocation(MainApp.class.getResource("../view/fxmllayouts/RootLayout.fxml"));
			
			borderPane = fLoader.load();
			
			scene = new Scene(mainGroup);
			
			primaryStage.setScene(scene);
			
			// The following lines of Code are important
			// They tell the RootController class which MainApp Instance to use.
			// The MainApp Instance will have the primaryStage (main stage) which can be used for
			// Animations.
			RootLayoutController rlController = fLoader.getController();
			rlController.setMainApp(this);
			
		    ((Group)scene.getRoot()).getChildren().addAll(borderPane);
		    
			primaryStage.show();
		} 
		
		catch (IOException e) {
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

