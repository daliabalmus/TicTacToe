package com.example.game;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isPlayerTurn = true;

        System.out.println("Bine ai venit la X-0; Introdu prima pozitie");


        Board board = new Board(0, 0);

        while(board.hasBoardMoves()) {
            if (board.checkWin("X")) {
                System.out.println("------------------------------------------------");
                System.out.println("Ai castigat. Jocul s-a incheiat!");
                isPlayerTurn = false;
                break;
            } else if (board.checkWin("0")) {
                System.out.println("------------------------------------------------");
                System.out.println("Ai pierdut. Jocul s-a incheiat!");
                isPlayerTurn = false;
                break;
            }
            else {
                if (isPlayerTurn) {

                    board.playerTurn();
                    isPlayerTurn = false;
                } else {
                    board.computerTurn();
                    System.out.println("------------------------------------------------");
                    System.out.println("Introdu o noua pozitie");
                    isPlayerTurn = true;
                }
            }
        };

        if (!board.hasBoardMoves()) {
            System.out.println("------------------------------------------------");
            System.out.println("Remiza. Jocul s-a incheiat!");
        }
    }
}