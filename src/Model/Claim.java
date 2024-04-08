package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private long cardNumber;
    private Date examDate;
    private ArrayList<String> documents;
    private long claimAmount;
    private ClaimStatus status;
    private ArrayList<BankingInfo> receiveBankingInfo;

    public Claim(String id, String claimDate, String insuredPerson, long cardNumber, String examDate, long claimAmount, ClaimStatus status) throws ParseException {
        this.id = id;
        this.claimDate = DateUtils.parseDate(claimDate);
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = DateUtils.parseDate(examDate);
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public Claim() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) throws ParseException {
        this.claimDate = DateUtils.parseDate(claimDate);
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) throws ParseException {
        this.examDate = DateUtils.parseDate(examDate);
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public long getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(long claimAmount) {
        this.claimAmount = claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public ArrayList<BankingInfo> getReceiveBankingInfo() {
        return receiveBankingInfo;
    }

    public void setReceiveBankingInfo(ArrayList<BankingInfo> receiveBankingInfo) {
        this.receiveBankingInfo = receiveBankingInfo;
    }

    private boolean validateAndFormatId(String id) {
        if (!id.matches("\\d{10}")) {
            throw new IllegalArgumentException("Claim ID must be 10 digits long.");
        }
        return true;
    }

    @Override
    public String toString() {
        return id +
                "," + DateUtils.formatDate(claimDate) +
                "," + insuredPerson +
                "," + cardNumber +
                "," + DateUtils.formatDate(examDate) +
                "," + claimAmount +
                "," + ((status != null) ? status.name() : "");
    }
}
