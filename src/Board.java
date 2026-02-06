import java.util.Random;

public class Board {
    private String difficulty;
    private Cell[][] board;
    private boolean complete;
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

        Random rand = new Random();
        if (this.difficulty.equals("EASY")) {
            // Formula Easy: Random num 10-18% of total area  
            this.mineCount = (int) (((rand.nextInt(18 - 10 + 1) + 10) / 100) * height * width);
        }
        else if (this.difficulty.equals("MEDIUM")) {
            // Formula Medium: Random num 18-24% of total area  
            this.mineCount = (int) (((rand.nextInt(24 - 18 + 1) + 18) / 100) * height * width);

        }
        else if (this.difficulty.equals("HARD")) {
            // Formula Hard: Random num 24-30% of total area  
            this.mineCount = (int) (((rand.nextInt(30 - 24 + 1) + 30) / 100) * height * width);
        }
        else if (this.difficulty.equals("EXTREME")) {
            // Formula Extreme: Random num 30-36% of total area  
            this.mineCount = (int) (((rand.nextInt(36 - 30 + 1) + 30) / 100) * height * width);
        }
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
        }
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
}
