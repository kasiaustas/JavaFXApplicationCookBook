/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.text.*;

/**
 *
 * @author Kasia
 */
public class JavaFXApplicationFX extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Font.loadFont(JavaFXApplicationFX.class.getResource("resources/fonts/amaze_bold.ttf").toExternalForm(), 12);
        
        /*Parent root = FXMLLoader.load(getClass().getResource("Autorization.fxml"));*/
        /*Parent root = FXMLLoader.load(getClass().getResource("createRecipe/CreateRecipe.fxml"));*/
         Parent root = FXMLLoader.load(getClass().getResource("Autorization.fxml"));
       
       
        Scene scene = new Scene(root, 991, 800);

        primaryStage.setTitle("My Cooking Book");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
