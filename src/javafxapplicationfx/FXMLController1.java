package javafxapplicationfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane imageBtn;

    @FXML
    private ImageView imgMe;

    @FXML
    private AnchorPane eatList;

    @FXML
    private Button createRecipeBtn;

    @FXML
    private CheckBox cat1;

    @FXML
    private CheckBox cat2;

    @FXML
    private CheckBox cat3;

    @FXML
    private Label titleNameBook;

    @FXML
    void initialize() {
       createRecipeBtn.setOnAction(event -> {
            openNewScene("/javafxapplicationfx/createRecipe/CreateRecipe.fxml", createRecipeBtn);
         
         });

    }
    
    public void openNewScene(String window, Button buttn){
   
        /*buttn.getScene().getWindow().hide();*/
              FXMLLoader loader = new  FXMLLoader();
              loader.setLocation(getClass().getResource(window));
             try {
                 loader.load();
             } catch (IOException ex) {
                 Logger.getLogger(FXMLController1.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             Parent root = loader.getRoot();
             Stage stage = new Stage();
             stage.setScene(new Scene(root));
             stage.showAndWait();
            
   }
}
