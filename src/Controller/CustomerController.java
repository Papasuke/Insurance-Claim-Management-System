package Controller;

import Library.Crud;
import Model.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerController {
    private static final String filePath = "Data/Customer.txt";

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            for (String claimString : claimStrings){
                String[] data = claimString.split(",");
                Customer customer = new Customer();
                customer.setId(data[0]);
                customers.add(customer);
            }
        }
        catch (IOException e){
            System.err.println("Error occurred while reading customers: " + e.getMessage());
        }
        return customers;
    }
}
