import java.util.Scanner;  

public class Game {
    
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board width");
        int width = sc.nextInt();
        System.out.println("Enter the board height");
        int height = sc.nextInt();
        System.out.println("Enter the difficulty | EASY, MEDIUM, HARD, EXTREME");
        String difficulty = sc.next();
        // Board.Difficulty -> EASY, MEDIUM, HARD, EXTREME
        Board board = new Board(width, height, difficulty);
    
        board.displayBoard();
        board.setGameRunning(true);
        
        System.out.println("Enter X coordinate of guess");
        int x = sc.nextInt();
        System.out.println("Enter Y coordinate of guess");
        int y = sc.nextInt();
        board.populateMines(y, x);
        board.reveal(y, x);
        board.displayBoard();

        while (board.isGameRunning()) {
            System.out.println("Enter X coordinate of guess");
            x = sc.nextInt();
            System.out.println("Enter Y coordinate of guess");
            y = sc.nextInt();
            board.reveal(y, x);
            board.displayBoard();
        }
        sc.close();
    }
}
