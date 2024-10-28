package org.ruletka.entites;

public class Bet {
    private final int userId;
    private final int number;
    private final int amount;

    public Bet(int userId, int number, int amount) {
        this.userId = userId;
        this.number = number;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }
}
