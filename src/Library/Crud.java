package Library;

import java.io.*;
import java.util.ArrayList;

public class Crud {

    public static ArrayList<String> readAllLine(String filePath) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return data; // Return an empty ArrayList if the file does not exist
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // skip the first line
            br.readLine();

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                data.add(currentLine);
            }
        }

        return data;
    }

    public static void write(String filePath, String attributes, String obj) throws IOException {
        File file = new File(filePath);

        // Check if the file existed or not
        if (!file.exists()) {
            // If not create one and add attributes to the first line
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(attributes);
                writer.newLine();
            }
        } else {
            // Check if the first line has attributes or not
            boolean hasAttributes = false;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String firstLine = reader.readLine(); // Đọc dòng đầu tiên
                if (firstLine != null && firstLine.equals(attributes)) {
                    hasAttributes = true;
                }
            }

            // If not, write the attributes
            if (!hasAttributes) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(attributes);
                    writer.newLine();
                }
            }
        }

        // write new obj to the csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(obj);
            writer.newLine();
        }
    }


    public static void clearCSV(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        // Clear the data from CSV
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
        writer.close();
    }
}
