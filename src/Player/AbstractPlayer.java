package Player;

import GameBoard.GameBoard;

import java.awt.Color;

public interface AbstractPlayer {
    public int getID();
    public Color getColor();
    public String getName();
    public int getScore();
    public GameBoard getGameboard();

    public Color setColor(Color c);
    public int increaseScore(int score);
    public int decreaseScore(int score);
    public GameBoard setGameboard(GameBoard g);
}
