package com.algorithms;

public class ClockwiseSpiral {

    enum Move {
        right,
        left,
        down,
        up,
        stop
    }

    int[][] docloskwise(int n) {

        int number = 1;

        int[][] elements = new int[n][n];

        int posX = 0;
        int posY = 0;

        Move direction = Move.down;

        elements[0][0] = number;
        number++;

        int height = n - 1;
        int width = n - 1;

        while (direction != Move.stop) {
            //direction = chooseDirection(posX, posY, direction, elements, width, height, number);
            int counter = 0;

            boolean chosen = false;

            while (!chosen) {

                if (counter > 3 || direction == Move.stop) {
                    direction = Move.stop;
                    chosen = true;
                    break;
                }

                switch (direction) {
                    case right:
                        if (posX + 1 <= width) {
                            if (elements[posX + 1][posY] == 0) {
                                posX += 1;
                                chosen = true;
                                break;
                            } else {
                                direction = Move.down;
                                counter++;
                            }
                        } else {
                            direction = Move.down;
                            counter++;
                        }
                    case down:
                        if (posY + 1 <= height) {
                            if (elements[posX][posY + 1] == 0) {
                                posY += 1;
                                chosen = true;
                                break;
                            } else {
                                direction = Move.left;
                                counter++;
                            }
                        } else {
                            direction = Move.left;
                            counter++;
                        }
                    case left:
                        if (posX - 1 >= 0) {
                            if (elements[posX - 1][posY] == 0) {
                                posX -= 1;
                                chosen = true;
                                break;
                            } else {
                                direction = Move.up;
                                counter++;
                            }
                        } else {
                            direction = Move.up;
                            counter++;
                        }
                    case up:
                        if (posY - 1 >= 0) {
                            if (elements[posX][posY - 1] == 0) {
                                posY -= 1;
                                chosen = true;
                                break;
                            } else {
                                direction = Move.right;
                                counter++;
                            }
                        } else {
                            direction = Move.right;
                            counter++;
                        }
                        break;
                    case stop:
                        System.out.println("Cyclic movement detected. Stop program");
                        chosen = true;
                        break;
                }

            }
            elements[posX][posY] = number;
            if (number < n * n) {
                number++;
            }

        }

        return elements;
    }

    public static int[][] createSpiral(int N) {
        int[][] result = new int[N][N];
        int counter = 1;
        int total = N * N;
        int rowLimit = N;
        int columnLimit = N;
        int row = 0, column = 0;
        while (counter <= total) {
            for (int i = column; i < columnLimit; i++) {
                result[row][i] = counter++;
            }
            for (int i = row + 1; i < rowLimit; i++) {
                result[i][columnLimit - 1] = counter++;
            }
            for (int i = columnLimit - 2; i >= column; i--) {
                result[rowLimit - 1][i] = counter++;
            }
            for (int i = rowLimit - 2; i > row; i--) {
                result[i][column] = counter++;
            }
            row++;
            column++;
            rowLimit--;
            columnLimit--;
        }
        return result;
    }

    public static int[][] createSpiral1(int N) {
        int[][] s = new int[N][N];
        for (int turn = 0, n = N, now = 1; n > 0; turn++, n -= 2) {
            if (turn == N - 1 - turn) {
                s[turn][turn] = now;
                break;
            }
            int i, j;
            i = j = turn;
            for (; j < N - 1 - turn; j++) s[i][j] = now++;
            for (; i < N - 1 - turn; i++) s[i][j] = now++;
            for (; j > turn; j--) s[i][j] = now++;
            for (; i > turn; i--) s[i][j] = now++;
        }
        return s;
    }

    static void showResult(int[][] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                System.out.printf("%4s", elements[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ClockwiseSpiral clock = new ClockwiseSpiral();
        int[][] result = clock.docloskwise(8);
        showResult(result);

        result = ClockwiseSpiral.createSpiral(9);
        showResult(result);

        result = ClockwiseSpiral.createSpiral1(13);
        showResult(result);
    }

}
