package GameBoard.UI;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerCard extends JPanel {
    private JLabel playerNameLabel;
    private JLabel scoreLabel;
    private JLabel colorstylist;

    public PlayerCard(Player player) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(player.getColor(), 2));

        playerNameLabel = new JLabel(player.getName());
        add(playerNameLabel, BorderLayout.NORTH);

        scoreLabel = new JLabel("Score: " + player.getScore());
        add(scoreLabel, BorderLayout.SOUTH);

        colorstylist = new JLabel();
        colorstylist.setSize(new Dimension(5,100));
        colorstylist.setBackground(player.getColor());
        add(colorstylist,BorderLayout.WEST);

        setOpaque(true);
    }

    public static PlayerCard getNewPlayer(Player player) {
        return new PlayerCard(player);
    }

    public void changeScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
