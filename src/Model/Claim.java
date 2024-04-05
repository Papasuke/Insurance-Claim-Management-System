package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim implements ClaimProcessManager{
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private long cardNumber;
    private Date examDate;
    private List<String> documents;
    private long claimAmount;
    private ClaimStatus status;
    private ArrayList<BankingInfo> receiveBankingInfo;

    public Claim(String id, Date claimDate, String insuredPerson, long cardNumber, Date examDate, List<String> documents, long claimAmount, ClaimStatus status, ArrayList<BankingInfo> receiveBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiveBankingInfo = receiveBankingInfo;
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

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
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

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
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
