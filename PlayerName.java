package Fm;

import java.util.Random;

public enum PlayerName{
    //enumerations declared here
    Alex, 
    Hanlin, Bernard, Vincent,
    Joaquin, Theo, Blake,
    Jordan;
    private static Random rand = new Random();
    public static PlayerName randomPlayerName(){
        int randomInt = rand.nextInt(8);
        switch(randomInt){
            case 0:
                return PlayerName.Alex;
            case 1:
                return PlayerName.Hanlin;
            case 2:
                return PlayerName.Bernard;
            case 3:
                return PlayerName.Vincent;
            case 4:
                return PlayerName.Joaquin;
            case 5:
                return PlayerName.Theo;
            case 6:
                return PlayerName.Blake;
            default:
                return PlayerName.Jordan;
        }
    }

} 