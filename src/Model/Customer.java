package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ClaimProcessManager {
    private String id;
    private String fullName;
    private List<InsuranceCard> insuranceCard;
    private ArrayList<Claim>claims;

    public Customer(String id, String fullName, List<InsuranceCard> insuranceCard, ArrayList<Claim> claims) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
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

    public List<InsuranceCard> getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(List<InsuranceCard> insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public void update(Object item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Object getOne(String id) {
        return null;
    }

    @Override
    public ArrayList getAll() {
        return null;
    }
}
