package ecommerceplatform.console;

import java.awt.Button;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.e_commerce_platform.api.CategoryDTO;
import com.jfoenix.controls.JFXButton;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SubcategoryPane extends GridPane{
	@FXML 
	private JFXButton backButton;
	
	private int rowCounter = 1;
	private Map<Integer, String> subcategories;
	private MainWindowController controller;
	
	public SubcategoryPane(MainWindowController controller, Map<Integer, String> subcategories) {
		this.subcategories = subcategories;	
		this.controller = controller;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main/resources/view/SubcategoryPane.fxml"));
			loader.setController(new SubcategoryPaneController(controller));
			loader.setRoot(this);
			loader.load();
			subcategories.entrySet()
				.forEach(this::addButton);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addButton(Map.Entry<Integer, String> subcategory) {
		//button.setMaxHeight(Double.MAX_VALUE);
		JFXButton button = new JFXButton(subcategory.getValue());
		button.setMaxWidth(Double.MAX_VALUE);
		RowConstraints rowConstraints = new RowConstraints(40,40,40);
		getRowConstraints().add(rowConstraints);
		add(button, 0, rowCounter++);
		button.setOnAction(event -> controller.choosenCategory(subcategory.getKey()));
	}
	
}
