/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationfx;

/**
 *
 * @author Kasia
 */
public class Recipe {
    
    private String name;
    private String image; 
    private String description; 
    private String importantText;
    private String category;
    private String creator;

    public Recipe(String name, String image, String description, String importantText, String category, String creator) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.importantText = importantText;
        this.category = category;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportantText() {
        return importantText;
    }

    public void setImportantText(String importantText) {
        this.importantText = importantText;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    

}
