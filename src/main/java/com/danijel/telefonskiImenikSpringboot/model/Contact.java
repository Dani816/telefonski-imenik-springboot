package com.danijel.telefonskiImenikSpringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "OIB")
    private String oib;
    @Column(name = "Telefon")
    private String phone;
    @Column(name = "Ime")
    private String firstName;
    @Column(name = "Prezime")
    private String lastName;
    @Column(name = "Adresa")
    private String address;
    @Column(name = "Grad")
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
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

    public String getAddress() { return address; }

    public void setAddress(String address) {this.address = address;}

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}
