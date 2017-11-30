package com.yacov.tp3_androiddev_firebase;

/**
 * Created by YacovR on 29-Nov-17.
 */

public class User {

    private String name, password, email, tel, cel, cpf, city;

    public User() {
    }

    public User(String name, String password, String email, String tel, String cel, String cpf, String city) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.cel = cel;
        this.cpf = cpf;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
