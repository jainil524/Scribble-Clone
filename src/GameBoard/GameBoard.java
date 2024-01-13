package GameBoard;

import Player.PlayerManager;
import Server.GameBoard.GameServer;

public class GameBoard {

    public static final int ScoreToAddRemove = 30;
    public GameServer gs = new GameServer();
    private String GameBoardID = "";
    private GameState gamestate = GameState.WAITING_FOR_PLAYERS;
    private PlayerManager playermanager = new PlayerManager();

    private int drawerID;

    public PlayerManager getPlayermanager(){
        return this.playermanager;
    }

    public static GameBoard createInstance(String ID){

        return new GameBoard(ID);
    }

    private GameBoard(String gameBoardID)
    {
        new Thread(gs).start();
        this.GameBoardID = gameBoardID;
    }

    public String getKey(){
        return this.GameBoardID;
    }

    public int getDrawerID(){
        return this.drawerID;
    }

    public void setDrawerID(int drawerID){
        this.drawerID = drawerID;
    }


}
