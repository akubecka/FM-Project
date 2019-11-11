package Fm;

import java.util.Scanner;

public class Fm{
    public static void main(String[] args){
        //LEAGUE SIZE MUST BE AN EVEN NUMBER >= 4
        //final int leagueSize = 10;
        /*
            Steps:
            Generate league -> teams -> players first
            Put that into schedule and generate schedule
            Then run season using schedule
        */
        
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter leagueSize: ");
        int leagueSize = myObj.nextInt();  // Read user input
        //final int leagueSize = 14;
        League league;
        league = League.genLeague("BPL", leagueSize);
        Team[] teamArray;
        teamArray = league.getTeams();
        Schedule schedule;
        schedule = Schedule.genSchedule(league);
        Season season;
        season = Season.genSeason(schedule, teamArray);
        System.out.println(season);
        
        //System.out.println(Season.genSeason(Schedule.genSchedule(leagueSize, League.genLeague("bpl",leagueSize).getTeams())));
        //System.out.println(Schedule.genSchedule(leagueSize, League.genLeague("bpl",leagueSize).getTeams()));
        //System.out.println(Player.genPlayer(1,0).getAttributeMap());
       // System.out.println(Team.genTeam(1).getPlayers().length);
        //System.out.println(League.genLeague("BPL", 20).getTeams()[2].getTeamName());
        

        //League league = League.genLeague("BPL", leagueSize);
        //Team hTeam = league.getTeams()[0];
        //Team aTeam = league.getTeams()[1];
        //System.out.println(Game.genGame(hTeam, aTeam));
        
        /*System.out.println(league.getLeagueName());
        for(int i=0; i<16; i++){
            System.out.println("Team: " + league.getTeams()[i].getTeamName());
            for(int j=0; j<league.getTeams()[i].getPlayers().length; j++){
                System.out.println("Player: " + league.getTeams()[i].getPlayers()[j].getPlayerName()
                    +league.getTeams()[i].getPlayers()[j].getPlayerAttributeMap() + "Height: " + 
                    league.getTeams()[i].getPlayers()[j].getPlayerHeight() + ", Weight: " + league.getTeams()[i].getPlayers()[j].getPlayerWeight()
                    + " Position: "+league.getTeams()[i].getPlayers()[j].getPosition());
            }
        }
*/
    }
} 