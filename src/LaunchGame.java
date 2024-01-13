import GameBoard.GameBoardManager;
import Player.PlayerManager;

public class LaunchGame {

    public static void main(String[] args){
        PlayerManager p = new PlayerManager();
        PlayerManager p1 = new PlayerManager();

        GameBoardManager gm = GameBoardManager.getGameBoardManagerInstace();
        gm.addGameBoard();
        gm.addGameBoard();
        gm.addGameBoard();

        p.addPlayer("jainil");
        p.addPlayer("dhruv");
        p.addPlayer("kishan");

        p1.addPlayer("jignesh");

        p.getAllPlayers();
        p1.getAllPlayers();

        gm.getAllGameBoard();
    }

}
