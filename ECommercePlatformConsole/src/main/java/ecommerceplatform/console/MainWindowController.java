package ecommerceplatform.console;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.e_commerce_platform.api.CategoryDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import ecommerceplatform.console.client.ServerClient;

public class MainWindowController implements Initializable{
	
	@Inject
	private ServerClient serverClient;
	
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
	private StackPane stackPane;
	
	@FXML
    private GridPane menu;
	
	private int rowCounter = 1;

	private GlyphIcon<?> currentIcon;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ServerClient client = new ServerClient();
		List<CategoryDTO> categories = client.getMainCategories();
		creteMainMenu(categories);
//		SubcategoryPane subcategoryPane = createSubcategoryMenu(categories.get(0).getSubcategories());
//		subcategoryDrower.setSidePane(subcategoryPane);
//		subcategoryDrower.getSidePane().get(0).toFront();	
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
		Platform.runLater(() -> currentIcon.setFill(Color.WHITE));
    }

    @FXML
    void onDrawerOpended(Event event) {
    	Platform.runLater(() -> currentIcon.setFill(Color.web("#FFD80D")));
    }
    
    @FXML
    void onDrawerOpening(Event event) {
    	Platform.runLater(() -> FXCollections.reverse(stackPane.getChildren()));
    }
    
    void hideSubcategoryPane() {
    	subcategoryDrower.close();
    }
    
    void createSideMenu() {
    	List<CategoryDTO> mainCategories = serverClient.getMainCategories();
    	mainCategories.stream()
    			.forEach(this::createCategory);
    }
    
    void creteMainMenu(List<CategoryDTO> categories) {
    	categories.stream()
    			.forEach(this::createCategory);
    }
    
    private void createCategory(CategoryDTO category) {
    	JFXButton button = new JFXButton(category.getName());
    	GlyphIcon<?> icon = getIcon(category.getIconName());
    	menu.add(icon, 0, rowCounter);
    	menu.add(button, 1, rowCounter++);
    	RowConstraints rowConstraints = new RowConstraints(50,50, 50);
    	menu.getRowConstraints().add(rowConstraints);
    	SubcategoryPane subcategoryPane = createSubcategoryMenu(category.getSubcategories());
    	subcategoryDrower.setSidePane(subcategoryPane);
		button.setOnAction(event -> {
			subcategoryDrower.setSidePane(subcategoryPane);
			buttonClicked(event);
			currentIcon = icon;
		});
    }
    
    private GlyphIcon<?> getIcon(String iconName) {
    	String[] arr = iconName.split("\\.");
    	switch (arr[0]) {
		case "MDI":
			return new MaterialDesignIconView(MaterialDesignIcon.valueOf(arr[1]));
		case "MI":
			return new MaterialIconView(MaterialIcon.valueOf(arr[1]));
		case "FAI":
			return new FontAwesomeIconView(FontAwesomeIcon.valueOf(arr[1]));
		default:
			throw new IllegalArgumentException("WRONG ICON NAME " + iconName);
		}
    }
    
    private SubcategoryPane createSubcategoryMenu(Collection<CategoryDTO> subcategories) {
    	Map<Integer, String> subcategoriesMap = subcategories.stream()
    			.collect(Collectors.toMap(CategoryDTO::getId, CategoryDTO::getName));
    	return new SubcategoryPane(this, subcategoriesMap);
    }
    
    public void choosenCategory(Integer categoryId) {
    	System.out.println("Wybrano kategoriê o ID: " + categoryId);
    }

}
