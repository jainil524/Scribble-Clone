package GameBoard.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChattingArea extends JPanel {
    private JTextArea chatArea;
    private JTextField messageField;

    public ChattingArea() {
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setPreferredSize(new Dimension(300, 150));

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (!message.isEmpty()) {
                    appendMessage("You: " + message);
                    messageField.setText("");
                }
            }
        });

        add(chatScrollPane, BorderLayout.CENTER);
        add(messageField, BorderLayout.SOUTH);
    }

    public void appendMessage(String message) {
        chatArea.append(message + "\n");
    }
}
