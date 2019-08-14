package com.example.game;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    // de modificat array-ul sa nu fie cu 4 randuri si 4 coloane
    private String[] [] boardArray = {
            {"@", "@", "@"},
            {"@", "@", "@"},
            {"@", "@", "@"},
    };

    private  boolean hasValue;

    // nu am nevoie de
    // ------------------------------------------------------------------------------------------
    private int row;
    private int column;

    // inutil
    public Board(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // -----------------------------------------------------------------------------------------

    public boolean hasBoardMoves() {

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray.length; j++) {
                if (boardArray[i][j].contains("@")) {
                    this.hasValue = true;
                    return hasValue;
                } else {
                    this.hasValue = false;
                }
            }
        }
        return this.hasValue;
    }

    public void computerTurn() {
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

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);

        do {
            String position[] = scanner.nextLine().split(", ");

            // putem folosi local variable in loc de setRow si setColumn

            this.row = Integer.parseInt(position[0]) -1;
            this.column = Integer.parseInt(position[1]) -1;

            // ------------------------------------------------------------------------------------
            if (boardArray[row][column] != "@") {
                System.out.println("\nPozitia a fost deja ocupata! Introduceti o noua pozitie:");
            }
        } while (boardArray[row][column] != "@");

        boardArray[row][column] = "X";
        printBoard();
    }

    public boolean checkWin(String ch) {

        // DE DEFACUT CU METODE PENTRU checkRow(), checkColumn, checkDiag()
        // de facut un if care sa verifice metodele cu OR ||
        // pentru diag 2 de folosit o metoda matematica

        if (  (boardArray[0][0 ] == ch && boardArray[0][1] == ch && boardArray[0][2] == ch) || // row 1
                (boardArray[1][0] == ch && boardArray[1][1] == ch && boardArray[1][2] == ch) || // row 2
                (boardArray[2][0] == ch && boardArray[2][1] == ch && boardArray[2][2] == ch) || // row 3
                (boardArray[0][0] == ch && boardArray[1][0] == ch && boardArray[2][0] == ch) || // col 1
                (boardArray[0][1] == ch && boardArray[1][1] == ch && boardArray[2][1] == ch) || // col 2
                (boardArray[0][2] == ch && boardArray[1][2] == ch && boardArray[2][2] == ch) || // col 3
                (boardArray[0][0] == ch && boardArray[1][1] == ch && boardArray[2][2] == ch) || // diag  1
                (boardArray[0][2] == ch && boardArray[1][1] == ch && boardArray[2][0] == ch)) // diag    2
        {
            return true;
        }
        else { return false; }
    }
    public void printBoard() {
        for (String[] item : boardArray) {
            System.out.println(Arrays.deepToString(item)
                    .replace('[', ' ')
                    .replace(',', ' ')
                    .replace(']', ' ').trim()
            );
        }
    }
    //  public boolean checkRow(String ch) {
//        for (int i = 0; i < boardArray.length; i++) {
//
//
//
//            for (int j = 0; j < boardArray.length; j++) {
//                if (boardArray[i][j].contains("@")) {
//
//                    return hasValue;
//                } else {
//
//                }
//            }
//        }

//        for (int i = 0; i < boardArray.length; i++) {
//            if (!boardArray[column][i].equals(ch)) {
//
//            }
//        }
//        int a = boardArray[0].length;
//        for (int i = 0; i < boardArray.length; i++) {
//            if (boardArray[i].equals(ch)) {
//                return true;
//            }
//        }
//        return false;
//    }
}