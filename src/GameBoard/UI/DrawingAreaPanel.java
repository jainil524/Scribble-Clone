package GameBoard.UI;

import GameBoard.GameBoard;
import Player.Player;

import javax.swing.*;
import java.awt.*;

public class DrawingAreaPanel extends JPanel {
    private DrawingCanvas canvas;
    private EditingStylingPanel editingStylingPanel;
    GameBoard gameBoard = null;
    Player player = null;

    public DrawingAreaPanel(GameBoard gb,Player p) {

        this.gameBoard = gb;
        this.player = p;
        canvas = new DrawingCanvas(gameBoard);
        editingStylingPanel = new EditingStylingPanel(canvas);

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(editingStylingPanel, BorderLayout.SOUTH);
    }
}
