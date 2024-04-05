package Model;

import java.util.ArrayList;

public class Customer {
    private String id;
    private String fullName;
    private ArrayList<InsuranceCard> insuranceCard;
    private ArrayList<Claim>claims;

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<InsuranceCard> getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(ArrayList<InsuranceCard> insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }
}
