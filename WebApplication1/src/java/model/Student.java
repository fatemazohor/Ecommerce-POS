/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Student {
    private int Idstudent;
    private String sName;
    private String email;
    private String password;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Student() {
    }

    public Student(int Idstudent, String sName, String email, String password, String gender, String address, String city, String state, String zip) {
        this.Idstudent = Idstudent;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Student(String sName, String email, String password, String gender, String address, String city, String state, String zip) {
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getIdstudent() {
        return Idstudent;
    }

    public void setIdstudent(int Idstudent) {
        this.Idstudent = Idstudent;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Studentdao{" + "Idstudent=" + Idstudent + ", sName=" + sName + ", email=" + email + ", password=" + password + ", gender=" + gender + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
    }
    
}
