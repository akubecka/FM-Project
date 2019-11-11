package Fm;
/*
    Game takes care of one game
    Maybe make a week class that runs all the games of the week?
    Run through the 90 minutes and run probabilities of a team/player:
        Scoring
        Injury
        Fight
        Yellow/Red
        Foul/Penalty
        Shots
    Team Advantages
        Home
        Form(Maybe put in Team class)
        Fan Hype
    Player Advantages
        Player attributes
        Player Form
*/

import java.util.Random;
//import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.LinkedHashMap;

public class Game{
    private Team hTeam; //Home team
    private Team aTeam; //Away team
    private int result; //0 for home win, 1 for draw, 2 for away win
    private int hTeamGoalsFor;
    private int aTeamGoalsFor;
    private static Random rand;

    public Game(Team hTeam, Team aTeam, int result, int hTeamGoalsFor, int aTeamGoalsFor){
        this.hTeam = hTeam;
        this.aTeam = aTeam;
        this.result = result;
        this.hTeamGoalsFor = hTeamGoalsFor;
        this.aTeamGoalsFor = aTeamGoalsFor;
    }

    public static Game genGame(Team hTeam, Team aTeam){
        boolean printDetails = false;//Print out the game details or nah

        int time = 0;
        int extraTime = 0;//Make a formula for this
        int hScore = 0;
        int aScore = 0;
        TeamName hTeamName = hTeam.getTeamName();
        TeamName aTeamName = aTeam.getTeamName();

        TeamStats hTeamStats = hTeam.getTeamStats();
        int hTeamGoalsFor = hTeamStats.getTeamGoalsFor();
        //int hTeamGoalsAgainst = hTeamStats.getTeamGoalsAgainst();

        TeamStats aTeamStats = aTeam.getTeamStats();
        int aTeamGoalsFor = aTeamStats.getTeamGoalsFor();
        //int aTeamGoalsAgainst = aTeamStats.getTeamGoalsAgainst();
        

        Player[]  hPlayers = new Player[hTeam.getPlayers().length];
        //System.out.println("Avail1: " + hPlayers.length);
        hPlayers = hTeam.getPlayers();
        //System.out.println("Avail2: " + hPlayers.length);
        Player[]  aPlayers = new Player[aTeam.getPlayers().length];
        aPlayers = aTeam.getPlayers();

        int hPlayersAvail = hPlayers.length;//Determine this
        int aPlayersAvail = aPlayers.length;//Determine this

        if(hPlayersAvail<11){//Check number of players available
            System.out.println(hTeamName + " only have " + hPlayersAvail + "players available so they must forfeit 3-0.");
        }
        if(aPlayersAvail<11){//Check number of players available
            System.out.println(aTeamName + " only have " + aPlayersAvail + "players available so they must forfeit 3-0.");
        }



        //NEED TO DETERMINE THE STARTERS AND PEOPLE WHO PLAY SO WE DON'T TAKE BENCH PLAYERS INTO ACCOUNT
        int max = 0;
        int max2 = 0;
        Player best = hPlayers[0];
        Player best2 = hPlayers[0];
        int overall = 0;
        Player[] homeFirstEleven = new Player[11];
        //HOME STARTING 11
        for(int i = 0; i<hPlayersAvail; i++ ){//Run through all the players on home team to check stats and stuff to create starting 11
            //Need 1 gk, 1 lb, rb, 2 cbs, 2 cms, 1 lm, 1 rm, 2 sts
            if(hPlayers[i].getPosition()==Position.GOALKEEPER){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                homeFirstEleven[0] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.LEFTBACK){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                homeFirstEleven[1] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.CENTERBACK){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = hPlayers[i];
                    max2 = overall;
                }
                homeFirstEleven[2] = best;
                homeFirstEleven[3] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.RIGHTBACK){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                homeFirstEleven[4] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.LEFTWING){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                homeFirstEleven[5] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.CENTERMID){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = hPlayers[i];
                    max2 = overall;
                }
                homeFirstEleven[6] = best;
                homeFirstEleven[7] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.RIGHTWING){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                homeFirstEleven[8] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(hPlayers[i].getPosition()==Position.STRIKER){
                overall = PlayerOverall.genOverall(hPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = hPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = hPlayers[i];
                    max2 = overall;
                }
                homeFirstEleven[9] = best;
                homeFirstEleven[10] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
        }
        if(printDetails){
            System.out.println("Home Starting 11:");
            for(int i = 0; i<11; i++ ){//Print home starting 11
                System.out.println(homeFirstEleven[i].getPlayerName());
            }
        }
            


            //AWAY STARTING 11
        Player[] awayFirstEleven = new Player[11];
        for(int i = 0; i<aPlayersAvail; i++ ){//Run through all the players on home team to check stats and stuff to create starting 11
            //Need 1 gk, 1 lb, rb, 2 cbs, 2 cms, 1 lm, 1 rm, 2 sts
            if(aPlayers[i].getPosition()==Position.GOALKEEPER){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                awayFirstEleven[0] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.LEFTBACK){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                awayFirstEleven[1] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.CENTERBACK){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = aPlayers[i];
                    max2 = overall;
                }
                awayFirstEleven[2] = best;
                awayFirstEleven[3] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.RIGHTBACK){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                awayFirstEleven[4] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.LEFTWING){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                awayFirstEleven[5] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.CENTERMID){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = aPlayers[i];
                    max2 = overall;
                }
                awayFirstEleven[6] = best;
                awayFirstEleven[7] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.RIGHTWING){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                awayFirstEleven[8] = best;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
            if(aPlayers[i].getPosition()==Position.STRIKER){
                overall = PlayerOverall.genOverall(aPlayers[i]);
                //System.out.println(hPlayers[i].getPlayerName() + ":" + overall);
                if(overall>=max){
                    best = aPlayers[i];
                    max = overall;
                }
                if(overall<max && overall>max2){
                    best2 = aPlayers[i];
                    max2 = overall;
                }
                awayFirstEleven[9] = best;
                awayFirstEleven[10] = best2;
                //System.out.println("Best GK on " + hTeam + " is " + best.getPlayerName());
            }
        }
        if(printDetails){
            System.out.println("Away Starting 11:");
            for(int i = 0; i<11; i++ ){//Print away starting 11
                System.out.println(awayFirstEleven[i].getPlayerName());
            }
        }
            


