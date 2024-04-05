package Model;

import Library.Crud;

import java.io.IOException;
import java.util.ArrayList;

public class ClaimManager implements ClaimProcessManager {

    private String filePath;
    private ArrayList<Claim> claims;

    public ClaimManager(String filePath) {
        this.filePath = filePath;
    }

    public ClaimManager(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public void add(Object item) {
        if (item instanceof Claim) {
            try {
                Crud.write(filePath, "ID, CLAIM DATE, INSURED PERSON, CARD NUMBER, EXAM DATE, CLAIM AMOUNT, CLAIM STATUS" , (String) item);
            } catch (IOException e) {
                System.err.println("Error occurred while adding claim: " + e.getMessage());
            }
        } else {
            System.out.println("Wrong format for adding claim!");
        }
    }

    @Override
    public void update(Object item) {
    }

    @Override
    public void delete(String id) {
        claims.removeIf(claim -> claim.getId().equals(id));
    }

    @Override
    public Object getOne(String id) {
        try {
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            for (String claimString : claimStrings) {
                String[] data = claimString.split(",");
                if (data[0].equals(id)) {
                    // Create a Claim object from the data
                    Claim claim = new Claim();
                    claim.setId(data[0]);
                    // Set other properties of the claim similarly
                    return claim;
                }
            }
            System.out.println("Claim not found with ID: " + id);
        } catch (IOException e) {
            System.err.println("Error occurred while getting one claim: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> claims = new ArrayList<>();
        try {
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            claims.addAll(claimStrings);
        } catch (IOException e) {
            System.err.println("Error occurred while getting all claims: " + e.getMessage());
        }
        return claims;
    }
}
