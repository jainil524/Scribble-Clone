import GameBoard.GameBoard;
import GameBoard.UI.MainFrame;
import Player.Player;
import ScribbleExceptions.NoSuchGameBoardException;
import Server.GameRoom.RoomManagment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingScreen extends JFrame {
    private JTextField nameField;
    private JTextField codeField;

    public LandingScreen() {

        setTitle("Skribble Clone Landing Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameField = new JTextField();

        JLabel codeLabel = new JLabel("Enter Game Code:");
        codeField = new JTextField();

        JButton joinButton = new JButton("Join Game via Code");
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText();
                String gameCode = codeField.getText();

                try {
                    Object[] obj = RoomManagment.joinGameRoom(playerName,gameCode);
                    new Thread(new MainFrame("Scribble Clone: "+playerName,(GameBoard) obj[0],(Player) obj[1])).start();
                    LandingScreen.this.dispose();
                } catch (NoSuchGameBoardException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton createRoomButton = new JButton("Create a New Room");
        createRoomButton.addActionListener(e -> {
            String playerName = nameField.getText();
            try {
                Object[] obj = RoomManagment.addGameBoard(playerName);
                new Thread(new MainFrame("Scribble Clone: "+playerName,(GameBoard) obj[0],(Player) obj[1])).start();
                LandingScreen.this.dispose();
            } catch (NoSuchGameBoardException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(codeLabel);
        add(codeField);
        add(joinButton);
        add(createRoomButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LandingScreen();
    }
}