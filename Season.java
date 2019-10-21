package Fm;
//Season should run the season for all leagues


public class Season{
    private Team[][][] schedule;

    public Season(Team[][][] schedule){//Maybe toss in special rules and stuff in here instead of just team array, REFS
        this.schedule = schedule;
    }

    public static Season genSeason(Team[][][] schedule){//Size is how many teams in league
        Team[] weeks = new Team[schedule.length];
        String res;
        int result;
        for(int year = 0; year<schedule.length; year++){//For each week in season
            System.out.println("Week "+ year + " results:");
            for(int week = 0; week<schedule[year].length-1; week++){
                weeks = schedule[year][week];

                Game game = Game.genGame(schedule[year][week][0], schedule[year][week][1]);//Run the game

                result = game.getResult();
                if(result==0){
                    res = schedule[year][week][0].getTeamName() + " won the game.";
                }else if(result==1){
                    res = "Draw";
                }else{
                    res = schedule[year][week][1].getTeamName() + " won the game.";
                }
                System.out.println(res);
            }
        }
        
        Season e = new Season(schedule);
        return e;
    }
}
