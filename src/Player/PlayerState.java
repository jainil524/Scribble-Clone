package Player;

public enum PlayerState {
    JOINED,          // When the player has just entered the game room
    READY,           // When the player is ready to start the game
    PLAYING,         // Active state during gameplay
    PAUSED,          // If the player pauses (if applicable)
    DISCONNECTED,    // In case of a sudden disconnection or intentional exit
    FINISHED         // After the player's game or round ends
}
