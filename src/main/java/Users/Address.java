package Users;
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    public Geo geo;

    public Address(String street, String suite, String city, String zipcode) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(double lat, double lng) {
        this.geo = new Geo(lat, lng);
    }

    @Override
    public String toString() {
        return "Address { \n \t" +
                "street = '" + street + '\'' +
                ",\n\tsuite = '" + suite + '\'' +
                ",\n\tcity = '" + city + '\'' +
                ",\n\tzipcode = '" + zipcode + '\'' +
                ",\n\tgeo = " + geo +
                "\n\t}";
    }
}
