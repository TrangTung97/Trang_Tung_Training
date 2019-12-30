package msb.bank;

public class Customer {
    private long cifNumber,account,status, currentBalance;
    private String accountName, accountType, openDate, currentType,lastActiveDate,statusChangedDate,cardActiveDate;

    public Customer(long cifNumber, long account, long status, String accountName, String accountType, String openDate, long currentBalance, String currentType, String lastActiveDate, String statusChangedDate, String cardActiveDate) {
        this.cifNumber = cifNumber;
        this.account = account;
        this.status = status;
        this.accountName = accountName;
        this.accountType = accountType;
        this.openDate = openDate;
        this.currentBalance = currentBalance;
        this.currentType = currentType;
        this.lastActiveDate = lastActiveDate;
        this.statusChangedDate = statusChangedDate;
        this.cardActiveDate = cardActiveDate;
    }

    public void setCifNumber(long cifNumber) {
        this.cifNumber = cifNumber;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }

    public void setLastActiveDate(String lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public void setStatusChangedDate(String statusChangedDate) {
        this.statusChangedDate = statusChangedDate;
    }

    public void setCardActiveDate(String cardActiveDate) {
        this.cardActiveDate = cardActiveDate;
    }

    public long getCifNumber() {
        return cifNumber;
    }

    public long getAccount() {
        return account;
    }

    public long getStatus() {
        return status;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getOpenDate() {
        return openDate;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public String getCurrentType() {
        return currentType;
    }

    public String getLastActiveDate() {
        return lastActiveDate;
    }

    public String getStatusChangedDate() {
        return statusChangedDate;
    }

    public String getCardActiveDate() {
        return cardActiveDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cifNumber=" + cifNumber +
                ", account=" + account +
                ", status=" + status +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", openDate='" + openDate + '\'' +
                ", currentBalance='" + currentBalance + '\'' +
                ", currentType='" + currentType + '\'' +
                ", lastActiveDate='" + lastActiveDate + '\'' +
                ", statusChangedDate='" + statusChangedDate + '\'' +
                ", cardActiveDate='" + cardActiveDate + '\'' +
                '}';
    }
}
