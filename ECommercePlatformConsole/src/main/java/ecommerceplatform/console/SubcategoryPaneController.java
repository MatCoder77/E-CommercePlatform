package ecommerceplatform.console;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class SubcategoryPaneController implements Initializable{
	 @FXML
	    private JFXButton backButton;
	 TranslateTransition translateTransition;
	 TranslateTransition translateTransition2;
	 MainWindowController parentController;

	 public SubcategoryPaneController(MainWindowController parentController) {
		 this.parentController = parentController; 
	}
	    @FXML
	    private MaterialDesignIconView arrow;
	    
	    @FXML
	    void backButtonMouseEntered(MouseEvent event) {	    	
	    	translateTransition.setToX(backButton.getWidth() / 2);	
	    	translateTransition.play();
	    	
	    }

	    @FXML
	    void backButtonMouseExited(MouseEvent event) {
	    	translateTransition2.setToX(arrow.getX());	
	    	translateTransition2.play();
	    }



		@Override
		public void initialize(URL location, ResourceBundle resources) {
			translateTransition = new TranslateTransition(Duration.millis(300), arrow);
	    	
	    	translateTransition2 = new TranslateTransition(Duration.millis(300), arrow);
	    	
		}
		
		@FXML
	    void onBackButtonClicked(ActionEvent event) {
			parentController.hideSubcategoryPane();
	    }

}
