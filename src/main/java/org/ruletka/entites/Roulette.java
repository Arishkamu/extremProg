package org.ruletka.entites;

import org.ruletka.User;

import java.util.ArrayList;

public class Roulette {
    ArrayList<User> users = new ArrayList<>();

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

}
