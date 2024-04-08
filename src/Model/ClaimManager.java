package Model;

import Controller.ClaimController;
import Controller.CustomerController;

import java.util.ArrayList;
import java.util.Iterator;

public class ClaimManager implements ClaimProcessManager {
    private ArrayList<Claim> pendingClaims;
    private ArrayList<Customer> pendingCustomers;
    private final ClaimController claimController;
    private final CustomerController customerController;

    public ClaimManager(ClaimController claimController, CustomerController customerController) {
        this.claimController = claimController;
        this.customerController = customerController;
    }

    public void updatePendingClaim() {
        if (pendingClaims == null) {
            pendingClaims = new ArrayList<>();
        }

        // Get Customer data from customerController
        updatePendingCustomers(); // Update Customer list

        // Get all claims from claimController
        ArrayList<Claim> allClaims = claimController.getAllClaims();

        // Only adding Claims that not included in the data
        for (Claim claim : allClaims) {
            if (!isClaimExist(claim.getId())) {
                pendingClaims.add(claim);
            }
        }
    }

    private void updatePendingCustomers() {
        // Update customer list from CustomerController
        pendingCustomers = customerController.getAllCustomer();
    }

    private boolean isClaimExist(String claimId) {
        for (Claim claim : pendingClaims) {
            if (claim.getId().equals(claimId)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidClaimStatus(ClaimStatus status) {
        //Check claim status
        return status == ClaimStatus.NEW || status == ClaimStatus.PROCESSING || status == ClaimStatus.DONE;
    }

    @Override
    public void add(Object item) {
        if (item instanceof Claim newClaim) {
            // Check Claim id exist or not
            boolean claimExists = claimExists(newClaim.getId());
            if (claimExists) {
                System.out.println("Claim with ID " + newClaim.getId() + " already exists.");
                return;
            }
            boolean insuredPersonAlreadyUsed = isInsuredPersonAlreadyUsed(newClaim.getInsuredPerson());
            if (insuredPersonAlreadyUsed) {
                System.out.println("Insured person with ID " + newClaim.getInsuredPerson() + " is already used in another claim.");
                return;
            }

            // Check insured Person valid or not
            boolean insuredPersonExists = insuredPersonExists(newClaim.getInsuredPerson());
            if (!insuredPersonExists) {
                System.out.println("Insured person with ID " + newClaim.getInsuredPerson() + " does not exist.");
                return;
            }

            if (isValidClaimStatus(newClaim.getStatus())) {
                pendingClaims.add(newClaim);
                System.out.println("Claim added successfully.");
            } else {
                System.out.println("Invalid claim status. Please check the claim status.");
            }
        } else {
            System.out.println("Invalid information. Must be an instance of Claim.");
        }
    }

    private boolean isInsuredPersonAlreadyUsed(String insuredPersonId) {
        for (Claim claim : pendingClaims) {
            if (claim.getInsuredPerson().equals(insuredPersonId)) {
                return true;
            }
        }
        return false;
    }

    private boolean claimExists(String claimId) {
        return pendingClaims.stream().anyMatch(claim -> claim.getId().equals(claimId));
    }

    private boolean insuredPersonExists(String customerId) {
        return pendingCustomers.stream().anyMatch(customer -> customer.getId().equals(customerId));
    }

    @Override
    public void update(Object item) {
        if (item instanceof Claim updatedClaim) {
            if (isValidClaimStatus(updatedClaim.getStatus())) {
                for (int i = 0; i < pendingClaims.size(); i++) {
                    Claim existingClaim = pendingClaims.get(i);
                    if (existingClaim.getId().equals(updatedClaim.getId())) {
                        // Update claim if it follows Claim Status
                        pendingClaims.set(i, updatedClaim);
                        System.out.println("Claim updated successfully.");
                        return;
                    }
                }
                System.out.println("Claim not found with ID: " + updatedClaim.getId());
            } else {
                System.out.println("Invalid claim status. Please check the claim status.");
            }
        } else {
            System.out.println("Invalid item. Must be an instance of Claim.");
        }
    }

    @Override
    public void delete(String id) {
        Iterator<Claim> iterator = pendingClaims.iterator();
        while (iterator.hasNext()) {
            Claim claim = iterator.next();
            if (claim.getId().equals(id)) {
                iterator.remove();
                System.out.println("Claim with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Claim not found with ID: " + id);
    }

    @Override
    public Object getOne(String id) {
        for (Claim claim : pendingClaims) {
            if (claim.getId().equals(id)) {
                return claim;
            }
        }
        System.out.println("Claim not found with ID: " + id);
        return null;
    }

    @Override
    public ArrayList<Claim> getAll() {
        //Using updatePendingClaim to keep the data in the ArrayList Up to date.
        updatePendingClaim();
        return new ArrayList<>(pendingClaims);
    }
}
