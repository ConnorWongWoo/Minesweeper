import java.util.Random;

public class Board {
    private String difficulty;
    private Cell[][] board;
    private boolean complete;
    private boolean gameOver;
    private boolean gameRunning;
    private int mineCount;
    private int flagCount;
    private int height;
    private int width;

    Board(int width, int height, String difficulty){
        this.difficulty = difficulty;
        complete = false;

        if (height < 4) height = 4;
        if (width < 4) width = 4;

        this.height = height;
        this.width = width;
        this.board = new Cell[height][width];
        this.complete = false;
        this.gameOver = false;
        this.gameRunning = false;

        Random rand = new Random();
        int min, max;

        if (difficulty.equals("EASY")) {
            min = 10; max = 18;
        } 
        else if (difficulty.equals("MEDIUM")) {
            min = 18; max = 24;
        } 
        else if (difficulty.equals("HARD")) {
            min = 24; max = 30;
        }
         else if (difficulty.equals("EXTREME")) {
            min = 30; max = 36;
        } 
        else {
            min = 10; max = 18;
        }

        double percent = (rand.nextInt(max - min + 1) + min) / 100.0;
        mineCount = (int) (percent * height * width);

        this.flagCount = this.mineCount;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.board[y][x] = new Cell(false, false, false);
            }
        }
    }

    public void populateMines(int i_y, int i_x) {
        Random rand = new Random();
        int placed = 0;

        while (placed < this.mineCount) {
            int y = rand.nextInt(height);
            int x = rand.nextInt(width);
            // Prevent stacking mines and mine spawning on initial coordinates
            if (!this.board[y][x].isMine() && !(y == i_y && x == i_x)) {
                this.board[y][x].setMine(true);
                placed++;
            }
            else {
                System.out.println(this.board[y][x].isMine());
            }
        }

        // Setting nums
        for (Cell[] y: this.board) {
            for (Cell x: y) {
                
            }
        }
    }

    public void displayBoard() {
        // Upper bounds (visual)
        for (int i = 0; i < this.width * 2 - 1; i++) {
            System.out.print("=");
        }
        System.out.println("");
        
        for (Cell[] y: this.board) {
            String displayRow = "";
            for (Cell x: y) {
                displayRow = displayRow + x + " ";
            }
            System.out.println(displayRow);
        }
        // Lower bounds (visual)
        for (int i = 0; i < this.width * 2 - 1; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }
    
    public void setGameRunning(boolean s) {
        this.gameRunning = s;
    }

    public int getFlagCount() {
        return this.flagCount;
    }

    public int getMineCount() {
        return this.mineCount;
    }

    public boolean isComplete() {
        return this.complete;
    }
    public boolean isGameOver() {
        return this.gameOver;
    }
    public boolean isGameRunning() {
        return this.gameRunning;
    }
}