        while(time <= (90 + extraTime)){
            //Add a delay here for realism, 1 second per minute or something
            if(printDetails){
                System.out.println(time + "minute; " + hTeamName + " " + hScore + " : " + aScore + " " + aTeamName);
            }
            time++;

            //Always print lines above
            //Now we get into the gameplay and predictions
            /*
                The idea is basicaly to run through every minute of the game
                For every minute we run probabilities on every player doing an action
            */

            float oddsToShoot = 0;   
            float oddsToScore = 0;

            float oddsToPass = 0;
            float oddsToCompletePass = 0;
            float oddsToSave = 0;
                Map<Position,Integer> positionToShot = new LinkedHashMap<>();
                positionToShot.put(Position.GOALKEEPER, 1);
                positionToShot.put(Position.LEFTBACK, 5);
                positionToShot.put(Position.CENTERBACK, 3);
                positionToShot.put(Position.RIGHTBACK, 5);
                positionToShot.put(Position.LEFTWING, 10);
                positionToShot.put(Position.CENTERMID, 9);
                positionToShot.put(Position.RIGHTWING, 10);
                positionToShot.put(Position.STRIKER, 20);

            for(int i = 0; i<homeFirstEleven.length; i++ ){//Run through all the players on home team to check stats and stuff
                int finishing = homeFirstEleven[i].getPlayerAttributeMap().get("Finishing");
                int passing = homeFirstEleven[i].getPlayerAttributeMap().get("Passing");
                int pace = homeFirstEleven[i].getPlayerAttributeMap().get("Pace");

                oddsToShoot = (finishing/10)*positionToShot.get(homeFirstEleven[i].getPosition());
                rand = new Random();
                float shot = rand.nextInt(1000) + oddsToShoot;
                if(shot>=900){
                    oddsToScore = oddsToShoot*(finishing*2);//Change this 3 to their conversion rate, gk ability, form, morale, etc
                    float score = rand.nextInt(1000) + oddsToScore;
                    if(score>=850){
                        if(printDetails){
                            System.out.println(homeFirstEleven[i].getPlayerName()+ " scored a goal for " + hTeam.getTeamName() + "!!");
                        }
                        hScore++;
                        hTeamGoalsFor++;
                    }else{
                        if(printDetails){
                            System.out.println(homeFirstEleven[i].getPlayerName()+ " shot for " + hTeam.getTeamName() + " was saved :(");
                        }
                    }
                }
            }

            for(int i = 0; i<awayFirstEleven.length; i++ ){//Run through all the players on home team to check stats and stuff
                int finishing = awayFirstEleven[i].getPlayerAttributeMap().get("Finishing");
                int passing = awayFirstEleven[i].getPlayerAttributeMap().get("Passing");
                int pace = awayFirstEleven[i].getPlayerAttributeMap().get("Pace");

                oddsToShoot = (finishing/10)*positionToShot.get(awayFirstEleven[i].getPosition());
                rand = new Random();
                float shot = rand.nextInt(1000) + oddsToShoot;
                if(shot>=985){
                    oddsToScore = oddsToShoot*(finishing*2);//Change this 3 to their conversion rate, gk ability, form, morale, etc
                    float score = rand.nextInt(1000) + oddsToScore;
                    if(score>=850){
                        if(printDetails){
                            System.out.println(awayFirstEleven[i].getPlayerName()+ " scored a goal for " + aTeam.getTeamName() + "!!");
                        }
                        aScore++;
                        aTeamGoalsFor++;
                    }else{
                        if(printDetails){
                            System.out.println(awayFirstEleven[i].getPlayerName()+ " shot for " + aTeam.getTeamName() + " was saved :(");
                        }
                    }
                }
            }
        }

        int result = 0;
        if(hScore>aScore){
            result=0;
        }else if(hScore<aScore){
            result=2;
        }else{
            result=1;
        }
        Game e = new Game(hTeam, aTeam, result, hTeamGoalsFor, aTeamGoalsFor);
        return e;
    }

    public Team getHomeTeam(){
        return this.hTeam;
    }
    public Team getAwayTeam(){
        return this.aTeam;
    }
    public int getResult(){
        return this.result;
    }
    public int getHTeamGoalsFor(){
        return this.hTeamGoalsFor;
    }
    public int getATeamGoalsFor(){
        return this.aTeamGoalsFor;
    }


}