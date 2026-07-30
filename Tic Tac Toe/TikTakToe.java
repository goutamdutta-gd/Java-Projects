import java.util.*;
public class TikTakToe{
    static Scanner in = new Scanner(System.in);
    
    public static void comp(char[][] grid, char compChoice) {
    Random rand = new Random();

    while (true) {
        int row = rand.nextInt(3);
        int col = rand.nextInt(3);

        if (grid[row][col] == ' ') {
            grid[row][col] = compChoice;
            System.out.println("Computer chose: " + row + " " + col);
            print(grid);
            break;
        }
    }
}

    public static boolean printchoice(char[][] grid, int row, int col,char choice){
        //Assigning the choice
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid Position!");
        return false;
        }

        if (grid[row][col] != ' ') {
            System.out.println("Invalid Choice! Try Again");
            return false;
        }
    
        grid[row][col] = choice;
        print(grid);
        return true;
    }
    public static void print(char[][] grid){
        //Printing the whole table
        for (int i = 0; i < grid.length; i++) {
            System.out.println("+---+---+---+");
            for (int j = 0; j < grid.length; j++) {
                System.out.print("| "+ grid[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+");
    }

    public static boolean draw(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==' '){
                    return false;
                }
            }
        }
        System.out.println("Game Draw");
        return true;
    }

    public static boolean win(char[][] grid, char choice){
        for (int i = 0; i < grid.length; i++) {
            if(grid[0][i]==choice && grid[1][i]==choice && grid[2][i]==choice ){
                System.out.println("Player: "+choice+" won the game.");
                return true;
            }
            if(grid[i][0]==choice && grid[i][1]==choice && grid[i][2]==choice ){
                System.out.println("Player: "+choice+" won the game.");
                return true;
            }
        }
        if(grid[0][0]==choice && grid[1][1]==choice && grid[2][2]==choice ){
            System.out.println("Player: "+choice+" won the game.");
            return true;
        }
        if(grid[0][2]==choice && grid[1][1]==choice && grid[2][0]==choice ){
            System.out.println("Player: "+choice+" won the game.");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Tik-Tak-Toe Game");
        char[][] grid = new char[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j]=' ';
            }
        }
        System.out.println("Please select your symbol:O or X");
        char choice = Character.toUpperCase(in.next().charAt(0));
        if (choice != 'X' && choice != 'O') {
            System.out.println("Please enter only X or O.");
            return;
        }    

        char compChoice;

        
        
        if (choice == 'X') {
            compChoice = 'O';
        } else {
            compChoice = 'X';
        }
        boolean gamewon = false;
        boolean gamedraw = false;
        print(grid);
        while(!gamewon && !gamedraw){
            System.out.println("Please enter row and column:");
            int row = in.nextInt();
            int col = in.nextInt();
        
            if (!printchoice(grid, row, col, choice)) {
                continue;
            }
        
            gamewon = win(grid, choice);
            if (gamewon)
                break;
        
            gamedraw = draw(grid);
            if (gamedraw)
                break;
        
            comp(grid, compChoice);
        
            gamewon = win(grid, compChoice);
            if (gamewon)
                break;
        
            gamedraw = draw(grid);
        }
    }
}
