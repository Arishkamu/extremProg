package org.ruletka.controller;
import org.ruletka.entites.Bet;
import org.ruletka.entites.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roulette")
public class GameController {

    @Autowired
    private RouletteService rouletteService;

    @PostMapping("/spin")
    public List<Result> placeBet(@RequestBody List<Bet> bets) {
        if (bets.isEmpty()) {
            throw new IllegalArgumentException("Bet number must be between 0 and 36.");
        }
        return rouletteService.spinRoulette(bets);
    }
}