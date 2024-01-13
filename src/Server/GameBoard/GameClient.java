package Server.GameBoard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameClient implements Runnable{
    public InputStream input;
    public OutputStream output;

    // In GameClient
    public synchronized void sendImage(byte[] imageBytes) {
        try {
            // Send the image data to the server
            output.write(imageBytes);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage receiveImage() {
        try {
            // Receive the image data from the server
            byte[] imageBytes = new byte[1024];  // Adjust the buffer size as needed
            int bytesRead = input.read(imageBytes);

            if (bytesRead > 0) {
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes, 0, bytesRead);
                BufferedImage image = ImageIO.read(bais);
                return image;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 6543);
            System.out.println("Connected to the server.");
            input = socket.getInputStream();
            output = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
