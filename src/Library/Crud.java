package Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Crud {

    //Read all data from CSV
    public static ArrayList<String> readAllLine(String filePath) throws IOException {
        ArrayList<String> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip the first line

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(",");
                Collections.addAll(products, data); // Add all data to list
            }
        }

        return products;
    }

    // Add data to csv
    public static void write(String filePath, String attributes, String obj) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            // Check if the file created or not. If not, Creating csv file and add attributes to the first line
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(attributes);
                writer.newLine();
            }
        }

        // Add new data to csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(obj);
            writer.newLine();
        }
    }

}
