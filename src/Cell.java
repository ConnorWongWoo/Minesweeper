public class Cell {
    private boolean mine;
    private boolean reveal;
    private boolean flag;
    private int touchingMines;

    Cell(boolean mine, boolean reveal, boolean flag) {
        this.mine = mine;
        this.reveal = reveal;
        this.flag = flag;
        this.touchingMines = 0;
    }

    public void setMine(boolean m) {
        this.mine = m;
    }
    public void setReveal(boolean r) {
        this.reveal = r;
    }
    public void setFlag(boolean f) {
        this.flag = f;
    }
    public void setTouching(int n) {
        this.touchingMines = n;
    }

    public boolean isMine() {
        return this.mine;
    }
    public boolean isReveal() {
        return this.reveal;
    }
    public boolean isFlag() {
        return this.flag;
    }
    public int countTouching() {
        return this.touchingMines;
    }
    public String toString() {
        String textDisplay;
        if (this.mine) {
                textDisplay = "M"; // Todo - add game over logic
            }
            else {
                // Todo - add touching mines count
                textDisplay = "#"; // Empty spot revealed
            }
        // if (this.reveal) {
        //     if (this.mine) {
        //         textDisplay = "M"; // Todo - add game over logic
        //     }
        //     else {
        //         // Todo - add touching mines count
        //        textDisplay = "O"; // Empty spot revealed
        //     }
        // }
        // else  {
        //     if (this.flag) {
        //             textDisplay = "F"; // Flagged spot
        //         }
        //         else {
        //             textDisplay = "#"; // Empty Spot not revealed
        //         }
        // }

        return textDisplay;
    }
}
