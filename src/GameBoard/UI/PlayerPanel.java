package GameBoard.UI;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class PlayerPanel extends JPanel {
    public PlayerPanel(Map<Integer, Player> players) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250,500));
        for (Map.Entry<Integer, Player> p: players.entrySet()) {
            PlayerCard playerCard = PlayerCard.getNewPlayer(p.getValue());
            playerCard.setMaximumSize(new Dimension(290, 70));
            add(playerCard);
        }
    }
}