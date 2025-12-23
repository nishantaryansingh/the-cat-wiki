import java.io.*;
import java.util.*;

/**
 * Program used to build the Cat Wiki Webpage.
 *
 * @author Nishant Aryan Singh
 */
public class Main {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Main() {}

    // File paths (run from The-Cat-Wiki root)
    // ALWAYS write to the project folder you're running from
    private static final String outputFile = "view_result.html";
    private static final String inputFile = "CodeFiles/cat_family_list.txt";

    /**
     * Main method for this program.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        CatList cats = new CatList();
        cats.getCatData(inputFile);

        createHomePage(outputFile, cats);
    }
    /**
     * Method used for creating the main html home page where 
     * all the cats are listed and organized by breed.
     * 
     * @param outputFile the path to the output HTML file
     * @param cats the CatList object containing all cat data
     */
    private static void createHomePage(String outputFile, CatList cats) {
    try {
        FileWriter fw = new FileWriter(outputFile);

        // Alphabetical sort
        Collections.sort(cats, (a, b) -> a.name.compareToIgnoreCase(b.name));

        fw.write("<!DOCTYPE html>\n");
        fw.write("<html>\n");
        fw.write("<head>\n");
        fw.write("<meta charset=\"UTF-8\">\n");
        fw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        fw.write("<title>The Cat Wiki</title>\n");

        // CSS part
        fw.write("<style>\n");
        fw.write("body{margin:0;font-family:Arial,sans-serif;background:#0f1220;color:#eaeaf0;}\n");
        fw.write(".container{max-width:1100px;margin:auto;padding:25px;}\n");
        fw.write("h1{text-align:center;margin-bottom:30px;}\n");
        fw.write(".grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(260px,1fr));gap:18px;}\n");
        fw.write(".card{background:#181c36;border-radius:14px;overflow:hidden;box-shadow:0 10px 25px rgba(0,0,0,.4);}\n");
        fw.write(".card img{width:100%;height:170px;object-fit:cover;}\n");
        fw.write(".card-body{padding:14px;}\n");
        fw.write(".name{margin:0;font-size:18px;}\n");
        fw.write(".type{display:inline-block;margin-top:6px;font-size:12px;background:#2a3166;padding:4px 10px;border-radius:999px;}\n");
        fw.write(".desc{margin-top:10px;font-size:13px;color:#cfd3ff;line-height:1.4;}\n");
        fw.write("</style>\n");

        // HTML body part
        fw.write("</head>\n");
        fw.write("<body>\n");
        fw.write("<div class=\"container\">\n");
        fw.write("<h1>🐈‍⬛ The Cat Wiki 🐈</h1>\n");

        fw.write("<div class=\"grid\">\n");

        // using for loop to go through each cat and add its data to the html
        for (Cat cat : cats) {
            String imgSrc = "CodeFiles/" + cat.imagePath;

            fw.write("<div class=\"card\">\n");
            fw.write("<img src=\"" + imgSrc + "\" alt=\"" + cat.name + "\">\n");
            fw.write("<div class=\"card-body\">\n");
            fw.write("<h3 class=\"name\">" + cat.name + "</h3>\n");
            fw.write("<span class=\"type\">" + cat.category + "</span>\n");
            fw.write("<p class=\"desc\">" + cat.description + "</p>\n");
            fw.write("</div>\n");
            fw.write("</div>\n");
        }
        // closing tags
        fw.write("</div>\n");
        fw.write("</div>\n");
        fw.write("</body>\n");
        fw.write("</html>\n");
        // close the file writer    
        fw.close();
        System.out.println("Homepage created: " + outputFile);

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

}
