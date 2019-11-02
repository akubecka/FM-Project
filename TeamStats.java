package Fm;
//Generates league table


public class TeamStats{
    private int place;
    private TeamName teamName;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDiff;

    public TeamStats(int place, TeamName teamName, int points, int goalsFor, int goalsAgainst, int goalDiff){
        this.place = place;
        this.teamName = teamName;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDiff = goalDiff;
    }

    public static TeamStats genTeamStats(int place, TeamName teamName, int points, int goalsFor, int goalsAgainst){//Size is how many teams in league

        TeamStats e = new TeamStats(place, teamName, points, goalsFor, goalsAgainst, goalsFor-goalsAgainst);
        return e;
    }

    public int getTeamPlace(){ return this.place; }
    public TeamName getTeamTeam(){ return this.teamName; }
    public int getTeamPoints(){ return this.points; }
    public int getTeamGoalsFor(){ return this.goalsFor; }
    public int getTeamGoalsAgainst(){ return this.goalsAgainst; }
    public int getTeamGoalDiff(){ return this.goalDiff; }
}

    

