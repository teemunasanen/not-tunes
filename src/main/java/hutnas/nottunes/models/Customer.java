package hutnas.nottunes.models;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phone;
    private String email;

    public Customer(String customerId, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
