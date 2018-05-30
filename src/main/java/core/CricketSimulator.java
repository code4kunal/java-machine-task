/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import pojo.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kunalsaxena
 */
public class CricketSimulator {

    private int extras = 0;
    private int ballCount = 0;
    private int noOfwickets = 0;
    private int runsScored = 0;
    private String onStrike = "JASPREET BUMRAAH";
    private String nonStrike = "MS DHONI";
    private List<String> battingLineUp = Arrays.asList("VIRAT KOHLI", "SIDDHARTH KAUL",
            "HARDIK PANDYA", "BHUBHNESHWAR KUMAR");

    private static final int MIN = 1;
    private static final int MAX = 100;

    //simulates 6 balls of cricket in a  near-real world scenario.
    public void Simulate() {
        System.out.println("Ball by ball Summary..... \n");
        System.out.println("On Strike: JASPREET BUMHRAH \n" + "Non Strike: MS DHONI\n");

        while (this.ballCount < 6) {
            this.ballCount++;
            if(noOfwickets > 3){
                System.out.println("Team all out \n");
                break;
            }
            System.out.println(" Ball No: " + this.ballCount + "\n");
            int eventTrigger = Utils.randomIntGenerator(MIN, MAX);   //generates trigger fro events
            if (eventTrigger >= 0 && eventTrigger < 60) {
                simulateRunsEvent(eventTrigger);
            } else if (eventTrigger >= 60 && eventTrigger < 73) {
                simulateInValidBallEvent(eventTrigger);
                ballCount--;
            } else if (eventTrigger >= 74 && eventTrigger < 80) {
                simulateOtherRunScoringEvents(eventTrigger);
            } else if (eventTrigger >= 80 && eventTrigger < 100) {
                simulateOutEvents(eventTrigger);
            }
        }
        System.out.println("Over Summary ......!! \n");
        System.out.println("Total runs scored: " +this.runsScored+ "\n");
        System.out.println("Total extras scored: " +this.extras+ "\n");
        System.out.println("Total No of Wickets fell: " +this.noOfwickets+ "\n");
        
    }

    //simulates run scored from bat
    private void simulateRunsEvent(int eventTrigger) {
        String event = "";
        int runScoredThisBall = 0;
        OnStrikeBatsman names = new OnStrikeBatsman();
        if (eventTrigger >= 0 && eventTrigger < 10) {
            event = Runs.ONE.getValue();
            runScoredThisBall = 1;
            names = Utils.switchStrike(this.onStrike, this.nonStrike);
            this.runsScored++;
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 10 && eventTrigger < 20) {
            event = Runs.TWO.getValue();
            runScoredThisBall = 2;
            this.runsScored = this.runsScored + 2;
            names = new OnStrikeBatsman(this.onStrike, this.nonStrike);
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 20 && eventTrigger < 30) {
            event = Runs.THREE.getValue();
            runScoredThisBall = 3;
            this.runsScored = this.runsScored + 3;
            names = Utils.switchStrike(this.onStrike, this.nonStrike);
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 30 && eventTrigger < 40) {
            event = Runs.FOUR.getValue();
            runScoredThisBall = 4;
            this.runsScored = this.runsScored + 4;
            names = new OnStrikeBatsman(this.onStrike, this.nonStrike);
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 40 && eventTrigger < 45) {   //assuming a single and 4 overthrows
            event = Runs.FIVE.getValue();
            runScoredThisBall = 5;
            names = Utils.switchStrike(this.onStrike, this.nonStrike);
            this.runsScored = this.runsScored + 5;
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 45 && eventTrigger < 50) {
            runScoredThisBall = 6;
            event = Runs.SIX.getValue();
            this.runsScored = this.runsScored + 6;
            names = new OnStrikeBatsman(this.onStrike, this.nonStrike);
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        } else if (eventTrigger >= 50 && eventTrigger < 60) {
            runScoredThisBall = 0;
            event = Runs.ZERO.getValue();
            names = new OnStrikeBatsman(this.onStrike, this.nonStrike);
            this.onStrike = names.getOnStrike();
            this.nonStrike = names.getNonStrike();
        }

        Utils.printBallSummary(event, runScoredThisBall, names.getOnStrike(), names.getNonStrike());
    }

