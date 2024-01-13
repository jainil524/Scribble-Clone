package GameBoard.UI;

import GameBoard.GameBoard;
import Player.Player;

import javax.swing.*;
import java.awt.BorderLayout;


public class MainFrame extends Thread{
    JFrame mainframe = new JFrame();
    GameBoard gameBoard = null;
    Player player = null;
    public MainFrame(String title, GameBoard gb, Player p) {
        this.gameBoard = gb;
        this.player = p;
        mainframe.setTitle(title);
        // Create and configure the Player Panel
        PlayerPanel playerPanel = new PlayerPanel(gameBoard.getPlayermanager().getAllPlayers());
        mainframe.add(playerPanel, BorderLayout.WEST);

        // Create and configure the DrawingCanvas
        DrawingCanvas canvas = new DrawingCanvas(this.gameBoard);

        // Create and configure the Editing/Styling panel with a reference to the DrawingCanvas
        EditingStylingPanel editingStylingPanel = new EditingStylingPanel(canvas);

        // Create and configure the Drawing Area Panel
        DrawingAreaPanel drawingAreaPanel = new DrawingAreaPanel(gameBoard,player);
        mainframe.add(drawingAreaPanel, BorderLayout.CENTER);

        // Create and configure the Discussion Area Panel
        DiscussionAreaPanel discussionAreaPanel = new DiscussionAreaPanel(this.gameBoard,this.player);
        mainframe.add(discussionAreaPanel, BorderLayout.EAST);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainframe.setExtendedState(mainframe.MAXIMIZED_BOTH);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }

}