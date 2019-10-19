package Fm;

import java.util.Random;

public enum TeamName{
    //enumerations declared here
    Liverpool, 
    Wolves, Arsenal, Chelsea,
    ManCity, ManUnited, Bevens,
    Stevens;
    private static Random rand = new Random();
    public static TeamName randomTeamName(){
        int randomInt = rand.nextInt(8);
        switch(randomInt){
            case 0:
                return TeamName.Liverpool;
            case 1:
                return TeamName.Wolves;
            case 2:
                return TeamName.Arsenal;
            case 3:
                return TeamName.Chelsea;
            case 4:
                return TeamName.ManCity;
            case 5:
                return TeamName.ManUnited;
            case 6:
                return TeamName.Bevens;
            default:
                return TeamName.Stevens;
        }
    }

} 