package com.example.game;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private String[] [] boardArray = {
            {"", "", "", ""},
            {"", "@", "@", "@"},
            {"", "@", "@", "@"},
            {"", "@", "@", "@"}
    };

    private  boolean hasValue;
    private int row;
    private int column;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getBoardArray() {
        return boardArray;
    }

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
            int randomRow = (int) ((Math.random() * 3) + 1);
            int randomColumn = (int) ((Math.random() * 3) + 1);

            String computerChoice = boardArray[randomRow][randomColumn];
            if ((computerChoice.contains("@"))) {
                System.out.println("---------------------------------------------------");
                System.out.println("Computerul a ales " + randomRow + ", " + randomColumn);
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
            setRow(Integer.parseInt(position[0]));
            setColumn(Integer.parseInt(position[1]));
            if (boardArray[row][column] != "@") {
                System.out.println("\nPozitia a fost deja ocupata! Introduceti o noua pozitie:");
            }
        } while (boardArray[row][column] != "@");

        boardArray[row][column] = "X";
        printBoard();
    }

    public boolean checkWin(String ch) {
        if (  (boardArray[1][1] == ch && boardArray[1][2] == ch && boardArray[1][3] == ch) || // row 1
                (boardArray[2][1] == ch && boardArray[2][2] == ch && boardArray[2][3] == ch) || // row 2
                (boardArray[3][1] == ch && boardArray[3][2] == ch && boardArray[3][3] == ch) || // row 3
                (boardArray[1][1] == ch && boardArray[2][1] == ch && boardArray[3][1] == ch) || // col 1
                (boardArray[1][2] == ch && boardArray[2][2] == ch && boardArray[3][2] == ch) || // col 2
                (boardArray[1][3] == ch && boardArray[2][3] == ch && boardArray[3][3] == ch) || // col 3
                (boardArray[1][1] == ch && boardArray[2][2] == ch && boardArray[3][3] == ch) || // diag  1
                (boardArray[1][3] == ch && boardArray[2][2] == ch && boardArray[3][1] == ch)) // diag    2
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
}