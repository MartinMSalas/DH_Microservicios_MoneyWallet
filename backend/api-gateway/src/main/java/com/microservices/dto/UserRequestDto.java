package com.microservices.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDto {

    @NotBlank(message = "Name and surname are required")
    private String NyAP;

    @NotNull(message = "DNI is required")
    @Pattern(regexp = "\\d+", message = "DNI must be a number")
    private String DNI;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\+?\\d+", message = "Phone number should be valid")
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;

    // Getters and Setters
    public String getNyAP() {
        return NyAP;
    }

    public void setNyAP(String nyAP) {
        NyAP = nyAP;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
