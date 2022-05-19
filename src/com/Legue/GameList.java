package com.Legue;

import java.util.ArrayList;

public class GameList<T extends Game> {
    private String list;
    private ArrayList<T> games = new ArrayList<>();

    public GameList() {
        this.list = "Box Scores";
    }

    public void addGame(T game) {
        games.add(game);
    }

    public void printList() {
        for (int i = 0; i < this.games.size();i++) {
            System.out.println(this.games.get(i).getResults());
        }
    }
}
