package Fm;
//Season should run the season for all leagues

import java.util.Map;
import java.util.LinkedHashMap;

public class Season{
    //private LeagueTable leagueTable;

    public Season(/* LeagueTable leagueTable */){//Maybe toss in special rules and stuff in here instead of just team array, REFS
        //this.leagueTable = leagueTable;
    }

    public static Season genSeason(Schedule sched, Team[] teamArray){
        int leagueSize;
        leagueSize = sched.getLeagueSize();
        //System.out.println("LeagueSize: " + leagueSize);
        Team[] updatedTeams = new Team[leagueSize];
        Team[][][] schedule = new Team[leagueSize-1][leagueSize/2][2];
        schedule = sched.getSchedule();
        Team[] weeks = new Team[leagueSize];
        String res;
        int result;
        int point =0;
        Map<Team,Integer> points = new LinkedHashMap<>();
        for(int i = 0; i<leagueSize; i++){
            points.put(teamArray[i], point);
        }
        Team hTeam;
        Team aTeam;
        //int[] points = new int[schedule.length];
        //System.out.println(schedule[0].length);
        for(int week = 0; week<leagueSize-1; week++){//For each week in season
            //System.out.println("Week "+ week + " results:"); //If you want to print out the results
            for(int gameNum = 0; gameNum<schedule[week].length; gameNum++){//For each game
                weeks = schedule[week][gameNum];
                hTeam = schedule[week][gameNum][0];
                aTeam = schedule[week][gameNum][1];
                for(int i = 0; i<leagueSize; i++){
                    if(teamArray[i].getTeamName()==hTeam.getTeamName() && teamArray[i].getPlayers()==hTeam.getPlayers()){
                        hTeam = teamArray[i];
                    }
                    if(teamArray[i].getTeamName()==aTeam.getTeamName() && teamArray[i].getPlayers()==aTeam.getPlayers()){
                        aTeam = teamArray[i];
                    }
                }

                Player[] hPlayers = hTeam.getPlayers();
                TeamStats hTeamStats = hTeam.getTeamStats();
                int hTeamPlace = hTeamStats.getTeamPlace();
                int hTeamPoints = hTeamStats.getTeamPoints();
                int hTeamGoalsFor = hTeamStats.getTeamGoalsFor();
                int hTeamGoalsAgainst = hTeamStats.getTeamGoalsAgainst();
                TeamName hTeamName = hTeam.getTeamName();

                Player[] aPlayers = aTeam.getPlayers();
                TeamStats aTeamStats = aTeam.getTeamStats();
                int aTeamPlace = aTeamStats.getTeamPlace();
                int aTeamPoints = aTeamStats.getTeamPoints();
                int aTeamGoalsFor = aTeamStats.getTeamGoalsFor();
                int aTeamGoalsAgainst = aTeamStats.getTeamGoalsAgainst();
                TeamName aTeamName = aTeam.getTeamName();

                Game game = Game.genGame(hTeam, aTeam);//Run the game

                result = game.getResult();
                hTeamGoalsAgainst += game.getATeamGoalsFor()-aTeamGoalsFor;
                aTeamGoalsAgainst += game.getHTeamGoalsFor()-hTeamGoalsFor;
                hTeamGoalsFor = game.getHTeamGoalsFor();
                aTeamGoalsFor = game.getATeamGoalsFor();


                if(result==0){
                    res = hTeamName + " won the game.";
                    hTeamPoints+=3;
                }else if(result==1){
                    res = "Draw";
                    hTeamPoints+=1;
                    aTeamPoints+=1;
                }else{
                    res = aTeam.getTeamName() + " won the game.";
                    aTeamPoints+=3;
                }
                //System.out.println(res); //If you want to print out the results

                hTeamStats = TeamStats.genTeamStats(hTeamPlace, hTeamName, hTeamPoints, hTeamGoalsFor, hTeamGoalsAgainst);
                aTeamStats = TeamStats.genTeamStats(aTeamPlace, aTeamName, aTeamPoints, aTeamGoalsFor, aTeamGoalsAgainst);
                //System.out.println(hTeamStats.getTeamPoints() + "hTeamPoints: " + hTeamPoints);
                hTeam = Team.updateTeam(hTeamName, hPlayers, hTeamStats);
                aTeam = Team.updateTeam(aTeamName, aPlayers, aTeamStats);
                //System.out.println(hTeam.getTeamStats().getTeamPoints() + "hTeamPoints: " + hTeamPoints);
                for(int i = 0; i<leagueSize; i++){
                    if(teamArray[i].getTeamName()==hTeam.getTeamName() && teamArray[i].getPlayers()==hTeam.getPlayers()){
                        //System.out.println("hTeam");
                        updatedTeams[i] = hTeam;
                    }else if(teamArray[i].getTeamName()==aTeam.getTeamName() && teamArray[i].getPlayers()==aTeam.getPlayers()){
                        //System.out.println("aTeam");
                        updatedTeams[i] = aTeam;
                    }else{
                        //System.out.println("Team");
                        updatedTeams[i] = teamArray[i];
                    }
                }
                teamArray = updatedTeams.clone();
                //System.out.println(teamArray[0].getTeamStats().getTeamPoints() + "hTeamPoints: " + hTeamPoints);
            }
        }
        LeagueTable leagueTable;
        leagueTable = LeagueTable.genLeagueTable(updatedTeams);
        
        Season e = new Season(/* leagueTable */);
        return e;
    }
}
