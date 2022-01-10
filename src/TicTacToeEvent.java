import java.util.EventObject;

public class TicTacToeEvent extends EventObject {

    TicTacToeModel.Status status;
    private int x;
    private int y;

    public TicTacToeEvent(TicTacToeModel ticTacToeModel, TicTacToeModel.Status status, int x, int y) {
        super(ticTacToeModel);
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
