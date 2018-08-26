package ecommerceplatform.console;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainWindowController implements Initializable{
	
	@FXML
	private JFXButton closeButton;
	
	@FXML GridPane mainPane;
	
	@FXML 
	private MaterialDesignIconView electronicIcon;
	
	@FXML
	private void closeButtonClicked(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	@FXML
    private JFXDrawer subcategoryDrower;
	
	@FXML
    private JFXButton electronicButton;
	
	@FXML
	private StackPane stackPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/SubcategoryPane.fxml"));
			loader.setController(new SubcategoryPaneController(this));
			GridPane content = loader.load();//FXMLLoader.load(getClass().getResource("/SubcategoryPane.fxml"));
			subcategoryDrower.setSidePane(content);
			//subcategoryDrower.getSidePane().get(0).toFront();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FXML
    void buttonClicked(ActionEvent event) {
		if(subcategoryDrower.isOpened()) {
			subcategoryDrower.close();
		}
		else {
			//subcategoryDrower.toFront();
			//mainPane.toFront();
			//FXCollections.reverse(stackPane.getChildren());
			subcategoryDrower.open();
		}
    }
	
	@FXML
    void onDrawerClosed(Event event) {
		Platform.runLater(() -> FXCollections.reverse(stackPane.getChildren()));
		Platform.runLater(() -> electronicIcon.setFill(Color.WHITE));
    }

    @FXML
    void onDrawerOpended(Event event) {
    	Platform.runLater(() -> electronicIcon.setFill(Color.web("#FFD80D")));
    }
    
    @FXML
    void onDrawerOpening(Event event) {
    	Platform.runLater(() -> FXCollections.reverse(stackPane.getChildren()));
    }
    
    void hideSubcategoryPane() {
    	subcategoryDrower.close();
    }

}
