package main.java.financialQueryTool.control.tickerApp;

import com.sun.javafx.css.Style;

import main.java.financialQueryTool.model.stockPkg.Stock;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TickerAppMain extends Application {

	private Group mGroup;
	private Scene mScene;
	private Stage mStage;
	private ObservableList<Stock> stockData = FXCollections.observableArrayList();
	public Color appColor = Color.TRANSPARENT;
	public Image iconImg = new Image("file:resources/images/addressBook.png");
	
	public TickerAppMain() {
		addStocks();
	}
	
	public static void main(String[] args) {
		launch(TickerAppMain.class, args);
	}

	@Override
	public void start(Stage mStage) throws Exception {
		mGroup = new Group();
		mScene = new Scene(mGroup, 600, 150, appColor);
		this.mStage = mStage;
		
		mStage.setTitle("App");
		mStage.setAlwaysOnTop(true);
		mStage.setScene(mScene);

		
		initTable();
		mStage.getIcons().add(iconImg);
		mStage.show();
	}
	
	public ObservableList<Stock> getStockData() {
		return stockData;
	}
	
	public void addStocks() {
		stockData.add(new Stock("AAPL"));
		stockData.add(new Stock("AMD"));
	}
	
	public Border getDefaultBorder() {
		BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle(StrokeType.OUTSIDE, StrokeLineJoin.BEVEL, StrokeLineCap.SQUARE, 2,0, null);
		BorderWidths borderwidths = new BorderWidths(2);
		BorderStroke borderStroke = new BorderStroke(Color.LIGHTSTEELBLUE, borderStrokeStyle, new CornerRadii(1), borderwidths);
				//(Color.LIME, borderStrokeStyle,new CornerRadii(10, false), 2);
		Border border = new Border(borderStroke);
		return border;
	}
	
	public void initTable() {
		
		Label stockNameLabel = new Label("Stock Name: ");
		Label stockNameVal = new Label(stockData.get(0).getStockNameStr());
		
		stockNameLabel.setBorder(getDefaultBorder());
		stockNameLabel.setTranslateX(10);
		stockNameLabel.setTranslateY(20);
		stockNameLabel.setPrefSize(80, 20);
		stockNameLabel.setAlignment(Pos.CENTER);
		
		stockNameVal.setBorder(getDefaultBorder());
		stockNameVal.setTranslateX(10);
		stockNameVal.setTranslateY(50);
		stockNameVal.setPrefSize(80, 20);
		stockNameVal.setAlignment(Pos.CENTER);
		

		
		mGroup.getChildren().addAll(stockNameLabel,stockNameVal);
/*		
		TableView<Stock> stockTable = new TableView<Stock>();
		stockTable.setEditable(false);
		TableColumn<Stock, String> stockNameCol = new TableColumn<Stock, String>("Stock Names");
		stockNameCol.setCellValueFactory(cellData -> cellData.getValue().getStockNameProperty());
		stockTable.getColumns().add(stockNameCol);
		stockTable.setItems(stockData);
		mGroup.getChildren().add(stockTable);
		*/
//		stockTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showStockDetails(newValue));
		
		
	}

	public Scene setMainScene() {
		return this.mScene;
	}
}
