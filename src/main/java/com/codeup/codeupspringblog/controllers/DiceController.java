package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {
    private Random rnd = new Random();

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "rolldice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String showRollDice(@PathVariable int guess, Model model) {

        List<String> messages = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String message = rollDiceAndCreateMessage(guess);
            messages.add(message);
        }
        model.addAttribute("messages", messages);
        return "rolldice";
    }

    private String rollDiceAndCreateMessage(int guess) {
        // generate a random number from 1 to 6
        int roll = rnd.nextInt(6); // returns a number from 0 to 5
        roll++; // shift it to a number from 1 to 6

        // put logic for checking the user's guess here
        String message = String.format("You guessed %d. The rolls is %d. ", guess, roll);
        if(guess == roll) {
            message += "You guessed correct!";
        } else {
            message += "Nice try loser!!";
        }
        return message;
    }


}
