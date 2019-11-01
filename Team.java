package Fm;

/*
    Generate players so there is at 18-24 players on each team

    TODO
    Make sure there is at least 1 of each position with exceptions
    2 centerbacks
    2 centermids
    2 strikers
    Just do players for now but add manager/staff/etc eventually
    Add team names
*/

import java.util.Random;

public class Team{
    private Player players[];
    private static Random rand;
    private TeamName name;//Change int to String when you wanna come up with a bunch of names
    private TeamStats teamStats;

    public Team(TeamName name, Player players[], TeamStats teamStats){
        this.players = players;
        this.name = name;
        this.teamStats = teamStats;
    }

    public static Team genTeam(){
        rand = new Random();
        TeamName name = TeamName.randomTeamName();
        int max = rand.nextInt(5)+18;//Random team size 18-24
        Player[] players = new Player[max]; 
        players[0]=Player.genPlayerWithPos(0, Position.GOALKEEPER);
        players[1]=Player.genPlayerWithPos(1, Position.LEFTBACK);
        players[2]=Player.genPlayerWithPos(2, Position.CENTERBACK);
        players[3]=Player.genPlayerWithPos(3, Position.CENTERBACK);
        players[4]=Player.genPlayerWithPos(4, Position.RIGHTBACK);
        players[5]=Player.genPlayerWithPos(5, Position.LEFTWING);
        players[6]=Player.genPlayerWithPos(6, Position.CENTERMID);
        players[7]=Player.genPlayerWithPos(7, Position.CENTERMID);
        players[8]=Player.genPlayerWithPos(8, Position.RIGHTWING);
        players[9]=Player.genPlayerWithPos(9, Position.STRIKER);
        players[10]=Player.genPlayerWithPos(10, Position.STRIKER);
        for(int i=11; i<max;i++){//Generate the number of players for the team
            players[i]=Player.genPlayer(i);
        }
        TeamStats teamStats = TeamStats.genTeamStats(0, name, 0, 0, 0); //Initialize teamStats(place, name, points, goalsFor, goalsAgainst);
        Team e = new Team(name, players, teamStats);
        return e;
    }
    public static Team updateTeam(TeamName name, Player players[], TeamStats teamStats){
        Team e = new Team(name, players, teamStats);
        return e;
    }
    public TeamName getTeamName(){//Change int to String when you wanna come up with a bunch of names
        return this.name;
    }
    public Player[] getPlayers(){
        return this.players;
    }
    public TeamStats getTeamStats(){
        return this.teamStats;
    }
}

