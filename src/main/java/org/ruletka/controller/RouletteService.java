package org.ruletka.controller;
import org.ruletka.entites.*;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class RouletteService {

    private static final int PAYOUT_RATE = 35;
    private static final Map<Roulette.BET_TYPE, List<Integer>> ALL_BETS = new HashMap<>() {{
        ALL_BETS.put(Roulette.BET_TYPE.COLOUR_RED, List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
        ALL_BETS.put(Roulette.BET_TYPE.COLOUR_BLACK, List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
        ALL_BETS.put(Roulette.BET_TYPE.ODD, List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 3));
        ALL_BETS.put(Roulette.BET_TYPE.EVEN, List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36));
        ALL_BETS.put(Roulette.BET_TYPE.FIRST_HALF, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
        ALL_BETS.put(Roulette.BET_TYPE.SECOND_HALF, List.of(19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));
        ALL_BETS.put(Roulette.BET_TYPE.FIRST_DOZEN, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        ALL_BETS.put(Roulette.BET_TYPE.SECOND_DOZEN, List.of(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
        ALL_BETS.put(Roulette.BET_TYPE.THIRD_DOZEN, List.of(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));
    }};
    private final Random random = new Random();

    public List<Result> spinRoulette(List<Bet> bets) {
        int winningNumber = random.nextInt(37);
        List<Roulette.BET_TYPE> win_types = ALL_BETS.keySet().stream().filter(key -> ALL_BETS.get(key).contains(winningNumber)).toList();
        return bets
                .stream()
                .map(bet -> new Result(bet.getUserId(), getPayout(winningNumber, win_types, bet)))
                .toList();
    }

    private int getPayout(int winningNumber, List<Roulette.BET_TYPE> types, Bet bet) {
        if (types.contains(bet.getType())) {
            if (Roulette.mul2Win.contains(bet.getType())) {
                return bet.getAmount() * 2;
            } else if (Roulette.mul3Win.contains(bet.getType())) {
                return bet.getAmount() * 3;
            }
        }
        if (bet.getType() == Roulette.BET_TYPE.NUMBER && bet.getNumber() == winningNumber) {
            return bet.getAmount() * PAYOUT_RATE;
        }
        return 0;
    }
}