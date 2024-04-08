package Controller;

import Library.Crud;
import Model.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerController {
    private static final String filePath = "src/Data/Customer.txt";

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            for (String claimString : claimStrings){
                String[] data = claimString.split(",");
                Customer customer = new Customer();
                customer.setId(data[0]);
                customer.setFullName(data[1]);
                customers.add(customer);
            }
        }
        catch (IOException e){
            System.err.println("Error occurred while reading customers: " + e.getMessage());
        }
        return customers;
    }

    public void addAllCustomersToCSV(ArrayList<Customer> customers) {
        try {
            // Clear CSV before updating new data
            Crud.clearCSV(filePath);

            // Write each customer's information to the CSV file
            for (Customer customer : customers) {
                // Convert customer's information to CSV format and write to the file
                String customerInfo = customer.getId() + "," + customer.getFullName();
                Crud.write(filePath, "ID, FULL NAME", customerInfo);
            }
        } catch (IOException e) {
            System.err.println("Error occurred while adding customers to CSV: " + e.getMessage());
        }
    }
}
