package com.Legue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<Game> games = new ArrayList<>();

    private ArrayList<T> members = new ArrayList<>();
    static final Comparator<Player> alphebeticalOrder = new Comparator<Player>() {
        @Override
        public int compare(Player player1, Player player2) {
            int lexidecimal = player1.getName().compareTo(player2.getName());
            return lexidecimal;
        }
    };

    //get the list of games in a given team***
    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    public Team(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Game getGame(int i) {
        return games.get(i);
    }

   public String getPlayerName(int i) {
        return members.get(i).getName();
   }



    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + ", is already on the team ");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + ", was added to the team");
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

        //returns the match results and saves the gane in arraylist of whoever the home team is
    public static void matchResults(Team ourTeam,int ourScore, Team opponent, int theirScore) {


        String message;

        if(ourScore > theirScore) {
            ourTeam.won++;
            opponent.lost++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            ourTeam.tied++;
            opponent.tied++;
            message = " drew with ";

        } else {
            ourTeam.lost++;
            opponent.won++;
            message = " lost to ";
        }
        ourTeam.played++;



        ourTeam.games.add(new Game(ourTeam,ourScore, opponent, theirScore));
        opponent.games.add(new Game(opponent, theirScore, ourTeam, ourScore));

        //System.out.println(ourTeam.getName() + message + opponent.getName());

    }

    public void printGameList() {
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i).getResults());
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    public void alphabeticallySortedPlayers() {
        Collections.sort(this.members, alphebeticalOrder);
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }



}
