package ScribbleExceptions;

import javax.swing.*;

public class NoSuchGameBoardException extends RuntimeException{

    public NoSuchGameBoardException(){
        JOptionPane.showMessageDialog(null, "Invalid code!!!", "No such room exists", JOptionPane.ERROR_MESSAGE);
    }


    public String toString(){
        return "NoSuchGameBoardException: No gameboard exist with that code.";
    }
}
