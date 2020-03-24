
package javafxapplicationfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs{
    
    Connection dbConnecrion;
    
    public Connection getDbConnection() 
            throws ClassNotFoundException, SQLException{
        
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        /*?useUnicode=true&amp;characterEncoding=utf8*/
        
        Class.forName("com.mysql.jdbc.Driver");
        
        dbConnecrion = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        
        return dbConnecrion;
    }
    
    public void signUpUser(User user){
        
        try {
            
            String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME +
                    "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," +
                    Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," + Const.USERS_GENDER +
                    ")" + "VALUES(?,?,?,?,?,?)";
            
            PreparedStatement prSt = null;
            try {
                prSt = getDbConnection().prepareStatement(insert);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());
            
            try {
                prSt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet getUser(User user){
        
         ResultSet resSet = null;
         
            try {
                  
                String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " +
                        Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
                
                PreparedStatement prSt = null;
                try {
                    prSt = getDbConnection().prepareStatement(select);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                prSt.setString(1, user.getUserName());
                prSt.setString(2, user.getPassword());
                
                resSet = prSt.executeQuery();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        return resSet;
    }
    
    public void signUpNewRecipe(Recipe recipe){
        
        try {
            
            String insert = "INSERT INTO " + Const.RECIPES_TABLE + "(" + Const.RECIPES_NAME +
                    "," + Const.RECIPES_IMAGE + "," + Const.RECIPES_DESCRIPTION + "," +
                    Const.RECIPES_IMPORTANT_TEXT + "," + Const.RECIPES_CATEGORY + "," + Const.RECIPES_CREATOR +
                    ")" + "VALUES(?,?,?,?,?,?)";
            
            PreparedStatement prSt = null;
            try {
                prSt = getDbConnection().prepareStatement(insert);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            prSt.setString(1, recipe.getName());
            prSt.setString(2, recipe.getImage());
            prSt.setString(3, recipe.getDescription());
            prSt.setString(4, recipe.getImportantText());
            prSt.setString(5, recipe.getCategory());
            prSt.setString(6, recipe.getCreator());
            
            try {
                prSt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
