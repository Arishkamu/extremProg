package org.ruletka;

public class User {

    private int id;
    private final String login;
    private final String password;
    private int balance = 1000;

    User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }
}
