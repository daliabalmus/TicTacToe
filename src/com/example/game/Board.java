package com.example.game;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private String[] [] boardArray = {
            {"@", "@", "@"},
            {"@", "@", "@"},
            {"@", "@", "@"},
    };

    private  boolean hasValue;

    public Board() {
        this.boardArray = boardArray;
    }

    boolean hasBoardMoves() {

        for (String[] strings : boardArray) {
            for (int j = 0; j < boardArray.length; j++) {
                if (strings[j].contains("@")) {
                    this.hasValue = true;
                    return hasValue;
                } else {
                    this.hasValue = false;
                }
            }
        }
        return this.hasValue;
    }

    void computerTurn() {
        while (hasBoardMoves()) {
            int randomRow = (int) ((Math.random() * 3));
            int randomColumn = (int) ((Math.random() * 3));

            String computerChoice = boardArray[randomRow][randomColumn];
            if ((computerChoice.contains("@"))) {
                System.out.println("---------------------------------------------------");
                System.out.println("Computerul a ales " + (randomRow +1) + ", " + (randomColumn +1));
                boardArray[randomRow][randomColumn] = "0";
                printBoard();
                break;
            }

        }
    }

    void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        do {
            String[] position = scanner.nextLine().split(", ");

            row = Integer.parseInt(position[0]) -1;
            column = Integer.parseInt(position[1]) -1;

            // ------------------------------------------------------------------------------------
            if (!boardArray[row][column].equals("@")) {
                System.out.println("\nPozitia a fost deja ocupata! Introduceti o noua pozitie:");
            }
        } while (!boardArray[row][column].equals("@"));

        boardArray[row][column] = "X";
        printBoard();
    }

    public boolean checkWin(String ch) {

        // pentru diag 2 de folosit o metoda matematica

//        if (  (boardArray[0][0 ] == ch && boardArray[0][1] == ch && boardArray[0][2] == ch) || // row 1
//                (boardArray[1][0] == ch && boardArray[1][1] == ch && boardArray[1][2] == ch) || // row 2
//                (boardArray[2][0] == ch && boardArray[2][1] == ch && boardArray[2][2] == ch) || // row 3
//                (boardArray[0][0] == ch && boardArray[1][0] == ch && boardArray[2][0] == ch) || // col 1
//                (boardArray[0][1] == ch && boardArray[1][1] == ch && boardArray[2][1] == ch) || // col 2
//                (boardArray[0][2] == ch && boardArray[1][2] == ch && boardArray[2][2] == ch) || // col 3
//                (boardArray[0][0] == ch && boardArray[1][1] == ch && boardArray[2][2] == ch) || // diag  1
//                (boardArray[0][2] == ch && boardArray[1][1] == ch && boardArray[2][0] == ch)) // diag    2
//        {
//            return true;
//        }
//        else { return false; }
        return checkRow(ch) || checkColumn(ch) || checkDiagonalOne(ch);
    }
    private void printBoard() {
        for (String[] item : boardArray) {
            System.out.println(Arrays.deepToString(item)
                    .replace('[', ' ')
                    .replace(',', ' ')
                    .replace(']', ' ').trim()
            );
        }
    }

    private boolean checkRow(String ch) {
        boolean isWinner = false;
        for (int i = 0; i < 3; i++) {
            if (boardArray[i][0].contains(ch) && boardArray[i][1].contains(ch) && boardArray[i][2].contains(ch)) {
                isWinner = true;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkColumn(String ch) {
        boolean isWinner = false;
        int total = 0;
        for (int i = 0; i < 3; i++) {
//            for (int j =0; j < 3; j++) {
//                if (boardArray[j][i].contains(ch)) {
//                    total++;
//                    if (total == 3) {
//                        isWinner = true;
//                        break;
//                    }
//                }
//            }
            if (boardArray[0][i].contains(ch) && boardArray[1][i].contains(ch) && boardArray[2][i].contains(ch)) {
                isWinner = true;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkDiagonalOne(String ch) {
        boolean isWinner = false;
        int n = 0;
        if (boardArray[n][n].contains(ch) && boardArray[n+1][n+1].contains(ch) && boardArray[n+2][n+2].contains(ch)){
            isWinner = true;
        }
        return isWinner;
    }

    private boolean checkDiagonalTwo(String ch) {
        boolean isWinner = false;
        int check = 0;
//  APP CRASH
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray.length; j++) {
                if (boardArray[i][j-i-1].contains(ch)) {
                    check++;
                    if (check == 3) {
                        isWinner = true;
                    }
                }
            }
        }
        return isWinner;

//        for (int i =0; i < boardArray.length; i++) {
//            for (int n = 0; n < boardArray.length; n++) {
//                if (boardArray[i][n-i-1].contains(ch)) {
//                    check++;
//                    if (check == 3) {
//                        isWinner = true;
//                    }
//                }
//            }
//      }
//            System.out.println(boardArray[i][n-i+1]);

//            for (String[] strings : boardArray) {
//                for (int j = 0; j < boardArray.length; j++) {
//                    if (strings[j].contains("@")) {
//                        this.hasValue = true;
//                        return hasValue;
//                    } else {
//                        this.hasValue = false;
//                    }
//                }
//            }
//            return this.hasValue;
//
//        return isWinner;
    }
}