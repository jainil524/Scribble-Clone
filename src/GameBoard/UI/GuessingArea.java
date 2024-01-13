package GameBoard.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingArea extends JPanel {
    private JTextField guessField;
    private JLabel guessStatus;
    public GuessingArea() {
        setLayout(new FlowLayout());

        guessField = new JTextField(20);
        guessStatus = new JLabel();
        guessField.addActionListener(e -> {
            String guess = guessField.getText();
            if (!guess.isEmpty()) {
                appendGuess("Guess: " + guess);
                guessField.setText("");
            }
        });

        add(new JLabel("Guess: "));
        add(guessField);
        add(guessStatus);
    }

    public void appendGuess(String guess) {
        // Handle displaying guesses as needed
    }
}
