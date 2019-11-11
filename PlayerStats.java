package Fm;
//Organizes player stats


public class PlayerStats{
    private int playerGamesPlayed;
    private int playerGoalsScored;
    private int playersGoalsAgainst;
    private int playersShots;
    private float playerShotConversionRate;

    public PlayerStats(int playerGamesPlayed, int playerGoalsScored,
                    int playersGoalsAgainst, int playersShots, float playerShotConversionRate){
        this.playerGamesPlayed = playerGamesPlayed;
        //this.teamsPlayerPlayedFor = teamsPlayerPlayedFor;
        this.playerGoalsScored = playerGoalsScored;
        this.playersGoalsAgainst = playersGoalsAgainst;
        this.playersShots = playersShots;
        this.playerShotConversionRate = playerShotConversionRate;
    }

    public static PlayerStats genPlayerStats(int playerGamesPlayed, int playerGoalsScored,
    int playersGoalsAgainst, int playersShots){//Size is how many teams in league
        float num = 0;
        if(playerGoalsScored!=0 && playersShots!=0){
            num = playerGoalsScored/playersShots;
        }
        PlayerStats e = new PlayerStats(playerGamesPlayed, playerGoalsScored,
                    playersGoalsAgainst, playersShots, num);
        return e;
    }

    public int getPlayerGamesPlayed(){ return this.playerGamesPlayed; }
    //public Team[] getTeamsPlayerPlayedFor(){ return this.teamsPlayerPlayedFor; }
    public int getPlayerGoalsScored(){ return this.playerGoalsScored; }
    public int getPlayerGoalsAgainst(){ return this.playersGoalsAgainst; }
    public int getPlayersShots(){ return this.playersShots; }
    public float getPlayerShotConversionRate(){ return this.playerShotConversionRate; }
}
