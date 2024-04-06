package Controller;

import Library.Crud;
import Model.Claim;

import java.io.IOException;
import java.util.ArrayList;

public class ClaimController {

    private static final String filePath = "Data/Claim.txt";


    public ArrayList<Claim> getAllClaims() {
        ArrayList<Claim> claims = new ArrayList<>();
        try {
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            for (String claimString : claimStrings) {
                String[] data = claimString.split(",");
                // Create a new Claim from the data and add it to the list
                Claim claim = new Claim();
                claim.setId(data[0]);
                // Set other properties of the claim similarly
                claims.add(claim);

            }
        } catch (IOException e) {
            System.err.println("Error occurred while reading claims: " + e.getMessage());
        }
        return claims;
    }

    public void addAllClaimsToCSV(ArrayList<Claim> claims) {
        try {
            //Clear CSV before update new data
            Crud.clearCSV(filePath);
            for (Claim claim : claims) {
                Crud.write(filePath, "ID, CLAIM DATE, INSURED PERSON, CARD NUMBER, EXAM DATE, CLAIM AMOUNT, STATUS", claim.toString());
            }
            System.out.println("Added all claims successfully !!!");
        } catch (IOException e) {
            System.err.println("Error occurred while adding claims to CSV: " + e.getMessage());
        }
    }
}
