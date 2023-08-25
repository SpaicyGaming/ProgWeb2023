package it.unitn.progweb.g30.progweb2023;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String mail;
    private transient String password;
    private transient UserType userType;
    private String stringifiedType;
    private String nome;
    private String cognome;
    private String bd;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStringifiedType() {
        return stringifiedType;
    }

    public void setUserType(UserType ut) {
        this.userType = ut;
        this.stringifiedType = ut.getStringifiedType();
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
