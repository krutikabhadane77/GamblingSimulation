package com.gamblingsimulation;
import java.util.Random;
public class GamblingSimulation {
    static int stake = 100;
    static int bet = 1;
    public static void winLoss()
    {
        Random random=new Random();
        int bet=random.nextInt(2);
        if (bet==1) {
            System.out.println("Gambler won the bet");
            stake += bet;
        }
        else
        {
            stake -= bet;
            System.out.println("Gambler loose the bet");
        }

    }

    public static void main(String[] args) {
        System.out.println("welcome to Gambling Simulation Problem");
        System.out.println("Gambler every day stake is " + stake + "and bet is " + bet);
        winLoss();
    }
}



