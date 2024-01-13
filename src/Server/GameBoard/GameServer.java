package Server.GameBoard;

import GameBoard.GameBoardManager;
import GameBoard.GameBoard;
import Player.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class GameServer implements Runnable {

    public InputStream input;
    public OutputStream output;

    // In GameServer
    public void sendImageToClients(BufferedImage image, Map<Integer, Player> players) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            // Send the image to all connected clients
            for (Player p : players.values()) {
                p.gc.output.write(imageBytes);
                p.gc.output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int port = 6543;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                // Accept a new client connection
                Socket clientSocket = serverSocket.accept();
                input = clientSocket.getInputStream();
                output = clientSocket.getOutputStream();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
