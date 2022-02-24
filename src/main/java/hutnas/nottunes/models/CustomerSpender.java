package hutnas.nottunes.models;

public class CustomerSpender {
    private int customerId;
    private String firstName;
    private String lastName;
    private String total;

    public CustomerSpender(int customerId, String firstName, String lastName, String total) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
