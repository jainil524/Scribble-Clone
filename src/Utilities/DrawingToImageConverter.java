package Utilities;

import GameBoard.UI.DrawingCanvas;

import java.awt.image.BufferedImage;

public class DrawingToImageConverter {
    public static BufferedImage convertDrawingToImage(DrawingCanvas drawingCanvas) {
        int width = drawingCanvas.getWidth();
        int height = drawingCanvas.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        drawingCanvas.paint(image.getGraphics()); // Draw the contents of the drawingCanvas onto the image
        return image;
    }
}
