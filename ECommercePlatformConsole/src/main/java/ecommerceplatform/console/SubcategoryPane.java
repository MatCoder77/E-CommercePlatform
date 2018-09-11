package ecommerceplatform.console;

import java.awt.Button;
import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SubcategoryPane extends GridPane{
	@FXML 
	private JFXButton backButton;
	
	private int rowCounter = 1;
	private List<String> subcategories;
	
	public SubcategoryPane(MainWindowController controller, List<String> subcategories) {
		this.subcategories = subcategories;		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main/resources/view/SubcategoryPane.fxml"));
			loader.setController(new SubcategoryPaneController(controller));
			loader.setRoot(this);
			loader.load();
			subcategories.stream()
				.map(JFXButton::new)
				.forEach(this::addButton);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addButton(JFXButton button) {
		//button.setMaxHeight(Double.MAX_VALUE);
		button.setMaxWidth(Double.MAX_VALUE);
		RowConstraints rowConstraints = new RowConstraints(40,40,40);
		getRowConstraints().add(rowConstraints);
		add(button, 0, rowCounter++);
	}
	
}
