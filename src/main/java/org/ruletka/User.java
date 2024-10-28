package org.ruletka;


public class User {

    private int id;
    private final String login;
    private final String password;
    private int balance = 1000;

    public User(String login, String password, int id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }
}
