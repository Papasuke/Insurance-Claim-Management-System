package Model;

import Controller.CustomerController;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerManager implements ClaimProcessManager{

    private ArrayList<Customer> pendingCustomers;
    private final CustomerController customerController;

    public CustomerManager(CustomerController customerController){
        this.customerController = customerController;
    }

    public void updatePendingCustomers() {
        if (pendingCustomers == null) {
            pendingCustomers = new ArrayList<>();
        }

        // Get Customer data from customerController
        ArrayList<Customer> allCustomers = customerController.getAllCustomer();

        // Only adding Customers that not included in the data
        for (Customer customer : allCustomers) {
            if (!isCustomerExist(customer.getId())) {
                pendingCustomers.add(customer);
            }
        }
    }

    @Override
    public void add(Object item) {
        if (item instanceof Customer) {
            Customer newCustomer = (Customer) item;
            if (newCustomer.getId() != null) { // check if the ID of customer valid or not
                if (!isCustomerExist(newCustomer.getId())) { // check to ignore duplicated customers
                    pendingCustomers.add(newCustomer);
                    System.out.println("Customer added successfully.");
                } else {
                    System.out.println("Customer with ID " + newCustomer.getId() + " already exists.");
                }
            } else {
                System.out.println("Invalid information. Customer ID is required.");
            }
        } else {
            System.out.println("Invalid information. Must be an instance of Customer.");
        }
    }

    // Check if customer existed or not
    private boolean isCustomerExist(String customerId) {
        for (Customer customer : pendingCustomers) {
            if (customer.getId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Object item) {
        if (item instanceof Customer updatedCustomer) {
            for (int i = 0; i < pendingCustomers.size(); i++) {
                Customer existingCustomer = pendingCustomers.get(i);
                if (existingCustomer.getId().equals(updatedCustomer.getId())) {
                    pendingCustomers.set(i, updatedCustomer);
                    System.out.println("Customer updated successfully.");
                    return;
                }
            }
            System.out.println("Customer not found with ID: " + updatedCustomer.getId());
        } else {
            System.out.println("Invalid item. Must be an instance of Customer.");
        }
    }

    @Override
    public void delete(String id) {
        Iterator<Customer> iterator = pendingCustomers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId().equals(id)) {
                iterator.remove();
                System.out.println("Customer with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Customer not found with ID: " + id);
    }

    @Override
    public Customer getOne(String id) {
        for (Customer customer : pendingCustomers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        System.out.println("Customer not found with ID: " + id);
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        //Using updatePendingCustomers to keep the data in the ArrayList Up to date.
        updatePendingCustomers();
        return new ArrayList<>(pendingCustomers);
    }
}
