package Model;
import java.util.Date;

public class InsuranceCard {
    private String cardNumber;
    private String cardHolder;
    private String policyHolder;
    private Date expirationDate;

    public InsuranceCard(String cardNumber, String cardHolder, String policyHolder, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyHolder = policyHolder;
        this.expirationDate = expirationDate;
    }
}
