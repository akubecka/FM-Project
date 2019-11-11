package Fm;

/*
    This is the class that generates a Random layer
    They should have random attributes from 0-10
    We will start small with only 3 attributes: Passing, Finishing, Pace
    Eventually we will create the "Overall" rating with a formula based on their other attributes and stats
    Determine position or assign a random position

    TODO
    Add nationality, height, weight, sponsors, history?
    Make height and weight a bell curve
    Make weight relate to height and other physical attributes
    */

import java.util.Random;
import java.util.Map;
import java.util.LinkedHashMap;


public class Player{
    private Position position;
    private int number;
    private static Random rand;
    private Map<String, Integer> attributes;
    private PlayerName name;
    private int height;
    private int weight;
    private PlayerStats playerStats;
    //Number is the number they are on the team that calls this function
    public Player(PlayerName name, Position position, Map<String, Integer> attributes, 
    int number, int height, int weight, PlayerStats playerStats){//Add PlayerStats class
        this.name = name;
        this.position = position;
        this.attributes = attributes;
        this.number = number;
        this.height = height;
        this.weight = weight;
        this.playerStats = playerStats;
    }

    public static Player genPlayer(int number){
        rand = new Random();

        PlayerName name = PlayerName.randomPlayerName();
        int height = rand.nextInt(207-150)+150;//Maybe make it a higher chance to be average height
        int weight = rand.nextInt(250-100)+100;//Make weight make sense with height/physicals

        Map<String, Integer> attr = new LinkedHashMap<>();
		    attr.put("Passing", rand.nextInt(9)+1);
        attr.put("Finishing", rand.nextInt(9)+1);
        attr.put("Pace", rand.nextInt(9)+1);

        PlayerStats playerStats = PlayerStats.genPlayerStats(0, 0, 0, 0);
        Player e = new Player(name, Position.randomPos(), attr, number, height, weight, playerStats);
        return e;
    }
    public static Player genPlayerWithPos(int number, Position position){
        rand = new Random();

        PlayerName name = PlayerName.randomPlayerName();
        int height = rand.nextInt(207-150)+150;//Maybe make it a higher chance to be average height
        int weight = rand.nextInt(250-100)+100;//Make weight make sense with height/physicals

        Map<String, Integer> attr = new LinkedHashMap<>();
		    attr.put("Passing", rand.nextInt(9)+1);
        attr.put("Finishing", rand.nextInt(9)+1);
        attr.put("Pace", rand.nextInt(9)+1);

        PlayerStats playerStats = PlayerStats.genPlayerStats(0, 0, 0, 0);
        Player e = new Player(name, position, attr, number, height, weight, playerStats);
        return e;
    }
    
    public Position getPosition(){
        return this.position;
    }

    //This will be the attribute map
    public Map<String,Integer> getPlayerAttributeMap() {
		return this.attributes;
	  }

    public int getNumber(){
		return this.number;
    }
    public PlayerName getPlayerName(){//Change int to String when you wanna come up with a bunch of names
		return this.name;
    }
    public int getPlayerHeight(){
		return this.height;
    }
    public int getPlayerWeight(){
		return this.weight;
    }
    public PlayerStats getPlayerStats(){
      return this.playerStats;
    }
    
}