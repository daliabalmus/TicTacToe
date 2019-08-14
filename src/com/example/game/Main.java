package com.example.game;

public class Main {

    public static void main(String[] args) {
        boolean isPlayerTurn = true;

        System.out.println("Bine ai venit la X-0; Introdu prima pozitie");


        Board board = new Board(0, 0);

        while(board.hasBoardMoves()) {
            if (board.checkWin("X")) {
                // MAI DINAMIC
                // cele 2 sunt foarte asemanatoare si pot face o metoda care sa aiba parametrii pentru x=>System.out.println("Ai castigat. Jocul s-a incheiat!");
                //                                                                                                                                y => System.out.println("Ai pierdut. Jocul s-a incheiat!");
                // ca si parametrul ch pentru checkWin()
                System.out.println("------------------------------------------------");
                System.out.println("Ai castigat. Jocul s-a incheiat!");
                isPlayerTurn = false;
                break;
            } else if (board.checkWin("0")) {
                System.out.println("------------------------------------------------");
                System.out.println("Ai pierdut. Jocul s-a incheiat!");
                isPlayerTurn = false;
                break;
//                ------------------------------------------------------------------------------------------------------------------------------------------------------
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