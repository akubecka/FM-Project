package Fm;

/*
    This class should generate a number that reflects the players overall ability at that time
    Should be very dynamic, changing about every game they play
    Takes into account all attributes, stats, player form, team form


    Maybe put the probability of them doing something in a minute here? Prolly no cause that depends on opponents and teammates
    Valuation of the player should use this
*/
import java.util.Map;
import java.util.LinkedHashMap;
public class PlayerOverall{
    //private Player player;

    public PlayerOverall(/*Player player*/){
        //this.player = player;
    }

    public static int genOverall(Player player){
        int overall = 0;
        Map<String,Integer> attributes = new LinkedHashMap<>();
        attributes = player.getPlayerAttributeMap();

        int passing = attributes.get("Passing");
        int finishing = attributes.get("Finishing");
        int pace = attributes.get("Pace");
        
        overall = passing+finishing+pace;
        return overall;
    }

}