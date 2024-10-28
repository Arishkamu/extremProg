package org.ruletka.controller;
import org.ruletka.entites.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RouletteService {

    private static final int PAYOUT_RATE = 35;
    private final Random random = new Random();

    public List<Result> spinRoulette(List<Bet> bets) {
        int winningNumber = random.nextInt(37);
        return bets
                .stream()
                .map(bet -> new Result(bet.getUserId(), getPayout(winningNumber, bet)))
                .toList();
    }

    private int getPayout(int winningNumber, Bet bet) {
        return (winningNumber == bet.getNumber()) ? bet.getAmount() * PAYOUT_RATE : 0;
    }
}