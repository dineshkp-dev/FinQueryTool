package main.java.financialQueryTool.view.fxmllayouts;

//import com.sun.javafx.geom.Rectangle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.java.financialQueryTool.control.MainApp;

public class RootLayoutController {
	private MainApp mainApp;
	private Timeline timeline;
	private Stage pStage;
	private Group mGroup;
	
	@FXML
	private Circle blueCircle;
	
	@FXML
	private Rectangle bluerect;
	
	private Duration duration = Duration.millis(500);
	
    @FXML
    private void initialize() {
    	
    	// Set the Stage value to be same as the one in the Main App
//    	this.setPrimaryStage();
    	
//    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNamePropery());
//    	lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	
    	// Clear the person details
//    	showPersonDetails(null);
    	
    	// Listen for selection changes and show the person details when changed.
//    	personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    	
    }
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void changeVisibility () {
		
    	Group group = new Group();
//		Group group = mainApp.getMainGroup();
//    	Scene scene = new Scene(group);
    	Scene scene = mainApp.getMainScene();   	
    	 
    	((Group)scene.getRoot()).getChildren().addAll(bluerect);
    	mainApp.getPrimaryStage().setScene(scene);
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.setRate(1);
		timeline.setAutoReverse(true);
		bluerect.setVisible(true);
		
		KeyValue kv = new KeyValue(bluerect.xProperty(), 300);
		KeyFrame kf = new KeyFrame(duration, kv);
    	timeline.getKeyFrames().add(kf);
    	timeline.play();
    	
//    	mainApp.getPrimaryStage().requestFocus();
//    	mainApp.getPrimaryStage().setFullScreen(true);
//    	mainApp.getPrimaryStage().toFront();
//		mainApp.getPrimaryStage().show();
		/*
		Group group = new Group();
		Scene scene = new Scene(group);
		
		final Text text = new Text("Hello there!");
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.setRate(1);
		timeline.setAutoReverse(true);
		
		
		final Rectangle rect = new Rectangle(200, 50, 100, 40);
		((Group)scene.getRoot()).getChildren().addAll(rect, text);
//		Duration duration = Duration.millis(500);
//		final KeyValue kv = new KeyValue(blueCircle.centerXProperty(), 500);
		final KeyValue kv = new KeyValue(rect.xProperty(), 300, Interpolator.EASE_BOTH);
		
		final KeyFrame kf = new KeyFrame(duration, kv);
		timeline.getKeyFrames().add(kf);
		
//		
//		KeyValue keyValueX = new KeyValue(, endValue) 
		timeline.play();
		
//		KeyFrame keyframe = new KeyFrame(duration, keyValueX, keyValueY);
		
*/		blueCircle.setEffect(new Lighting());
//		blueCircle.setVisible(false);
	}

}
