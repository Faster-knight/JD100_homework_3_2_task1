public class Address {
    private String country;
    private String city;
    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    @Override
    public int hashCode() {
        return 31 * country.hashCode() + city.hashCode();
    }
}
