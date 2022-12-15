package br.com.supermarketapi.models;

//Represents the product entity, which will be manipulated by the Admin user
public class Product extends BaseEntity {
    private String name;
    private String description;

    //Placeholder - Will change to image later
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
