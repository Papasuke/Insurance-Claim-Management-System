package Model;

import java.util.ArrayList;

public class ClaimManager implements ClaimProcessManager {
    private ArrayList<Claim> claims;


    @Override
    public void add(Object item) {
        if (item instanceof Claim) {
            claims.add((Claim) item);
        } else {
            System.out.println("Invalid item. Must be an instance of Claim.");
        }
    }

    @Override
    public void update(Object item) {
        if (item instanceof Claim) {
            Claim updatedClaim = (Claim) item;
            for (int i = 0; i < claims.size(); i++) {
                Claim existingClaim = claims.get(i);
                if (existingClaim.getId().equals(updatedClaim.getId())) {
                    claims.set(i, updatedClaim);
                    System.out.println("Claim updated successfully.");
                    return;
                }
            }
            System.out.println("Claim not found with ID: " + updatedClaim.getId());
        } else {
            System.out.println("Invalid item. Must be an instance of Claim.");
        }
    }

    @Override
    public void delete(String id) {
        claims.removeIf(claim -> claim.getId().equals(id));
    }

    @Override
    public Object getOne(String id) {
        for (Claim claim : claims) {
            if (claim.getId().equals(id)) {
                return claim;
            }
        }
        System.out.println("Claim not found with ID: " + id);
        return null;
    }

    @Override
    public ArrayList<Claim> getAll() {
        return claims;
    }
}
