import java.util.Scanner;  

public class Game {
    private Board board;
    
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board width");
        int width = sc.nextInt();
        System.out.println("Enter the board height");
        int height = sc.nextInt();
        System.out.println("Enter the difficulty | EASY, MEDIUM, HARD, EXTREME");
        String difficulty = sc.nextLine();
        // Board.Difficulty -> EASY, MEDIUM, HARD, EXTREME
        board = new Board(width, height, difficulty);
    }
}
