/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author nickhelmark
 */
public class PayingGuest {

    private int Id;
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String phone;
    private String email;

    public PayingGuest(int Id, String firstName, String familyName, String address, String country, String phone, String email) {
        this.Id = Id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.email = email;

    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
