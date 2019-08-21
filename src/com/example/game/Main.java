package com.example.game;

public class Main {

    private static Board board = new Board();

    public static void main(String[] args) {

        System.out.println("Bine ai venit la X-0; Introdu prima pozitie");
        boolean isPlayerTurn = true;
        while(board.hasBoardMoves()) {
            String printMessage = printWinner();
            if (printMessage == null) {
                if (isPlayerTurn) {
                    board.playerTurn();
                    isPlayerTurn = false;
                } else {
                    board.computerTurn();
                    System.out.println("------------------------------------------------");
                    System.out.println("Introdu o noua pozitie");
                    isPlayerTurn = true;
                }
                continue;
            } else {
                System.out.println("------------------------------------------------");
                System.out.println(printMessage);
            }
            break;
        };

        if (!board.hasBoardMoves() && (!board.checkWin("X") || !board.checkWin("0"))) {
            System.out.println("------------------------------------------------");
            System.out.println("Remiza. Jocul s-a incheiat!");
        }
    }

    private static String printWinner() {
        if (board.checkWin("X")) {
            return "Ai castigat. Jocul s-a incheiat!";
        } else if (board.checkWin("0")){
            return "Ai pierdut. Jocul s-a incheiat!";
        } else {
            return null;
        }
    }
}