package Model;

public class BankingInfo {
    private String bank;
    private String customerId;
    private String name;
    private String number;

    public BankingInfo(String bank, String customerId, String name, String number) {
        this.bank = bank;
        this.customerId = customerId;
        this.name = name;
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
