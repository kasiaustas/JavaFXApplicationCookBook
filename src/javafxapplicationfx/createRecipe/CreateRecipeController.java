package javafxapplicationfx.createRecipe;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafxapplicationfx.DatabaseHandler;
import javafxapplicationfx.Recipe;
import javafxapplicationfx.User;

public class CreateRecipeController {
    
    List<String> listFile;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane imageBtn;

    @FXML
    private Button createRecipeBtnFinish;

    @FXML
    private Label titleNameBook1;

    @FXML
    private TextField nameRecipe;

    @FXML
    private ChoiceBox<?> catRecipe;

    @FXML
    private TextArea importantField;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextArea descrRecipe;

    @FXML
    private Button btnSingleFileChooser;

    @FXML
    private Button btnMultipleFileChooser;
    
    @FXML
    private Label labSingleFile;
    
    private  String nameImgResult;
    
    @FXML
    void multipleFileChooser(ActionEvent event) {

    }

    @FXML
    void singleFileChooser(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("jpg files (*.jpg)", listFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null){
            nameImgResult = f.getName();
            labSingleFile.setText(f.getAbsolutePath());
        }else{
        labSingleFile.setText("no file attached");
    }
        
        
          
    }
    
    @FXML
    void initialize() {
      
      cancelBtn.setOnAction(event -> {
            cancelBtn.getScene().getWindow().hide();
         
         });
      
      createRecipeBtnFinish.setOnAction(event ->  {          
           signUpNewRecipe();  
           createRecipeBtnFinish.getScene().getWindow().hide();
       }); 
      labSingleFile.setText("no file attached");
      listFile = new ArrayList<>();
      listFile.add("*.JPG");
      listFile.add("*.jpg");
      listFile.add("*.PNG");
      listFile.add("*.png");
      
    }
    
    private void  signUpNewRecipe() {
        
       /*   copy selected image to directory of the project   */
        
        String Str = new String(nameRecipe.getText()).toLowerCase();
        String sentence = Str.replaceAll("[^a-z0-9]", "");
        String StrResult = sentence.substring(0, 3);
        File getCwd = new File("").getAbsoluteFile();
        getCwd.getAbsolutePath();
        Path from = Paths.get(labSingleFile.getText());
        Path to = Paths.get(getCwd.getAbsolutePath() + "\\src\\assets\\recipe\\" + StrResult + nameImgResult); 
                
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
         if(nameImgResult != null){
        try {
            Files.copy(from, to, options);
        } catch (IOException ex) {
            Logger.getLogger(CreateRecipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
        /*   End coping  */
        
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        if(nameImgResult != null){
          String pathTo = getCwd.getAbsolutePath()+ "\\src\\assets\\recipe\\" + StrResult + nameImgResult;
          
          Recipe recipe = new Recipe(nameRecipe.getText(), pathTo, 
                   descrRecipe.getText(), importantField.getText(), "2",
                   "1");
          dbHandler.signUpNewRecipe(recipe);
        }
        else{
          String pathTo = null;  
          
          Recipe recipe = new Recipe(nameRecipe.getText(), pathTo, 
                   descrRecipe.getText(), importantField.getText(), "2",
                   "1");
          dbHandler.signUpNewRecipe(recipe);
        }
        
                
        
    }
}