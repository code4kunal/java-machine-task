/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import pojo.OnStrikeBatsman;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author kunalsaxena
 */
public class Utils {

    public static int randomIntGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static OnStrikeBatsman switchStrike(String onStrike, String nonStrike) {
        String temp = onStrike;
        onStrike = nonStrike;
        nonStrike = temp;

        return new OnStrikeBatsman(onStrike, nonStrike);
    }

    public static void printBallSummary(String event, int runsScored, String onStrike, String nonStrike) {
        System.out.println("Event Occured: " + event + "\n");
        System.out.println("Runs Scored: " + runsScored + "\n");
        System.out.println("------------------------------------------------------------------ \n");
        System.out.println("OnStrike batsman name: " + onStrike + "\n");
        System.out.println("NonStrike batsman name: " + nonStrike + "\n");
    }

    public static OnStrikeBatsman getNewBatsMan(List<String> battingLineUp) {
        String name = battingLineUp.get(0);
        OnStrikeBatsman names = new OnStrikeBatsman(name, 0);
        return names;
    }

}
