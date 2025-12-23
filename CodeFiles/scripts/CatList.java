import java.util.*;
import java.io.*;

/**
 * Class CatList that extends the ArrayList of public class Cat, with methods for use.
 */
public class CatList extends ArrayList<Cat> {

    /**
     * Inserts a cat and its data into the ArrayList.
     */
    public void insert(String name, String description, String category, String imagePath) {
        super.add(new Cat(name, description, category, imagePath));
    }

    /**
     * Reads all cats from a text file and adds them to the list.
     */
    public void getCatData(String filePath) {
        try {
            Scanner file = new Scanner(new File(filePath));
            while (file.hasNextLine()) {
                String line = file.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 4) continue;

                String name = parts[0].trim();
                String desc = parts[1].trim();
                String categ = parts[2].trim();
                String img = parts[3].trim();

                super.add(new Cat(name, desc, categ, img));
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    /**
     * Returns a list of cats that belong to the specified category.
     */
    public CatList getCatsByCategory(String category) {
        CatList filteredList = new CatList();
        for (Cat cat : this) {
            if (cat.category.equalsIgnoreCase(category)) {
                filteredList.add(cat);
            }
        }
        return filteredList;
    }
    /**
     * Prints the details of all cats in the list.
     */
    public void printCatList() {
        for (Cat cat : this) {
            System.out.println("Name: " + cat.name);
            System.out.println("Description: " + cat.description);
            System.out.println("Category: " + cat.category);
            System.out.println("Image Path: " + cat.imagePath);
            System.out.println("---------------------------");
        }
    }

    /**
     * Returns a list of all unique categories from the cat list.
     */
    public ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();

        categories.add("Domestic");
        categories.add("Wild");
        categories.add("Hybrid");
        categories.add("Ancestral");

        return categories;
    }


}