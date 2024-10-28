package org.ruletka.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roulette")
public class GameController {

    @Autowired
    private RouletteService rouletteService;

//    @PostMapping("/bet")
//    public Result placeBet(@RequestBody Bet bet) {
//        if (bet.getNumber() < 0 || bet.getNumber() > 36) {
//            throw new IllegalArgumentException("Bet number must be between 0 and 36.");
//        }
//        return rouletteService.spinRoulette(bet);
//    }
}