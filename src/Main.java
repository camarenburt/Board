 class Board {
    public static void main(String[] args) {
        Board board = new Board();
    }
    private String [][] squares ;

    public Board(){
        squares = new String [10][10];
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                squares[r][c] = "-";
            }
        }
    }
    public String toString(){
        String temp = "";
        for (int r = 0; r < squares.length; r++) {

            for (int c = 0; c < squares[0].length; c++) {
                temp +=squares[r][c];
            }
            temp = temp + "\n";
        }
        return temp;
    }

    public boolean addShip(int row, int col, int len, boolean horizontal) {
        boolean done = false;
        boolean clear = true;
        int temp = col;
        if (horizontal) {
            if(col+len>10){
                return done;
            }
            for (int i = 0; i < len; i++) {
                if (!squares[row][col].equals("-")) {
                    clear = false;
                }
                col++;
            }
            col = temp;
            if (clear) {
                for (int i = 0; i < len; i++) {
                    squares[row][col] = "b";
                    col++;
                }
                done = true;
            }
        } else {
            if(col+len>10){
                return done;
            }
            temp = row;
            for (int i = 0; i < len; i++) {
                if (!squares[row][col].equals("-")) {
                    clear = false;
                }
                row++;
            }
            row = temp;
            if (clear) {
                for (int i = 0; i < len; i++) {
                    squares[row][col] = "b";
                    row++;
                }
                done = true;

            }
        }return done;
    }
    public boolean foundShip(int len){
        boolean done = false;
        int count;
        for (int r = 0; r < squares.length; r++) {
            count = 0;
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c].equals("b")) {
                    count++;
                    if (count == len) {
                        done = true;
                    }
                }
            }
        }
        for (int c = 0; c < squares.length; c++) {
            count = 0;
            for (int r = 0; r < squares[0].length; r++) {
                if (squares[r][c].equals("b")){
                    count++;
                    if (count == len){
                        done = true;
                    }
                }
            }
        }
        return done;
    }
    public int shoot (int row, int col){
        int value = 0;
        if (row>= 0 && row<=10 && col>=0 && col<=10){
            if (squares[row][col].equals("-")){
                squares[row][col] = "m";
                value = 0;
            } else if(squares[row][col].equals("b")){
                squares[row][col] = "x";
                value = 1;
            } else if (squares[row][col].equals("x") || (squares[row][col].equals("m"))){
                value = 2;
            }
        } else{
            value = -1;
        }
        return value;
    }
    public boolean gameOver(){
        boolean done = true;
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                if(squares[r][c] == "b"){
                    done = false;
                }
            }
        }
        return done;
    }
}