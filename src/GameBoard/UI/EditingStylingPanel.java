package GameBoard.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EditingStylingPanel extends JPanel {
    private DrawingCanvas canvas;
    JPanel colorPreviewPanel = new JPanel();
    JButton Ereser = new JButton("Ereser");
    private Color currentColor = Color.BLACK;
    private JSlider penWidthSlider;

    public EditingStylingPanel(DrawingCanvas canvas) {
        this.canvas = canvas;

        // Create a button for selecting color
        colorPreviewPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color selectedColor = JColorChooser.showDialog(EditingStylingPanel.this, "Select a Color", currentColor);
                if (selectedColor != null) {
                    currentColor = selectedColor;
                    canvas.setCurrentColor(currentColor);
                    colorPreviewPanel.setBackground(currentColor);
                }
            }
        });

        Ereser.addActionListener(e -> {
            if (currentColor == Color.BLACK) {
                currentColor = Color.WHITE;
            } else {
                currentColor = Color.BLACK;
            }
            canvas.setCurrentColor(currentColor);
            colorPreviewPanel.setBackground(currentColor);
        });

        // Create a slider for setting pen width
        penWidthSlider = new JSlider(JSlider.HORIZONTAL, 1, 60, 1);
        penWidthSlider.setMajorTickSpacing(5);
        penWidthSlider.setPaintTicks(true);
        penWidthSlider.setSnapToTicks(true);
        penWidthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int penWidth = penWidthSlider.getValue();
                canvas.setPenWidth(penWidth);
            }
        });

        // Create a "Clear Canvas" button
        JButton clearButton = new JButton("Clear Canvas");
        clearButton.addActionListener(e -> canvas.clearCanvas());

        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add a color preview panel
        colorPreviewPanel.setPreferredSize(new Dimension(30, 30));
        colorPreviewPanel.setBackground(currentColor);
        add(colorPreviewPanel);
        add(Ereser);
        add(new JLabel("Pen Width:"));
        add(penWidthSlider);
        add(clearButton);
    }
}
