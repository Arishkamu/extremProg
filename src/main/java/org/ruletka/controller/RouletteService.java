package org.ruletka.controller;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RouletteService {

    private static final double PAYOUT_RATE = 35.0;
    private final Random random = new Random();

//    public Result spinRoulette(Bet bet) {
//        int winningNumber = random.nextInt(37); // Generate number between 0 and 36
//        boolean win = (winningNumber == bet.getNumber());
//        double payout = win ? bet.getAmount() * PAYOUT_RATE : 0.0;
//
//        return new Result(winningNumber, win, payout);
//    }
}