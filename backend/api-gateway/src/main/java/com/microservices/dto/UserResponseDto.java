package com.microservices.dto;

public class UserResponseDto {

    private int id;
    private String NyAP;
    private String DNI;
    private String email;
    private String phone;
    private String CVU;
    private String alias;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCVU() {
        return CVU;
    }

    public void setCVU(String CVU) {
        this.CVU = CVU;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
