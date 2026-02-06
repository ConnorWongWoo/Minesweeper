public class Cell {
    private boolean mine;
    private boolean reveal;
    private boolean flag;

    Cell(boolean mine, boolean reveal, boolean flag) {
        this.mine = mine;
        this.reveal = reveal;
        this.flag = flag;
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

    public boolean isMine() {
        return this.mine;
    }
    public boolean isReveal() {
        return this.reveal;
    }
    public boolean isFlag() {
        return this.flag;
    }
}
