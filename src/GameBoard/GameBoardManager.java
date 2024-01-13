package GameBoard;

import ScribbleExceptions.NoSuchGameBoardException;
import Player.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class GameBoardManager{
    private static GameBoardManager gameboardManager = new GameBoardManager();
    private static Map<String, GameBoard> AllGameBoard = new ConcurrentHashMap<String, GameBoard>();

    synchronized public GameBoard addGameBoard(){
        String key = generateRandomKey(6);
        GameBoard g = GameBoard.createInstance(key);

        AllGameBoard.put(key,g);
        return g;
    }


    private String generateRandomKey(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();

        String generatedKey;
        do {
            result.setLength(0); // Reset the StringBuilder content.
            for (int i = 0; i < length; i++) {
                result.append(characters.charAt(rnd.nextInt(characters.length())));
            }
            generatedKey = result.toString();
        } while (this.AllGameBoard.containsKey(generatedKey));

        return generatedKey;
    }

    public void getAllGameBoard(){

        if(AllGameBoard.size() == 0){
            System.out.println("No Game Board Available");
            return;
        }

        for(Map.Entry<String, GameBoard> p: AllGameBoard.entrySet()){
            GameBoard player = p.getValue();
            System.out.println("Key: "+player.getKey()+" | Player.Drawer: "+player.getDrawerID());
        }

    }

    public synchronized Player addPlayerToGameBoard(String name,String key) {
        GameBoard g = getGameboardByKey(key);

        Player p = g.getPlayermanager().addPlayer(name);
        return p;
    }

    public GameBoard getGameboardByKey(String key) {
        getAllGameBoard();
        for (GameBoard gameBoard : AllGameBoard.values()) {
            if (gameBoard.getKey().equals(key)) {
                return gameBoard;
            }
        }
        throw new NoSuchGameBoardException();
    }

    private GameBoardManager(){}

    public static GameBoardManager getGameBoardManagerInstace(){
            return gameboardManager;
    }



}