 package Fm;
//Generates league table

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Arrays; 

public class LeagueTable{

    public LeagueTable(){

    }

    public static LeagueTable genLeagueTable(Team[] teams){//Size is how many teams in league
        int size = teams.length;
        //System.out.println("Size: " + size);
        //Team[] ordered = new Team[size];
        //System.out.println(teams[0].getTeamName());
        sort(teams, 0, size-1);
        //System.out.println("Size: " + teams.length);
        //System.out.println(teams[0].getTeamName());
        printLeagueTable(teams);


        LeagueTable e = new LeagueTable();
        return e;
    }

    public static void printLeagueTable(Team[] teams){
        int size = teams.length;
        System.out.println("Place..Name...GoalsFor...Agst...Diff..Points");
        for(int i = size-1; i>=0; i--){
            System.out.println(size-i + " | " + teams[i].getTeamName()
                + " | " + teams[i].getTeamStats().getTeamGoalsFor() + " | " + teams[i].getTeamStats().getTeamGoalsAgainst() + " | "
                + teams[i].getTeamStats().getTeamGoalDiff() + " | " + teams[i].getTeamStats().getTeamPoints());
        }
    }
    public static int partition(Team[] arr, int low, int high) 
    { 
        Team pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j].getTeamStats().getTeamPoints() < pivot.getTeamStats().getTeamPoints() || 
            (arr[j].getTeamStats().getTeamPoints() == pivot.getTeamStats().getTeamPoints() && 
            arr[j].getTeamStats().getTeamGoalDiff() < pivot.getTeamStats().getTeamGoalDiff())) //Checks if points are same then goes by goal diff
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Team temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Team temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public static void sort(Team[] arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
}