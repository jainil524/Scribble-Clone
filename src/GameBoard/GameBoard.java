package GameBoard;

import Player.PlayerManager;

public class GameBoard {

    public static final int ScoreToAddRemove = 30;
    private String GameBoardID = null;
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
