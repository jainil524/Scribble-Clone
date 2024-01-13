package Player;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public final class PlayerManager {
    private int LastPlayerID = 0;

    private Map<Integer,Player> AllPlayers = new HashMap<Integer,Player>();

    public Player addPlayer(String name){
        LastPlayerID++;
        Player p = Player.createInstance(name,LastPlayerID);

        AllPlayers.put(LastPlayerID,p);

        return p;
    }

    public Map getAllPlayers(){
        return this.AllPlayers;
    }


}

