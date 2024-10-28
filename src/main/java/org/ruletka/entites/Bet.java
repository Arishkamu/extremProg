package org.ruletka.entites;

import java.util.IllegalFormatException;
import java.util.Optional;

public class Bet {
    private final int userId;
    private final Roulette.BET_TYPE bet_type;
    private int number = -1;
    private final int amount;

    public Bet(int userId, Roulette.BET_TYPE type, int amount) {
        this.userId = userId;
        this.bet_type = type;
        this.amount = amount;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Roulette.BET_TYPE getType() {
        return bet_type;
    }

    public int getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }
}
