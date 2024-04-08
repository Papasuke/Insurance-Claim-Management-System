package Controller;

import Library.Crud;
import Model.Claim;
import Model.ClaimStatus;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ClaimController {

    private static final String filePath = "src/Data/Claim.txt";


    public ArrayList<Claim> getAllClaims() {
        ArrayList<Claim> claims = new ArrayList<>();
        try {
            ArrayList<String> claimStrings = Crud.readAllLine(filePath);
            for (String claimString : claimStrings) {
                String[] data = claimString.split(",");
                // Create a new Claim from the data and add it to the list
                try {
                    Claim claim = new Claim(
                            data[0],
                            data[1],
                            data[2],
                            Long.parseLong(data[3]),
                            data[4],
                            Long.parseLong(data[5]),
                            ClaimStatus.valueOf(data[6])
                    );
                    claims.add(claim);
                } catch (ParseException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error creating claim: " + e.getMessage());
                }
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
        } catch (IOException e) {
            System.err.println("Error occurred while adding claims to CSV: " + e.getMessage());
        }
    }
}
