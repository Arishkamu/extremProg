package org.ruletka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testCreate() {
        User user1 = new User("login1", "password1");
        User user2 = new User("login2", "password2");

        Assertions.assertTrue(user1.getBalance() >= 0);
        Assertions.assertTrue(user2.getBalance() >= 0);

    }
}
