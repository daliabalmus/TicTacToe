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

    public  void computerTurn() {
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
        int row;
        int column;
        do {
            String[] position = scanner.nextLine().split(", ");

            row = Integer.parseInt(position[0]) -1;
            column = Integer.parseInt(position[1]) -1;

            if (!boardArray[row][column].equals("@")) {
                System.out.println("\nPozitia a fost deja ocupata! Introduceti o noua pozitie:");
            }
        } while (!boardArray[row][column].equals("@"));

        boardArray[row][column] = "X";
        printBoard();
    }

    public boolean checkWin(String ch) {
        return checkRow(ch) || checkColumn(ch) || checkDiagonalOne(ch) || checkDiagonalTwo(ch);
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

        for (int i = 0; i < boardArray.length; i++) {

            if (boardArray[i][0].contains(ch) && boardArray[i][1].contains(ch) && boardArray[i][2].contains(ch)) {
                isWinner = true;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkColumn(String ch) {
        boolean isWinner = false;
        for (int i = 0; i < boardArray.length; i++) {
            if (boardArray[0][i].contains(ch) && boardArray[1][i].contains(ch) && boardArray[2][i].contains(ch)) {
                isWinner = true;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkDiagonalOne(String ch) {
        boolean isWinner = false;
        int total = 0;
        for (int i = 0; i < boardArray.length; i++) {
            if (boardArray[i][i].contains(ch)) {
                total++;
                if (total == 3) {
                    isWinner = true;
                    break;
                }
            }
        }
        return isWinner;
    }

    private boolean checkDiagonalTwo(String ch) {
        boolean isWinner = false;
        int n = 3;
        int total = 0;
        for (int i = 0; i < boardArray.length; i++) {
            if (boardArray[i][n-i-1].contains(ch)) {
                total++;
                if (total == 3) {
                    isWinner = true;
                    break;
                }
            }
        }
        return isWinner;
    }
}