package com.Legue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//this class saves all the stuff to a txt
public class StandingsSaver {

    //puts the legue standings on a txt file
    public static void standings(League league) {
        File file = new File("Standings.txt"); //<-- name of doc here
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,false);
        }catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);

        pw.write(league.leagueStandings());

        pw.write("\n ************************ \n");



        pw.close();
    }

    //puts the
    public static void saveGamesToFile(League league) {
        File file = new File("Standings.txt"); //<-- name of doc here
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
        }catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);

        pw.write(league.getGamesString());

        pw.write("\n ************************ \n");

        pw.close();
    }

    public static void savePlayersToFile(League league) {
        File file = new File("Standings.txt"); //<-- name of doc here
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
        }catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);

        pw.write(league.playesList(league));

        pw.write("\n ************************ \n");


        pw.close();
    }
}
