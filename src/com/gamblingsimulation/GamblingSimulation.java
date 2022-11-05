package com.gamblingsimulation;
import java.util.Random;
public class GamblingSimulation {
    static int stake = 100;
    static int bet = 1;
    static int betNumber = 0;
    static int totalWinAmount = 0;
    static int monthWinAmount = 0;
    static int[] monthsDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] monthsName = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static int dayInMonth=31;
    static int luckiest=0;
    static int unluckiest=0;

    public static void winLoss() {
        Random random = new Random();
        int bet = random.nextInt(2);
        if (bet == 1) {
            System.out.println("Gambler won the bet");
            stake += bet;
        } else {
            stake -= bet;
            System.out.println("Gambler loose the bet");
        }

    }

    public static int resignDay() {
        while (stake != 50 && stake != 150) {
            betNumber = betNumber + 1;
            System.out.println("Current Bet number is: " + betNumber);
            Random random = new Random();
            int random_value = random.nextInt(2);
            if (random_value == 0) {
                stake = stake - bet;
                System.out.println("Bet outcome is: Loss");
            } else {
                stake = stake + bet;
                System.out.println("Bet outcome is: Win");
                System.out.println("Stake value is" + stake);
            }
        }
        return stake;
    }

    public static int winLostAmount() {
        for (int day = 0; day <= 20; day++) {

            while (stake != 50 && stake != 150) {
                Random random = new Random();
                int random_value = random.nextInt(2);
                if (random_value == 0) {
                    stake = stake - bet;
                } else
                    stake = stake + bet;
            }
            int dayWinAmount = stake - 100;
            System.out.println("Amount won for day " + day + 1 + dayWinAmount);
            totalWinAmount = totalWinAmount + dayWinAmount;
        }
        return totalWinAmount;
    }

    public static void monthDaysWonLost()
    {
        for (int i = 0; i < monthsDay.length; i++)
        {
            int monthWinDays = 0;
            int monthLossDays = 0;
            System.out.println();
            for (int day = 1; day <= monthsDay[i]; day++)
            {
               while (stake != 50 && stake != 150)
                {
                    Random random = new Random();
                    int random_value = random.nextInt(2);
                    if (random_value == 0)
                    {
                        stake = stake - bet;
                    }
                    else
                        stake = stake + bet;
                }
                int dayWinAmount = stake - 100;


                if (dayWinAmount < 0)
                {
                    monthLossDays = monthLossDays + 1;
                    System.out.println("Amount lost for day " + day + " of " + monthsName[i] + " : " + dayWinAmount);
                }
                else
                {
                    monthWinDays = monthWinDays + 1;
                    System.out.println("Amount won for day " + day+" of "+monthsName[i]+" : " + dayWinAmount);
                }

                monthWinAmount = monthWinAmount + dayWinAmount;
            }

            System.out.println("For " + monthsName[i] + " Total win days is: " + monthWinDays + " and Total loss days is: " + monthLossDays);
            int difference = monthWinDays - monthLossDays;
            System.out.println("The difference between the no. of days won and lost is: " + difference);
            System.out.println("For " + monthsName[i] + " Total win amount is: " + monthWinAmount);

        }

    }

    public static void luckiestUnluckiestDay() {
        int luckyDayAmt=0;
        int unluckyDayAmt=0;
        for (int day = 1; day < dayInMonth; day++) {
            int dailyWonLostAmt=0;
            int betsPlayed = 0;
            while ((dailyWonLostAmt < 50) && (dailyWonLostAmt >-50) && (betsPlayed < 100)) {
                Random random = new Random();
                betsPlayed++;
                int random_value = random.nextInt(2);
                if (random_value == 0) {
                    dailyWonLostAmt = dailyWonLostAmt - bet;
                }
                else {
                    dailyWonLostAmt = dailyWonLostAmt + bet;
                }
            }

            if (luckyDayAmt < dailyWonLostAmt) {
                luckyDayAmt=dailyWonLostAmt;
                luckiest=day;
            }

            if (unluckyDayAmt > dailyWonLostAmt)
            {
                unluckyDayAmt=dailyWonLostAmt;
                unluckiest=day;
            }

        }
        System.out.println("The gambler luckiest day is "+ luckiest + " day, and won amount is "+luckyDayAmt);
        System.out.println("The gambler luckiest day is "+ unluckiest + " day, and won amount is "+unluckyDayAmt);

    }

    public static void playingOrStopGambling()
    {
        for (int day = 1; day < dayInMonth; day++) {
            int dailyWonLostAmt = 0;
            int betsPlayed = 0;
            int totalWonLostAmt = 0;
            while ((dailyWonLostAmt < 50) && (dailyWonLostAmt > -50) && (betsPlayed < 100)) {
                Random random = new Random();
                betsPlayed++;
                int random_value = random.nextInt(2);
                if (random_value == 0) {
                    dailyWonLostAmt = dailyWonLostAmt - bet;
                } else {
                    dailyWonLostAmt = dailyWonLostAmt + bet;
                }
            }
            totalWonLostAmt += dailyWonLostAmt;
        }
        if (totalWinAmount>0){
            Random random = new Random();
            int random_no=random.nextInt(2);
            if (random_no==0)
            {
                System.out.println("The gambler won "+ totalWinAmount+ " last month and gambler continue playing");
            }
            else
            {
                System.out.println("The gambler won $"+ totalWinAmount+ " last month and gambler stop gambling");
            }
        }

        else if (totalWinAmount<=0){
            System.out.println("The gambler lost in last month " + Math.abs(totalWinAmount)+
                    " then he should stop playing now.");
        }
    }
    public static void main (String[] args) {
        System.out.println("welcome to Gambling Simulation Problem");
        System.out.println("Gambler every day stake is " + stake + "and bet is " + bet);
        winLoss();
        resignDay();
        winLostAmount();
        monthDaysWonLost();
        luckiestUnluckiestDay();
        playingOrStopGambling();
    }
}

