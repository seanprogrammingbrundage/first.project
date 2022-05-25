public class Position {
    private int row, col;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }
    // constructor
    public Position() {
        row = -1;
        col = -1;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean equals(Object o) {
        if(o instanceof Position) {
            Position temp = (Position)o;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;

    }

    public void setColumn(int col) {
        this.col = col;
    }
    // constructor
    public Position(int r, int c) {
        row = r;
        col = c;
    }
}
