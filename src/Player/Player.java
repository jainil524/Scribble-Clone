package Player;

import GameBoard.GameBoard;
import GameBoard.UI.DrawingCanvas;
import Server.GameBoard.GameClient;

import java.awt.Color;

public class Player implements AbstractPlayer{

    private int ID;
    private GameBoard gameBoard;
    private String Name = "";
    private PlayerState playerstate = PlayerState.PAUSED;
    private int Score;
    private Color color;
    public GameClient gc = new GameClient();


    public static Player createInstance(String name,int ID){
        return new Player(name,ID);
    }

    private Player(String name,int ID){
        new Thread(gc).start();
        this.ID = ID;
        this.Name = name;
        this.setColor(GenerateColor());
    }

    private Color GenerateColor(){

        int red = (int) Math.floor(Math.random()*255);
        int green = (int) Math.floor(Math.random()*255);
        int blue = (int) Math.floor(Math.random()*255);

        return new Color(red,green,blue);
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public int getScore() {
        return this.Score;
    }

    @Override
    public GameBoard getGameboard() {
        return this.gameBoard;
    }

    @Override
    public Color setColor(Color c) {
        this.color = c;
        return this.color;
    }

    @Override
    public GameBoard setGameboard(GameBoard g) {
        this.gameBoard = g;
        return this.gameBoard;
    }

    @Override
    public int increaseScore(int score) {
        this.Score += score;
        return this.Score;
    }

    @Override
    public int decreaseScore(int score) {
        this.Score -= score;
        return this.Score;
    }
}