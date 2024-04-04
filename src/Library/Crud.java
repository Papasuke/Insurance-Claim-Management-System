package Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crud {

    //Read all data from CSV
    public static List<String> readAllLine(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String currentLine;
        List<String> products = new ArrayList<String>();
        String[] data;

        // Skip the first line
        br.readLine();

        while ((currentLine = br.readLine()) != null) {
            data = currentLine.split(",");
            Collections.addAll(products, data); // Add all data to list
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
                writer.newLine(); // Thêm dòng mới
            }
        }

        // Add new data to csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(obj);
            writer.newLine(); // Thêm dòng mới
        }
    }

}
