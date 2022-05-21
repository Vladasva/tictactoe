import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);
    static String previousMove;
    public static void main(String[] args) {

        String[][] grid = new String[3][9];
        previousMove = "O";
        int stop = 0;

        createGrid(grid);
        printGrid(grid);

        while (stop == 0) {
            youMove(grid);
            printGrid(grid);
            whoWon(grid);
            stop = whoWon(grid);
        }

        switch (stop){
            case 1:
                System.out.println("X wins");
                break;
            case 2:
                System.out.println("O wins");
                break;
            case 3:
                System.out.println("Draw");
                break;
            case 5:
                System.out.println("Impossible");
                break;
            default:
                System.out.println("Game not finished");
                break;
        }

    }

    public static String[][] createGrid(String[][] grid) {

        grid[0][0] = "|";
        grid[1][0] = "|";
        grid[2][0] = "|";
        grid[0][8] = "|";
        grid[1][8] = "|";
        grid[2][8] = "|";
        grid[0][1] = " ";
        grid[1][1] = " ";
        grid[2][1] = " ";
        grid[0][3] = " ";
        grid[1][3] = " ";
        grid[2][3] = " ";
        grid[0][5] = " ";
        grid[1][5] = " ";
        grid[2][5] = " ";
        grid[0][7] = " ";
        grid[1][7] = " ";
        grid[2][7] = " ";

        return grid;
    }

    public static void printGrid(String[][] grid) {
        System.out.println("---------");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = " ";
                }
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public static int whoWon(String[][] grid) {
        int winner = 0;

        if ((grid[0][2].charAt(0) == 'X' && grid[0][4].charAt(0) == 'X' && grid[0][6].charAt(0) == 'X')
               || (grid[1][2].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X')
               || (grid[2][2].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == 'X')
               || (grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X')
               || (grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
               || (grid[0][2].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
               || (grid[0][6].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][2].charAt(0) == 'X'))
        {
            winner = 1;
       } else if ((grid[0][2].charAt(0) == 'O' && grid[0][4].charAt(0) == 'O' && grid[0][6].charAt(0) == 'O')
               || (grid[1][2].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[1][6].charAt(0) == 'O')
               || (grid[2][2].charAt(0) == 'O' && grid[2][4].charAt(0) == 'O' && grid[2][6].charAt(0) == 'O')
               || (grid[0][2].charAt(0) == 'O' && grid[1][2].charAt(0) == 'O' && grid[2][2].charAt(0) == 'O')
               || (grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == 'O')
               || (grid[0][6].charAt(0) == 'O' && grid[1][6].charAt(0) == 'O' && grid[2][6].charAt(0) == 'O')
               || (grid[0][2].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][6].charAt(0) == 'O')
               || (grid[0][6].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][2].charAt(0) == 'O')) {
            winner = 2;
       } else if ((grid[0][2].charAt(0) == 'X' && grid[0][4].charAt(0) == 'X' && grid[0][6].charAt(0) == 'X'
                && grid[1][2].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[1][6].charAt(0) == 'O')
                || (grid[0][2].charAt(0) == 'O' && grid[0][4].charAt(0) == 'O' && grid[0][6].charAt(0) == 'O'
                && grid[1][2].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X')
                || (grid[1][2].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X'
                && grid[2][2].charAt(0) == 'O' && grid[2][4].charAt(0) == 'O' && grid[2][6].charAt(0) == 'O')
                || (grid[1][2].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[1][6].charAt(0) == 'O'
                && grid[2][2].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
                || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == 'X'
                && grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == 'O')
                || (grid[0][2].charAt(0) == 'O' && grid[1][2].charAt(0) == 'O' && grid[2][2].charAt(0) == 'O'
                && grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X')
                ||(grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X'
                && grid[0][6].charAt(0) == 'O' && grid[1][6].charAt(0) == 'O' && grid[2][6].charAt(0) == 'O')
                ||(grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == 'O'
                && grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
        ) {
           winner = 3;
       } else if ((grid[0][2].charAt(0) == 'X' && grid[0][4].charAt(0) == 'O' && grid[0][6].charAt(0) == 'X'
               && grid[1][2].charAt(0) == 'X' && grid[1][4].charAt(0) == 'O' && grid[1][6].charAt(0) == 'X'
               && grid[2][2].charAt(0) == 'O' && grid[2][4].charAt(0) == 'X' && grid[2][6].charAt(0) == '0')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'O' && grid[2][2].charAt(0) == 'O'
               && grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'O'
               && grid[0][6].charAt(0) == 'O' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == '0'
               && grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == '0'
               && grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'O')
               || (grid[0][2].charAt(0) == 'O' && grid[1][2].charAt(0) == 'O' && grid[2][2].charAt(0) == 'X'
               && grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == 'X'
               && grid[0][6].charAt(0) == '0' && grid[1][6].charAt(0) == 'O' && grid[2][6].charAt(0) == 'X')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == 'O'
               && grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'O'
               && grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'O')
               || (grid[0][2].charAt(0) == 'O' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == 'X'
               && grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'X' && grid[2][4].charAt(0) == 'X'
               && grid[0][6].charAt(0) == '0' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'X')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'O' && grid[2][2].charAt(0) == 'O'
               && grid[0][4].charAt(0) == 'X' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == '0'
               && grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == '0' && grid[2][6].charAt(0) == 'O')
               || (grid[0][2].charAt(0) == 'X' && grid[1][2].charAt(0) == 'X' && grid[2][2].charAt(0) == 'O'
               && grid[0][4].charAt(0) == 'O' && grid[1][4].charAt(0) == 'O' && grid[2][4].charAt(0) == 'X'
               && grid[0][6].charAt(0) == 'X' && grid[1][6].charAt(0) == 'X' && grid[2][6].charAt(0) == 'O')) {
           winner = 5;
       }
        return winner;
    }

    public static String[][] youMove(String[][] grid) {
        int coordinate1 = 0;
        int coordinate2 = 0;

        boolean flag = true;

        while (flag) {
                try {
                    System.out.print("Enter the coordinates: ");
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();
                    if (coordinate1 > 0 && coordinate1 <= 3 && coordinate2 > 0 && coordinate2 <= 3) {
                         if (coordinate2 == 1 ) {
                             if ((grid[coordinate1 - 1][coordinate2 + 1].charAt(0) == 'X')
                                     || grid[coordinate1 - 1][coordinate2 + 1].charAt(0) == 'O'
                                     || (grid[coordinate1 - 1][coordinate2 + 1].charAt(0) == 'O')
                                     || grid[coordinate1 - 1][coordinate2 + 1].charAt(0) == 'X') {
                                 System.out.println("This cell is occupied! Choose another one!");
                             } else {
                                 if (previousMove == "O") {
                                     grid[coordinate1 - 1][coordinate2 + 1] = "X";
                                     previousMove = "X";
                                     flag = false;
                                 } else if (previousMove == "X") {
                                     grid[coordinate1 - 1][coordinate2 + 1] = "O";
                                     previousMove = "O";
                                     flag = false;
                                 }
                             }
                         } else if (coordinate2 == 2) {
                             if ((grid[coordinate1 - 1][coordinate2 + 2].charAt(0) == 'X')
                                     || grid[coordinate1 - 1][coordinate2 + 2].charAt(0) == 'O'
                                     || (grid[coordinate1 - 1][coordinate2 + 2].charAt(0) == 'O')
                                     || grid[coordinate1 - 1][coordinate2 + 2].charAt(0) == 'X') {
                                 System.out.println("This cell is occupied! Choose another one!");
                             } else {
                                 if (previousMove == "O") {
                                     grid[coordinate1 - 1][coordinate2 + 2] = "X";
                                     previousMove = "X";
                                     flag = false;
                                 } else if (previousMove == "X") {
                                     grid[coordinate1 - 1][coordinate2 + 2] = "O";
                                     previousMove = "O";
                                     flag = false;
                                 }
                                 flag = false;
                             }
                         } else if (coordinate2 == 3)
                        if ((grid[coordinate1 - 1][coordinate2 + 3].charAt(0) == 'X')
                                || grid[coordinate1 - 1][coordinate2 + 3].charAt(0) == 'O'
                                || (grid[coordinate1 - 1][coordinate2 + 3].charAt(0) == 'O')
                                || grid[coordinate1 - 1][coordinate2 + 3].charAt(0) == 'X') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            if (previousMove == "O") {
                                grid[coordinate1 - 1][coordinate2 + 3] = "X";
                                previousMove = "X";
                                flag = false;
                            } else if (previousMove == "X") {
                                grid[coordinate1 - 1][coordinate2 + 3] = "O";
                                previousMove = "O";
                                flag = false;
                            }
                            flag = false;
                        }

                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
        }

        return grid;
    }
}
