package Users;
public class User {
    private String name;
    private String username;
    private String email;
    public Address address;
    private String phone;
    private String website;
    public Company company;

    public User(String name, String username, String email, Address address, String phone, String website, Company company) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public User(String name, String username, String email, String phone, String website) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(String street, String suite, String city, String zipcode) {
        this.address = new Address(street, suite, city, zipcode);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(String name, String catchPhrase, String bs) {
        this.company = new Company(name, catchPhrase, bs);
    }

    @Override
    public String toString() {
        return "User {\n " +
                "name = '" + name + '\'' +
                ",\n username = '" + username + '\'' +
                ",\n email = '" + email + '\'' +
                ",\n address = " + address +
                ",\n phone = '" + phone + '\'' +
                ",\n website = '" + website + '\'' +
                ",\n company = " + company +
                "\n}";
    }
}

