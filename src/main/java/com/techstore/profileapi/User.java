package com.techstore.profileapi;



import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber; }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotNull(message = "email cannot be empty" )
    @Email
    private String email;
    @NotNull(message = "Full name cannot be empty" )
    private String fullName;
    @NotNull
    private String userType;
    @NotNull(message = "Phone number cannot be empty" )
    @Digits(integer = 10, fraction = 0, message = "invalid number")
    private String phoneNumber;
    @NotNull(message = "Password cannot be empty" )
    @Size (min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters" )
    private String password;

}
