package org.ruletka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruletka.entites.Roulette;

public class TestUser {

    Roulette roulette = new Roulette();

    @Test
    public void testCreate() {
        User user1 = roulette.createUser("login1", "password1");
        User user2 = roulette.createUser("login2", "password2");

        Assertions.assertTrue(user1.getBalance() >= 0);
        Assertions.assertTrue(user2.getBalance() >= 0);

        Assertions.assertEquals(2, roulette.size());

        Assertions.assertTrue(roulette.deleteUser(user1));
        Assertions.assertFalse(roulette.deleteUser(user1));

        Assertions.assertTrue(roulette.deleteUser(user2));
        Assertions.assertEquals(0, roulette.size());
    }
}