    //simulate ways of invalid deliveries.
    private void simulateInValidBallEvent(int eventTrigger) {
        String event = "";
        int runScoredThisBall = 0;
        if (eventTrigger >= 60 && eventTrigger < 64) {
            event = InvalidBallEvents.WIDE.getValue();
            runScoredThisBall = 1;
            this.runsScored = this.runsScored + 1;
            this.extras++;
        } else if (eventTrigger >= 65 && eventTrigger < 71) {
            event = InvalidBallEvents.NOBALL.getValue();
            runScoredThisBall = 1;
            this.runsScored = this.runsScored + 1;
            this.extras++;
        } else if (eventTrigger >= 71 && eventTrigger < 73) {
            event = InvalidBallEvents.DEADBALL.getValue();
        }

        Utils.printBallSummary(event, runScoredThisBall, this.onStrike, this.nonStrike);
    }

    //simulate byes and leg byes.
    private void simulateOtherRunScoringEvents(int eventTrigger) {
        String event = "";
        OnStrikeBatsman names = new OnStrikeBatsman();
        int runScoredThisBall = 0;
        if (eventTrigger >= 73 && eventTrigger < 76) {
            event = OtherRunScoringEvents.LEGBYE.getValue(); //assuming no runs were scored.
            names = Utils.switchStrike(this.onStrike, this.nonStrike);
        } else if (eventTrigger >= 76 && eventTrigger < 80) {
            event =  OtherRunScoringEvents.BYES.getValue();
            runScoredThisBall = 1;
            names = Utils.switchStrike(this.onStrike, this.nonStrike);
            this.runsScored = this.runsScored + 1;
            this.extras++;
        }
        Utils.printBallSummary(event, runScoredThisBall, names.getOnStrike(), names.getNonStrike());
    }

    //simulate ways of getting out.
    private void simulateOutEvents(int eventTrigger) {
        String event = "";
        OnStrikeBatsman names = new OnStrikeBatsman();
        OnStrikeBatsman currentBatsmanName = new OnStrikeBatsman();
        if (eventTrigger >= 80 && eventTrigger < 85) {
            event = OutEvents.BOLD.getValue();
            currentBatsmanName = getNextBatsMan(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        } else if (eventTrigger >= 85 && eventTrigger < 90) {
            event = OutEvents.CATCH.getValue();
            currentBatsmanName = getNextBatsManAndSwitchStrike(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        } else if (eventTrigger >= 90 && eventTrigger < 95) {
            event = OutEvents.RUNOUT.getValue();
            System.out.println("Strike will be switched...!!");
            currentBatsmanName = getNextBatsManAndSwitchStrike(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        } else if (eventTrigger >= 95 && eventTrigger < 98) {
            event = OutEvents.LBW.getValue();
            currentBatsmanName = getNextBatsMan(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        } else if (eventTrigger == 99) {
            event = OutEvents.HITWICKET.getValue();
            currentBatsmanName = getNextBatsMan(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        } else if (eventTrigger == 100) {
            event = OutEvents.OBSTRUCTION.getValue();
            currentBatsmanName = getNextBatsMan(this.onStrike, this.nonStrike, this.battingLineUp, names);
            this.noOfwickets++;
        }
        Utils.printBallSummary(event, 0, currentBatsmanName.getOnStrike(), currentBatsmanName.getNonStrike());
    }

    //simulate getting next batsman from batting lineup and switch strike.
    private OnStrikeBatsman getNextBatsManAndSwitchStrike(String onStrike, String nonStrike, List<String> battingLineUp, OnStrikeBatsman names) {
        names = Utils.getNewBatsMan(this.battingLineUp); //assuming batsman crossed the sides
        names.setNonStrike(this.nonStrike);
        List<String> newLineUpList = new ArrayList<String>(this.battingLineUp);
        newLineUpList.remove(names.getListIndexForNewBatsman());
        this.battingLineUp = newLineUpList;
        names = Utils.switchStrike(names.getOnStrike(), this.nonStrike);
        this.onStrike = names.getOnStrike();
        this.nonStrike = names.getNonStrike();
        return names;
    }

    //simulate getting next batsman from batting lineup.
    private OnStrikeBatsman getNextBatsMan(String onStrike, String nonStrike, List<String> battingLineUp, OnStrikeBatsman names) {
        names = Utils.getNewBatsMan(this.battingLineUp);
        names.setNonStrike(this.nonStrike);
        List<String> newLineUpList = new ArrayList<String>(battingLineUp);
        newLineUpList.remove(names.getListIndexForNewBatsman());
        this.battingLineUp = newLineUpList;
        this.onStrike = names.getOnStrike();
        this.nonStrike = names.getNonStrike();
        return names;
    }
}
