package Fm;
/*
    Schedule creates the original schedule and fixes later scheduling issues
    Make sure each team plays eachother once the first half, once the second half.
    Keep all the games on the same day and time for now
    Make sure one is at home, one is away
    Weeks = Number of teams in league-1 * 2 (One game for a team each weekend)
    Add other leagues other than just two halves
*/
import java.util.Random;
import java.util.*; 
import java.util.Map;
import java.util.LinkedHashMap;
//import org.apache.commons.lang.ArrayUtils;
//import javafx.util.ArrayList; 

public class Schedule{
    private Team[][][] schedule;
    private static Random rand;
    private int leagueSize;
    
    public Schedule(Team[][][] schedule, int leagueSize){
        this.schedule = schedule;
        this.leagueSize = leagueSize;
    }

    public static Schedule genSchedule(League league){
        //League league = new League.genLeague("BPL", 20)
        Team[] teamArray;
        teamArray = league.getTeams();
        int leagueSize;
        leagueSize = teamArray.length;
        int[][] firstHalf = new int[(leagueSize/2)*(leagueSize-1)][2];
        int[][] half = new int[(leagueSize/2)*(leagueSize-1)][2];
        int index = 0;
        for(int i = 0; i<leagueSize-1; i++){
            for(int j = i; j<leagueSize; j++){
                if(i!=j){//Make sure they don't play themselves
                    firstHalf[i][0] = i;     
                    firstHalf[i][1] = j;
                    half[index][0] = firstHalf[i][0];
                    half[index][1] = firstHalf[i][1];
                    index++;
                }//All the combinations of games for the first half of the season
            }
        }
        int[][] copy = new int[(leagueSize/2)*(leagueSize-1)][2];
        boolean broken = false;
        copy = half.clone();

        int[][] week = new int[leagueSize/2][2];
        int[][][] total = new int[leagueSize-1][leagueSize/2][2];
        int totalIndex = 0;
        int nine = 0;
        rand = new Random();
        while(nine<leagueSize-1){//Maybe this could do it until its done for the first half
            int[][] copy2 = new int[(leagueSize/2)*(leagueSize-1)][2];
            copy2=copy.clone(); //Clones copy before it goes in and removes for the week
            int c = 0;
            week = new int[leagueSize/2][2];

            int p = rand.nextInt(copy.length);

            int[] teams = new int[leagueSize];//make an array of the teams to check they play once per week
            for(int i=0; i<leagueSize; i++){
                teams[i] = i;
            }
            int count = 0;
            while(c<(leagueSize/2)){//Makes schedule for one week
                //System.out.println("HUH");
                if(copy.length==0){
                    break;
                }

                if(contains(teams,copy[p][0]) && contains(teams,copy[p][1])){
                    count = 0;
                    week[c][0]=copy[p][0];
                    week[c][1]=copy[p][1];
                    teams = removeS(teams, week[c][0]);
                    teams = removeS(teams, week[c][1]);
                    //System.out.println("Added to week P = " + p);
                    //System.out.println("[" + week[c][0] + ", " + week[c][1] + "]");
                    copy=remove(copy, p);
                    c++;
                }
                //System.out.println("Copy: "+copy.length);
                if(copy.length!=0){
                    p = rand.nextInt(copy.length);
                }
                
                count ++;
                if(count>200){
                    broken = true;
                    //System.out.println("Broked");
                    copy = new int[(leagueSize/2)*(leagueSize-1)][2];
                    copy=copy2.clone(); //Resets copy to before it started to try to schedule the week
                    break;
                }
                //System.out.println("Pinnie = "+ p);
            }
            if (!broken){
                //System.out.println("Week: " + nine);
                total[nine] = week;
                nine++;
                for (int j = 0; j<week.length; j++){
                    //System.out.println(week[j][0]+ " : " +week[j][1]);
                }
            }
            if(total[leagueSize-2]!=null && broken){//Retry until it works sorry
                broken = false;
                copy = new int[(leagueSize/2)*(leagueSize-1)][2];
                copy = half.clone();//Completely resets copy to the original full array of games
                //System.out.println("Copy length = " + copy.length);
                //copy=rando(copy);
                week = new int[leagueSize/2][2];
                total = new int[leagueSize-1][leagueSize/2][2];
                //totalIndex = 0;
                nine = 0;
            }

            //System.out.println("Total: " + total.length);
            //System.out.println("Total: " + week.length);
            
        }
        for(int i=0; i<total.length; i++){
            //System.out.println("Week " + i);
            for (int j = 0; j<total[i].length; j++){
                for(int k = 0; k<total[i][j].length; k++){
                    //System.out.println(total[i][j][k]);
                }
            }
        }
        Team[][][] converted = new Team[total.length][total[0].length][2];
        converted = convert(total, teamArray);//fix
        //Schedule e = new Schedule(converted);
        /*for(int i=0; i<converted.length; i++){
            System.out.println("Week " + i);
            for (int j = 0; j<converted[i].length; j++){
                for(int k = 0; k<converted[i][j].length; k++){
                    System.out.println(converted[i][j][k].getTeamName());
                }
            }
        }
        */
        Schedule e = new Schedule(converted, leagueSize);
        return e;
    }

    //This will convert the schedule of numbers to Teams
    public static Team[][][] convert(int[][][] sked, Team[] teams){
        Team[][][] convertee = new Team[sked.length][sked[0].length][2];
        for(int i=0; i<sked.length; i++){
            for (int j = 0; j<sked[i].length; j++){
                for(int k = 0; k<sked[i][j].length; k++){
                    convertee[i][j][k] = teams[sked[i][j][k]];
                }
            }
        }
        return convertee;
    } 

    public static int[][] remove(int[][] arr, int index) 
    { 
        // If the array is empty 
        // or the index is not in array range 
        // return the original array 
        if (arr == null || index < 0) { 
            return arr; 
        } 
        // Create another array of size one less 
        int[][] anotherArray = new int[arr.length - 1][2]; 
  
        // Copy the elements except the index 
        // from original array to the other array 
        for (int i = 0, k = 0; i < arr.length; i++) { 
  
            // if the index is 
            // the removal element index 
            if (i == index) { 
                continue; 
            } 
  
            // if the index is not 
            // the removal element index 
            anotherArray[k++] = arr[i]; 
        }  
  
        // return the resultant array 
        return anotherArray; 
    } 
    public static int[] removeS(int[] arr, int index) 
    { 
        // If the array is empty 
        // or the index is not in array range 
        // return the original array 
        if (arr == null || index < 0) { 
            return arr; 
        } 
        // Create another array of size one less 
        int[] anotherArray = new int[arr.length - 1]; 
  
        // Copy the elements except the index 
        // from original array to the other array 
         for (int i = 0, j=0; i<arr.length; i++) { 
            if (arr[i] == index) { 
                continue; 
            }else{
                anotherArray[j++]=arr[i];
            } 
        } 
  
        // return the resultant array 
        return anotherArray; 
    } 

    private static boolean contains(int[] arr, int toCheckValue) 
    { 
        // check if the specified element 
        // is present in the array or not 
        // using Linear Search method 
        boolean test = false; 
        for (int element : arr) { 
            if (element == toCheckValue) { 
                test = true; 
                break;
            } 
        } 
        // Print the result 
        return test;
    } 

    public static int[][] rando(int[][] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
            int[] temp = new int[array.length];
            temp = array[i];
		    array[i] = array[randomPosition];
            array[randomPosition] = temp;
		}
 
		return array;
    }
    
    public Team[][][] getSchedule(){
        return this.schedule;
    }
    
    public int getLeagueSize(){
        return this.leagueSize;
    }
    
}