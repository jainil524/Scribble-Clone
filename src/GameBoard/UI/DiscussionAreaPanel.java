package GameBoard.UI;

import GameBoard.GameBoard;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiscussionAreaPanel extends JPanel {
    GameBoard gameBoard = null;
    Player player = null;
    public DiscussionAreaPanel(GameBoard gb, Player p) {
        this.gameBoard = gb;
        this.player = p;

        setLayout(new BorderLayout());

        ChattingArea chatArea = new ChattingArea();
        GuessingArea guessingArea = new GuessingArea();

        // Create and configure the "Leave Game" button
        JButton leaveGameButton = new JButton("Leave Game");
        leaveGameButton.addActionListener(e -> {

        });

        JPanel leaveGamePanel = new JPanel();
        JLabel gamecode = new JLabel("Game Code: "+this.gameBoard.getKey());
        gamecode.setToolTipText("Click to Copy...");
        gamecode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str = gamecode.getText().split(": ")[1];
                Clipboard clip = Toolkit.getDefaultToolkit()
                        .getSystemClipboard();
                StringSelection strse1 = new StringSelection(str);
                clip.setContents(strse1, strse1);
                JOptionPane.showMessageDialog(null,
                        "TEXTS ARE COPIED!");
            }
        });
        leaveGamePanel.add(leaveGameButton);
        leaveGamePanel.add(gamecode);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(chatArea);
        add(guessingArea);
        add(leaveGamePanel);
    }
}
