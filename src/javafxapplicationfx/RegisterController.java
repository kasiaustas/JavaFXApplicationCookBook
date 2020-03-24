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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField passwordReg;

    @FXML
    private Button register;

    @FXML
    private Text titleReg;

    @FXML
    private TextField countryReg;

    @FXML
    private TextField nameReg;

    @FXML
    private TextField surnameReg;

    @FXML
    private TextField loginReg;

    @FXML
    private RadioButton femaleReg;

    @FXML
    private RadioButton maleReg;

    @FXML
    void initialize() {
          
       register.setOnAction(event ->  {          
           signUpNewUser(); 
           openNewScene("/javafxapplicationfx/FXML1.fxml", register);
       });  

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        String gender = "";
        if(maleReg.isSelected()){
            gender = "Male";
        }
        else{
            gender = "Female"; 
        }
        
        User user = new User(nameReg.getText(), surnameReg.getText(), 
                   loginReg.getText(), passwordReg.getText(), countryReg.getText(),
                   gender);
        
        dbHandler.signUpUser(user);
    }
    
     public void openNewScene(String window, Button buttn){
    buttn.getScene().getWindow().hide();
              FXMLLoader loader = new  FXMLLoader();
              loader.setLocation(getClass().getResource(window));
             try {
                 loader.load();
             } catch (IOException ex) {
                 Logger.getLogger(AutorizationController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             Parent root = loader.getRoot();
             Stage stage = new Stage();
             stage.setScene(new Scene(root));
             stage.showAndWait();
   }
}
