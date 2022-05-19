package com.Legue;

public class Game {
    private Team team1;
    private Team team2;
    int team1Score;
    int team2Score;


    public Game(Team team1, int team1Score, Team team2, int team2Score) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;

    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    //gets the resualts for each game and puts it into a string
    public String getResults() {
        String results = "";
        String team1 = getTeam1().getName();
        String team2 = getTeam2().getName();

        if(team1Score > team2Score) {
            results += getTeam1().getName() + " defeated " +
            getTeam2().getName() + " with a final score of " + getTeam1Score() +
            " to " + getTeam2Score();
        }

        if(team1Score < team2Score) {
            results += getTeam2().getName() + " defeated " +
                    getTeam1().getName() + " with a final score of " + getTeam2Score() +
                    " to " + getTeam1Score();
        }

        if (team1Score == team2Score) {
            results += getTeam1().getName() + " tied " +
                    getTeam2().getName() + " with a final score of " + getTeam1Score() +
                    " to " + getTeam2Score();
        }

        return results;
    }

}
