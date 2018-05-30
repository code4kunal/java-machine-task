/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.CricketSimulator;
/**
 *
 * @author kunalsaxena
 */
public class EbCricketSimulationTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Innings Started");
        CricketSimulator cricket = new CricketSimulator();
        cricket.Simulate();
    }
    
}
