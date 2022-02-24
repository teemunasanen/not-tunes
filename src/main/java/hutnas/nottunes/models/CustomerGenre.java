package hutnas.nottunes.models;

public class CustomerGenre {
    private int customerId;
    private String firstName;
    private String lastName;
    private String favoriteGenre;
    private String amountOfSongs;

    public CustomerGenre(int customerId, String firstName, String lastName, String favoriteGenre, String amountOfSongs) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteGenre = favoriteGenre;
        this.amountOfSongs = amountOfSongs;
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

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public String getAmountOfSongs() {
        return amountOfSongs;
    }

    public void setAmountOfSongs(String amountOfSongs) {
        this.amountOfSongs = amountOfSongs;
    }
}
