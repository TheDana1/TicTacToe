import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeView> views;
    private List<Character>statusList;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
        statusList = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView view){
        views.add(view);
    }

    public void removeTicTacToeView(TicTacToeView view){
        views.remove(view);
    }


    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }
    private boolean checkElements(){
        char first = statusList.get(0);
        for (char elem : statusList){
            if (elem != first){
                return false;
            }
        }
        return  true;
    }

    private Status updateStatus() {              //checks columns
        int counter2 = 0;
        for (int i = 0; i < SIZE; i++) {
            statusList.clear();
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != ' ') {
                    statusList.add(grid[i][j]);
                }
            }
            if (statusList.size() >2 ) {
                if (checkElements()){
                    if (statusList.get(0).equals('X')) {
                        return status = status.X_WON;
                    } else {
                        return status = status.O_WON;
                    }
                }
            }
        }
        for (int j = 0; j < SIZE; j++) {                 //checks rows
            statusList.clear();
            for (int i = 0; i < SIZE; i++) {
                if (grid[i][j] != ' ') {
                    counter2++;
                    statusList.add(grid[i][j]);
                }
            }
            if (statusList.size() > 2) {
                if (checkElements()){
                    if (statusList.get(0).equals('X')) {
                        return status = status.X_WON;
                    } else {
                        return status = status.O_WON;
                    }
                }
                }
            }

        statusList.clear();
        for (int i = 0; i < SIZE; i++) {                  //checks diagonal
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if ((grid[i][j] != ' ')) {
                        statusList.add(grid[i][j]);
                    }
                }
            }
        }
        if (statusList.size() > 2) {
            if (checkElements()){
                if (statusList.get(0).equals('X')) {
                    return status = status.X_WON;
                } else {
                    return status = status.O_WON;
                }
            }
    }
        statusList.clear();
        for (int i = 0; i < SIZE; i++) {                  //checks antiphonal
            for (int j = SIZE - 1; j >=0 ; j--) {
                if (j == SIZE - 1 - i) {
                    if (grid[i][j] != ' '){
                        statusList.add(grid[i][j]);
                }
            }
            }
        }
        if (statusList.size() > 2) {
            if (checkElements()){
                if (statusList.get(0).equals('X')) {
                    return status = status.X_WON;
                } else {
                    return status = status.O_WON;
                }
            }
        }
                if (counter2 == SIZE * SIZE) {
                    return status = status.TIE;
                } else {
                    return status = status.UNDECIDED;
                }

            }




    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for (TicTacToeView view: views){
            view.handleTicTacToeStatusUpdate(new TicTacToeEvent(this, status, x, y));
        }
        if (updateStatus() == Status.X_WON) {
            JOptionPane.showMessageDialog(null, "X WON!");
        }
        else if(updateStatus() == Status.O_WON){
            JOptionPane.showMessageDialog(null, "O WON!");
        }
        changeTurn();
    }
}

