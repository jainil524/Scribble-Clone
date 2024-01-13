package Server.GameRoom;

import Player.Player;
import GameBoard.GameBoard;
import GameBoard.GameBoardManager;
import ScribbleExceptions.NoSuchGameBoardException;

public class RoomManagment{

    public static GameBoardManager gameboardManager = GameBoardManager.getGameBoardManagerInstace();

    public static Object[] addGameBoard(String name) throws NoSuchGameBoardException {
        GameBoard gb = gameboardManager.addGameBoard();
        return joinGameRoom(name,gb.getKey());
    }

    public static Object[] joinGameRoom(String name,String code) throws NoSuchGameBoardException {
        GameBoard gb = gameboardManager.getGameboardByKey(code);
        Player p = gameboardManager.addPlayerToGameBoard(name,gb.getKey());
        return new Object[]{gb,p};
    }
}
