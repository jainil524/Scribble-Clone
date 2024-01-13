package GameBoard.UI;

import GameBoard.GameBoard;
import Utilities.DrawingToImageConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingCanvas extends JPanel {
    private int lastX, lastY;
    private Color currentColor = Color.BLACK;
    private int penWidth = 1;
    BufferedImage cursorImage=null;
    GameBoard gameBoard = null;
    public DrawingCanvas(GameBoard gb) {
        this.gameBoard = gb;
        this.setBackground(Color.WHITE);
        setPreferredSize(new Dimension(380, 400));

        // Load and set the custom cursor
        try {
            BufferedImage cursorImage = ImageIO.read(new File("E:\\PDPU\\Semester - 5\\Advanced Java\\Scribble Clone\\src\\asset\\img\\pencil_icon.png")); // Provide the path to your cursor image
            Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "PencilCursor");
            this.setCursor(customCursor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY() + 24;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY() + 24;

                drawLine(lastX, lastY, x, y, currentColor, penWidth);
                lastX = x;
                lastY = y;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color, int width) {
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File("C:\\Users\\user\\Pictures\\Saved Pictures\\java.png")); // Load the image from a file
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Graphics2D g2d = (Graphics2D) getGraphics();
        gameBoard.gs.sendImageToClients(DrawingToImageConverter.convertDrawingToImage(DrawingCanvas.this),gameBoard.getPlayermanager().getAllPlayers());

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width));
        g2d.drawLine(x1, y1, x2, y2);
        g2d.dispose();
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setPenWidth(int width) {
        penWidth = width;
    }

    public void clearCanvas() {
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setPaint(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        repaint(); // Redraw the canvas to apply the background color
    }
}
