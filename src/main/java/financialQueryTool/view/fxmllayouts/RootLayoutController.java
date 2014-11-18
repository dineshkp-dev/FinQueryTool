package main.java.financialQueryTool.view.fxmllayouts;

//import com.sun.javafx.geom.Rectangle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
	
	private Duration duration = Duration.seconds(4);
	
    @FXML
    private void initialize() {
    	
    }
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void changeVisibility () {
		
		Rectangle whrect = new Rectangle(-30, 142, 100, 65);
		whrect.setFill(Color.BLUE);
		
    	Scene scene = mainApp.getMainScene();   	
    	System.out.println("scene xval: " + scene.getHeight());
    	System.out.println("scene yval: " + scene.getWidth());
    	((Group)scene.getRoot()).getChildren().addAll(bluerect, whrect);
    	whrect.setVisible(false);
    	
    	mainApp.getPrimaryStage().setScene(scene);
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setRate(1);
		
		
		KeyValue kvx = new KeyValue(bluerect.xProperty(), 600);
		System.out.println("KVX END VALUE: "+kvx.getEndValue());
		
		KeyFrame kf = new KeyFrame(duration, kvx);
    	timeline.getKeyFrames().add(kf);
    	
    	timeline.play();
    	
/*    	Timeline timeln2 = new Timeline();
    	Duration durationm500ms = Duration.seconds(3.8);
    	Duration durationp500ms = Duration.seconds(4.2);
    	timeln2.setDelay(durationm500ms);
    	timeln2.setCycleCount(Timeline.INDEFINITE);
    	timeln2.setRate(1);
    	KeyValue kvx2 = new KeyValue(whrect.xProperty(), 600);
    	KeyFrame kf2 = new KeyFrame(durationp500ms, kvx2);
    	timeln2.getKeyFrames().add(kf2);
    	timeln2.play();
    	whrect.setVisible(true);
*/    	
		blueCircle.setEffect(new Lighting());
//		blueCircle.setVisible(false);
	}

}
