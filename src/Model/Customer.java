package Model;
import java.util.List;

public class Customer {
    private String id;
    private String fullName;
    private List<InsuranceCard> insuranceCard;
    private List<Claim>claims;

    public Customer(String id, String fullName, List<InsuranceCard> insuranceCard, List<Claim> claims) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
    }
}
