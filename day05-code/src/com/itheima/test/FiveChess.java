package com.itheima.test;

import java.util.Scanner;

public class FiveChess {
    public static final int ROWS = 15;
    public static final int COLUMNS = 15;
    public static final int BLACK = 1;
    public static final int WHITE = -1;
    public static final int EMPTY = 0;
    public static int[][] chessBoard = new int[ROWS][COLUMNS];

    public static void initChessBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                chessBoard[i][j] = EMPTY;
            }
        }
    }

    public static void displayBoard() {
        System.out.println("\nChess Board:");
        System.out.print("   ");
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < COLUMNS; j++) {
                if (chessBoard[i][j] == BLACK) {
                    System.out.print("B ");
                } else if (chessBoard[i][j] == WHITE) {
                    System.out.print("W ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void placePiece(int x, int y, int player) {
        chessBoard[x][y] = player;
    }

    public static boolean isWin(int player) {
        return checkHorizontal(player) || checkVertical(player) || checkLeftDiagonal(player) || checkRightDiagonal(player);
    }

    // 检查水平方向是否有连续的五颗棋子
    public static boolean checkHorizontal(int player) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLUMNS - 5; j++) {
                boolean flag = true;
                for (int k = j; k < j + 5; k++) {
                    if (chessBoard[i][k] != player) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    // 检查垂直方向是否有连续的五颗棋子
    public static boolean checkVertical(int player) {
        for (int i = 0; i <= ROWS - 5; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                boolean flag = true;
                for (int k = i; k < i + 5; k++) {
                    if (chessBoard[k][j] != player) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    // 检查左对角线方向是否有连续的五颗棋子
    public static boolean checkLeftDiagonal(int player) {
        for (int i = 4; i < ROWS; i++) {
            for (int j = 0; j <= COLUMNS - 5; j++) {
                boolean flag = true;
                for (int k = 0; k < 5; k++) {
                    if (chessBoard[i - k][j + k] != player) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    // 检查右对角线方向是否有连续的五颗棋子
    public static boolean checkRightDiagonal(int player) {
        for (int i = 0; i <= ROWS - 5; i++) {
            for (int j = 0; j <= COLUMNS - 5; j++) {
                boolean flag = true;
                for (int k = 0; k < 5; k++) {
                    if (chessBoard[i + k][j + k] != player) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initChessBoard();
        int curPlayer = BLACK;
        while (true) {
            displayBoard();
            System.out.println("Player " + (curPlayer == BLACK ? "Black" : "White") + ": Please enter the coordinates (row column) of your next move: ");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (chessBoard[x][y] != EMPTY) {
                System.out.println("The cell has already been occupied, please try again.");
                continue;
            }
            placePiece(x, y, curPlayer);
            if (isWin(curPlayer)) {
                displayBoard();
                System.out.println("Player " + (curPlayer == BLACK ? "Black" : "White") + " wins!");
                break;
            }
            curPlayer = -curPlayer;
        }
    }
}


