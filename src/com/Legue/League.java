package com.Legue;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team>{
    public String name;
    public ArrayList<T> league = new ArrayList<T>();
    private ArrayList<Game> games = new ArrayList<>();


    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Team getTeam(int team) {
        if (league != null) {
            return league.get(team);
        }else {
            System.out.println("League is empty");
            return null;
        }
    }

    public boolean addTeam(T team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + ", is already in the "+ name);
            return false;
        }else {
            league.add(team);
            System.out.println(team.getName() + ", was added to the " + this.name);
            return true;
        }
    }

    //Sets up a table for the legue standings
    public String leagueStandings() {
        Collections.sort(league);

        String standings ="\n\n\t\t Wins Losses Ties\n";
        for (int i = 0; i < this.league.size(); i++) {
            standings+=(this.league.get(i).getName() + ": " +
                    this.league.get(i).won + "\t" + this.league.get(i).lost +
                    "\t" + this.league.get(i).tied + "\n");
        }
        return standings;

    }

    //save the games to the legue of a given team
    public void saveGames(Team team) {
        for (int i = 0; i< team.getGames().size();i++) {
            this.games.add(team.getGame(i));
        }
    }

    //save the games of a given legue
    public void saveGames(League league) { //broken

        for (int i = 0; i < league.league.size(); i++) {
            for(int j = 0; j < league.getTeam(i).getGames().size();j++) {
                //games.add(league.getTeam(i).getGame(j));
                league.saveGames(league.getTeam(j));
                System.out.println(league.getTeam(i).getGame(j) + " Saved to games arraylist");
            }
        }
    }

    //returns the games in string form
    public String getGamesString() {
        String initialized = "";
        for (int i = 0; i<this.games.size();i++) {
            initialized+= this.games.get(i).getResults() + "\n";
        }
        return initialized;
    }

    //get the players of a team in string format
    public String getPlayersString(Team team) {
        String textPlayers = team.getName() + "\n";
        for (int i = 0; i < team.numPlayers();i++) {
            textPlayers += team.getPlayerName(i);
            textPlayers += "\n";
        }
        return textPlayers;
    }

    //get players of league in string format
    public String playesList(League league1) {//broken
        String players = "";

        for (int i = 0; i < league1.league.size(); i++) {
            players+= league1.getTeam(i).getName();
            players += "\n";
            league1.getTeam(i).alphabeticallySortedPlayers();
            for (int j = 0; j<league1.getTeam(i).numPlayers(); j++) {
                players += league1.getPlayersString(league1.getTeam(j));
                players +="\n";
            }
        }return players;
    }
}
