package Model;

import Controller.ClaimController;

import java.util.ArrayList;
import java.util.Iterator;

public class ClaimManager implements ClaimProcessManager {
    private ArrayList<Claim> pendingClaims;
    private final ClaimController claimController;

    public ClaimManager(ClaimController claimController) {
        this.claimController = claimController;
    }

    public void updatePendingClaim() {
        if (pendingClaims == null) {
            pendingClaims = claimController.getAllClaims();
        }
    }

    public static boolean isValidClaimStatus(ClaimStatus status) {
        //Check claim status
        return status == ClaimStatus.NEW || status == ClaimStatus.PROCESSING || status == ClaimStatus.DONE;
    }

    @Override
    public void add(Object item) {
        if (item instanceof Claim newClaim) {
            if (isValidClaimStatus(newClaim.getStatus())) {
                pendingClaims.add(newClaim);
            } else {
                System.out.println("Invalid claim status. Please check the claim status.");
            }
        } else {
            System.out.println("Invalid item. Must be an instance of Claim.");
        }
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
        updatePendingClaim();
        return new ArrayList<>(pendingClaims);
    }
}
