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
//import org.apache.commons.lang.ArrayUtils;
//import javafx.util.ArrayList; 

public class Schedule{
    private int[][] schedule;
    private int leagueSize;
    private static Random rand;
    
    public Schedule(int leagueSize, int[][] schedule){
        this.schedule = schedule;
        this.leagueSize = leagueSize;
    }

    public static Schedule genSchedule(int leagueSize){
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
System.out.println(copy.length);
        boolean broken = false;
        copy = half.clone();

        int[][] week = new int[leagueSize/2][2];
        int[][][] total = new int[(leagueSize/2)*(leagueSize-1)][leagueSize/2][2];
        int totalIndex = 0;
        int nine = 0;
        rand = new Random();
        while(nine<9){//Maybe this could do it until its done for the first half

            int c = 0;
            week = new int[leagueSize/2][2];

            int p = rand.nextInt(copy.length);

            int[] teams = new int[leagueSize];//make an array of the teams to check they play once per week
            for(int i=0; i<leagueSize; i++){
                teams[i] = i;

            }
        int count = 0;

            while(c<(leagueSize/2)){//Makes schedule for one week
                int[][] copy2 = new int[(leagueSize/2)*(leagueSize-1)][2];
                copy2=copy.clone();
                

                if(copy.length==0){
                    break;
                }

                if(contains(teams,copy[p][0]) && contains(teams,copy[p][1])){

                    count = 0;

                    week[c][0]=copy[p][0];
                    week[c][1]=copy[p][1];
                    
                    teams = removeS(teams, week[c][0]);
                    teams = removeS(teams, week[c][1]);

                    System.out.println("Added to week P = " + p);
                    System.out.println("[" + week[c][0] + ", " + week[c][1] + "]");

                    copy=remove(copy, p);

                    c++;
                }
                p = rand.nextInt(copy.length);
                count ++;
                if(count>200){
                    broken = true;
                    System.out.println("Broked");
                    break;
                }
                copy = new int[(leagueSize/2)*(leagueSize-1)][2];
                copy=copy2.clone();
                //System.out.println("Pinnie = "+ p);
            }
            if(total.length==8 && broken){//Retry until it works sorry
                broken = false;
                copy = new int[(leagueSize/2)*(leagueSize-1)][2];
                copy = half.clone();
                //System.out.println("Copy length = " + copy.length);
                //copy=rando(copy);
                week = new int[leagueSize/2][2];
                total = new int[(leagueSize/2)*(leagueSize-1)][leagueSize/2][2];
                totalIndex = 0;
                nine = 0;
            }
            for(int i = 0; i<week.length; i++){
                //System.out.println("[" + week[i][0] + ", " + week[i][1] + "]");
            }
            System.out.println("AIGHT");
            total[totalIndex] = week;
            totalIndex++;
            System.out.println(copy.length);
            if (!broken){
                nine++;
            }
        }

        Schedule e = new Schedule(leagueSize, week);
        return e;
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
}