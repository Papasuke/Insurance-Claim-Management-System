import Controller.ClaimController;
import Controller.CustomerController;
import Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


//public class Main {
//        public static void main(String[] args) {

//        CustomerController customerController = new CustomerController();
//
//        CustomerManager customerManager = new CustomerManager(customerController);
//        customerManager.updatePendingCustomers();
//
//        // Adding new customer to pendingCustomers
//        Customer newCustomer = new Customer("4", "John 3");
//        customerManager.add(newCustomer);
//        customerController.addAllCustomersToCSV(customerManager.getAll());

//            Claim claim1 = new Claim();
//            claim1.setId("1");
//            claim1.setClaimDate(new Date());
//            claim1.setInsuredPerson("John");
//            claim1.setCardNumber(1234567890);
//            claim1.setExamDate(new Date());
//            claim1.setClaimAmount(1000);
//            claim1.setStatus(ClaimStatus.NEW);
//
//
//            System.out.println("Claim 1:");
//            System.out.println(claim1);
//
//
//            ArrayList<String> documents = new ArrayList<>();
//            documents.add("Document 1");
//            documents.add("Document 2");
//
//
//            Claim claim2 = new Claim("2", new Date(), "Alice", 9876543210L, new Date(), 2000, ClaimStatus.PROCESSING);
//            claim2.setDocuments(documents);
//
//
//            System.out.println("\nClaim 2:");
//            System.out.println(claim2);
//
//
//            String dateString = "15/04/2024";
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            try {
//                Date date = dateFormat.parse(dateString);
//                System.out.println("\nParsed Date: " + date);
//            } catch (ParseException e) {
//                System.out.println("Error parsing date: " + e.getMessage());
//            }
//        }
//    }

public class Main {
    public static void main(String[] args) {

        CustomerController customerController = new CustomerController();


        ClaimController claimController = new ClaimController();


        ClaimManager claimManager = new ClaimManager(claimController, customerController);
        claimManager.updatePendingClaim();


        CustomerManager customerManager = new CustomerManager(customerController);
        customerManager.updatePendingCustomers();


        Customer insuredCustomer = customerManager.getOne("c4");

        if (insuredCustomer != null) {
            try {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date currentDate = new Date();
                String formattedCurrentDate = dateFormat.format(currentDate);


                Claim newClaim = new Claim("1234567895", formattedCurrentDate, insuredCustomer.getId(), 1234567890, formattedCurrentDate, 1000, ClaimStatus.NEW);

                claimManager.add(newClaim);

                claimController.addAllClaimsToCSV(claimManager.getAll());
            } catch (ParseException e) {
                System.out.println("Error while parsing date: " + e.getMessage());
            }
        } else {
            System.out.println("Insured customer with ID 'c3' not found.");
        }
    }
}