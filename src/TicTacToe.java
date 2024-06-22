import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to the game tic-tac-toe!\n" +
                "\nYour goal is to achieve three same symbols (X or O) in a row or column.\n" +
                "\nThis is the grid:");

        char [][] grid = new char[3][3];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = '-';
            }
        }
        printGrid(grid);
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1, you are X. Please enter your name: ");
        String p1 = sc.nextLine();
        System.out.println("Player 2, you are O. Please enter your name: ");
        String p2 = sc.nextLine();

        boolean gameOver = false;
        boolean player1 = true;


        while(!gameOver){
            if(player1){
                System.out.println(p1 + " it is your turn.");
            } else{
                System.out.println(p2 + " it is your turn.");
            }

            //1 = X, 2 = O
            char userNumber = ' ';
            if(player1){
                userNumber = 'X';
            } else {
                userNumber = 'O';
            }

            System.out.println("Please enter the row number (0-2): ");
            int userInputRow = sc.nextInt();
            System.out.println("Please enter the column number (0-2): ");
            int userInputCol = sc.nextInt();

            if(userInputRow >= 0 && userInputRow < 3 && userInputCol >= 0 && userInputCol < 3){

                if(grid[userInputRow][userInputCol] == '-'){
                    grid[userInputRow][userInputCol] = userNumber;
                    System.out.println("");
                    printGrid(grid);

                    boolean threeInRow = true;
                    for (int j = 0; j < grid.length; j++){
                        if(grid[userInputRow][j] != userNumber){
                            threeInRow = false;
                            break;
                        }
                    }
                    boolean threeInCol = true;
                    for (int i = 0; i < grid.length; i++){
                        if(grid[i][userInputCol] != userNumber){
                            threeInCol = false;
                            break;
                        }
                    }
                    //checking the diagonals from upper left - bottom right
                    boolean threeInDiag1 = true;
                    if(userInputRow == userInputCol){
                        for (int i = 0; i < grid.length; i++){
                            if(grid[i][i] != userNumber){
                                threeInDiag1 = false;
                            }
                        }
                    } else{
                        threeInDiag1 = false;
                    }

                    //checking the diagonals from upper right - bottom left
                    boolean threeInDiag2 = true;
                    if(userInputRow + userInputCol == grid.length - 1){
                        for (int i = 0; i < grid.length; i++){
                            if(grid[i][grid.length - 1 - i] != userNumber){
                                threeInDiag2 = false;
                            }
                        }
                    } else{
                        threeInDiag2 = false;
                    }

                    if(threeInRow || threeInCol || threeInDiag1 || threeInDiag2){
                        if(player1){
                            System.out.println("\n" + p1 + " you won the game!");
                            gameOver = true;
                            break;
                        } else {
                            System.out.println("\n" + p2 + " you won the game!");
                            gameOver = true;
                            break;
                        }
                    }
                    if (boardIsFull(grid)){
                        System.out.println("\nIt is a draw!");
                        gameOver = true;
                    } else {
                        System.out.println("\nPlease continue the game. To win the game you need to get three symbols in a row or column.\n");
                        player1 =! player1;
                    }
                } else{
                    System.out.println("\nThere is already a symbol, try again!\n");
                }
            } else{
                System.out.println("\nWrong number. Please enter a number between 0 and 2:\n ");
            }
        } sc.close();
    }
    public static void printGrid (char[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean boardIsFull(char[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}

