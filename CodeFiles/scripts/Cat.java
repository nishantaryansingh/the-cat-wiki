/**
 * Class was created to make a simple way to organize all the cat data
 */
public class Cat {
    public String name, description, category, imagePath;

    /** 
     * Create the inner method that is to be used to add data. 
     */
    public Cat(String name, String description, String category, String imagePath) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imagePath = imagePath;
    }
}