package Datamodel;

public class Data {
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String title;
    private String description;
    private String id;

    //unparameterised constructor
    public Data(){

    }
    //generate construtor and the both getters and setters
    public Data(String image, String title, String description, String id) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.id = id;
    }


}
