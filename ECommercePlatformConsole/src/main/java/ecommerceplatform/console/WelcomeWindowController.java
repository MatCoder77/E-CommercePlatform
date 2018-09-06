package ecommerceplatform.console;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WelcomeWindowController {

	@FXML
	private JFXButton signInButton;
	
	@FXML
	private JFXButton signUpButton;
	
	@FXML
	private JFXButton buttonToStep2;
	
	@FXML
	private JFXButton buttonToStep3;
	
	@FXML
	private JFXButton logginButton;
	
	@FXML
	private JFXButton finishRegistrationButton;
	
	@FXML
	private AnchorPane loggingPane;
	
	@FXML
	private AnchorPane registrationPaneStep1;
	
	@FXML
	private AnchorPane registrationPaneStep2;
	
	@FXML
	private AnchorPane registrationPaneStep3;
	
	
	@FXML
	private void singInButtonClicked(ActionEvent event) {
		loggingPane.toFront();
	}
	
	@FXML
	private void singUpButtonClicked(ActionEvent event) {
		registrationPaneStep1.toFront();
	}
	
	@FXML
	private void buttonToStep2Clicked(ActionEvent event) {
		registrationPaneStep2.toFront();
	}
	
	@FXML void buttonToStep3Clicked(ActionEvent event) {
		registrationPaneStep3.toFront();
	}
	
	@FXML
	private void finishRegistrationButtonClicked(ActionEvent event) {
		
	}
	
	/**
	 * @param event
	 */
	@FXML
	private void loginButtonClicked(ActionEvent event) {
		Stage stage = (Stage) logginButton.getScene().getWindow();
		FXMLLoader loader;
		
		loader = new FXMLLoader(getClass().getClassLoader().getResource("main/resources/view/MainWindow2.fxml"));
		
		try {
			Scene scene = new Scene((Pane) loader.load());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setFullScreen(true);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.show();
		stage.centerOnScreen();
	}
}
