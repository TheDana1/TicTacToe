import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {

    TicTacToeModel ttt;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testInitialStatus() {
        ttt = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateXWON1() {        // x vertically won
        ttt = new TicTacToeModel();
        ttt.play(0, 0); //x
        ttt.play(0, 1); //O
        ttt.play(1, 0); //x
        ttt.play(2, 1); //O
        ttt.play(2, 0); //x
        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateXWON2() {          // x horizontally won
        ttt = new TicTacToeModel();
        ttt.play(1, 0); //x
        ttt.play(2, 0); //O
        ttt.play(1, 1); //x
        ttt.play(2, 1); //O
        ttt.play(1, 2); //x
        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateUndecided1() {  // Game in progress
        ttt = new TicTacToeModel();
        ttt.play(2, 0); //O
        ttt.play(0, 2); //x
        ttt.play(1, 2); //x
        ttt.play(2, 1); //O
        ttt.play(2, 2); //x
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateOWon() {      // O won vertically
        ttt = new TicTacToeModel();
        ttt.play(0, 0); //x
        ttt.play(0, 1); //O
        ttt.play(1, 2); //x
        ttt.play(1, 1); //O
        ttt.play(2, 2); //x
        ttt.play(2, 1); //0
        assertEquals(TicTacToeModel.Status.O_WON, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateOWONDiagonally() {          // O diagonally won
        ttt = new TicTacToeModel();
        ttt.play(2, 0); //X
        ttt.play(0, 0); //O
        ttt.play(2, 1); //X
        ttt.play(1, 1); //O
        ttt.play(1, 0); //X
        ttt.play(2, 2); //O
        assertEquals(TicTacToeModel.Status.O_WON, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateXWONDiagonally() {          // x antiphonally won
        ttt = new TicTacToeModel();
        ttt.play(0, 2); //x
        ttt.play(0, 0); //O
        ttt.play(1, 1); //x
        ttt.play(1, 2); //O
        ttt.play(2, 0); //x
        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }

    @Test
    public void testStatusUpdateTie() {          // Tie
        ttt = new TicTacToeModel();
        ttt.play(0, 1); //x
        ttt.play(0, 0); //O
        ttt.play(0, 2); //x
        ttt.play(1, 1); //O
        ttt.play(1, 0); //x
        ttt.play(1, 2); //0
        ttt.play(2, 0); //x
        ttt.play(2, 1); //x
        ttt.play(2, 2); //x
        assertEquals(TicTacToeModel.Status.TIE, ttt.getStatus());

    }
}