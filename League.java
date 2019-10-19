package Fm;
/*

    League should add the teams and 
    
    TODO
    Add league names(maybe just input)
    take care of relegation/promotion
    Maybe run the schedule and games? not sure yet
    Takes input to see how many teams to add
*/

public class League{
    private Team teams[];
    private String name;

    public League(String name, Team teams[]){//Maybe toss in special rules and stuff in here instead of just team array, REFS
        this.name = name;
        this.teams = teams;
    }

    public static League genLeague(String name, int size){//Size is how many teams in league
        Team[] teams = new Team[size]; 
        for(int i=0; i<size;i++){
            teams[i]=Team.genTeam();
        }
        League e = new League(name, teams);
        return e;
    }

    public Team[] getTeams(){
        return this.teams;
    }
    public String getLeagueName(){
        return this.name;
    }
}


