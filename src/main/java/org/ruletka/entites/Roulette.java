package org.ruletka.entites;

import org.ruletka.User;

import java.util.ArrayList;
import java.util.List;

public class Roulette {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Bet> bets = new ArrayList<>();

    public enum BET_TYPE{
        NUMBER,
        COLOUR_RED,
        COLOUR_BLACK,
        ODD,
        EVEN,
        FIRST_HALF,
        SECOND_HALF,
        FIRST_DOZEN,
        SECOND_DOZEN,
        THIRD_DOZEN
    }

    public static final List<BET_TYPE> mul2Win = List.of(BET_TYPE.COLOUR_RED, BET_TYPE.COLOUR_BLACK, BET_TYPE.EVEN, BET_TYPE.ODD, BET_TYPE.FIRST_HALF, BET_TYPE.SECOND_HALF);
    public static final List<BET_TYPE> mul3Win = List.of(BET_TYPE.FIRST_DOZEN, BET_TYPE.SECOND_DOZEN, BET_TYPE.THIRD_DOZEN);
    public User createUser(String login, String password) {
        User newUser = new User(login, password, users.size());
        users.add(newUser);
        return newUser;
    }

    public boolean deleteUser(User user) {
        return users.remove(user);
    }

    public int size() {
        return users.size();
    }

    public boolean makeBet(int userId, int amount, BET_TYPE type, int num) {
        if (userId >= this.size() || userId < 0) {
            throw  new IllegalArgumentException("no such user");
        }
        if (users.get(userId).getBalance() < amount) {
            throw new IllegalArgumentException("not enoght money");
        }
        users.get(userId).minusBalance(amount);
        Bet newBet = new Bet(userId, type, amount);
        if (type == BET_TYPE.NUMBER) {
            newBet.setNumber(num);
        }
        return bets.add(newBet);
    }



    public User findByUid(Integer id) {
        return users.get(id);
    }

}
