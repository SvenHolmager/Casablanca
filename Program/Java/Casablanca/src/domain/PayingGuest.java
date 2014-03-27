/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author nickhelmark
 */
public class PayingGuest
{
    private int ID;
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String phone;
    private String email;
    private String travelAgency;
    private String checkInDate;
    private int NoOfNights;

    public PayingGuest(int ID, String firstName, String familyName, String address, String country, String phone, String email, String travelAgency, String checkInDate, int NoOfNights)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.familyName = familyName;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.travelAgency = travelAgency;
        this.checkInDate = checkInDate;
        this.NoOfNights = NoOfNights;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTravelAgency()
    {
        return travelAgency;
    }

    public void setTravelAgency(String travelAgency)
    {
        this.travelAgency = travelAgency;
    }

    public String getCheckInDate()
    {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate)
    {
        this.checkInDate = checkInDate;
    }

    public int getNoOfNights()
    {
        return NoOfNights;
    }

    public void setNoOfNights(int NoOfNights)
    {
        this.NoOfNights = NoOfNights;
    }
    
}
