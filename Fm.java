package Fm;

public class Fm{
    public static void main(String[] args){
        final int leagueSize = 20;
        //System.out.println(Schedule.genSchedule(leagueSize));
        //System.out.println(Player.genPlayer(1,0).getAttributeMap());
       // System.out.println(Team.genTeam(1).getPlayers().length);
        //System.out.println(League.genLeague("BPL", 20).getTeams()[2].getTeamName());
        

        League league = League.genLeague("BPL", leagueSize);
        Team hTeam = league.getTeams()[0];
        Team aTeam = league.getTeams()[1];
        System.out.println(Game.genGame(hTeam, aTeam));
        /*
        System.out.println(league.getLeagueName());
        for(int i=0; i<20; i++){
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