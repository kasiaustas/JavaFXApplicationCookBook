package javafxapplicationfx;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxapplicationfx.animations.Shake;

public class AutorizationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text titleBook;

    @FXML
    private Button reg;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button log;

    @FXML
    void initialize() {
        
        log.setOnAction(event -> {
            
            String loginText = login.getText().trim();
            String loginPassword = password.getText().trim();
         
            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }
            else{
                System.out.println("Error");
            }
             
         }); 
        
        reg.setOnAction(event -> {
            openNewScene("/javafxapplicationfx/Register.fxml", reg);
         
         });
    }

    private void loginUser(String loginText, String loginPassword) {
         
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        
        int counter = 0;
        try {
            while(result.next()){
                counter++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorizationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(counter>=1){
             openNewScene("/javafxapplicationfx/FXML1.fxml", log);
            
        }
        else{
            Shake userLoginAnim = new Shake(login);
            Shake userPassAnim = new Shake(password);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
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