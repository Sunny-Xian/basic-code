package com.itheima.skiploop;

import java.util.Scanner;

public class FiveChess {
    private static final int BOARD_SIZE = 15;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int EMPTY = 0;
    private static int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
    private static boolean gameOver = false;

    private static void initChessBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessBoard[i][j] = EMPTY;
            }
        }
    }

    private static void printChessBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isWin(int player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (chessBoard[i][j] == player) {
                    if (checkHorizontal(i, j, player) || checkVertical(i, j, player)
                            || checkLeftDiagonal(i, j, player) || checkRightDiagonal(i, j, player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkHorizontal(int x, int y, int player) {
        int count = 0;
        for (int i = y; i < BOARD_SIZE && chessBoard[x][i] == player; i++) {
            count++;
        }
        for (int i = y - 1; i >= 0 && chessBoard[x][i] == player; i--) {
            count++;
        }
        return count == 5;
    }

    private static boolean checkVertical(int x, int y, int player) {
        int count = 0;
        for (int i = x; i < BOARD_SIZE && chessBoard[i][y] == player; i++) {
            count++;
        }
        for (int i = x - 1; i >= 0 && chessBoard[i][y] == player; i--) {
            count++;
        }
        return count == 5;
    }

    private static boolean checkLeftDiagonal(int x, int y, int player) {
        int count = 0;
        for (int i = x, j = y; i < BOARD_SIZE && j >= 0 && chessBoard[i][j] == player; i++, j--) {
            count++;
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < BOARD_SIZE && chessBoard[i][j] == player; i--, j++) {
            count++;
        }
        return count == 5;
    }

    private static boolean checkRightDiagonal(int x, int y, int player) {
        int count = 0;
        for (int i = x, j = y; i >= 0 && j >= 0 && chessBoard[i][j] == player; i--, j--) {
            count++;
        }
        for (int i = x + 1, j = y + 1; i < BOARD_SIZE && j < BOARD_SIZE && chessBoard[i][j] == player; i++, j++) {
            count++;
        }
        return count == 5;
    }

    private static int computerPlay() {
        int x, y;
        do {
            x = (int) (Math.random() * BOARD_SIZE);
            y = (int) (Math.random() * BOARD_SIZE);
        } while (chessBoard[x][y] != EMPTY);
        chessBoard[x][y] = WHITE;
        System.out.println("电脑下了一步：" + x + "," + y);
        return WHITE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initChessBoard();

        int player = BLACK;
        int x, y;
        while (!gameOver) {
            if (player == BLACK) {
                System.out.print("请下棋：");
                x = sc.nextInt();
                y = sc.nextInt();
                while (chessBoard[x][y] != EMPTY) {
                    System.out.println("该位置已有棋子，请重新输入：");
                    x = sc.nextInt();
                    y = sc.nextInt();
                }
                chessBoard[x][y] = BLACK;
                player = WHITE;
            } else {
                player = computerPlay();
            }

            printChessBoard();

            if (isWin(BLACK)) {
                System.out.println("黑棋获胜！");
                gameOver = true;
            } else if (isWin(WHITE)) {
                System.out.println("白棋获胜！");
                gameOver = true;
            }
        }
        sc.close();
    }
}
