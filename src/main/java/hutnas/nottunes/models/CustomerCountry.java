package hutnas.nottunes.models;

public class CustomerCountry {
    private String country;
    private String numberOfCustomers;

    public CustomerCountry(String country, String numberOfCustomers) {
        this.country = country;
        this.numberOfCustomers = numberOfCustomers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(String numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}


