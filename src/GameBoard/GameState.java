package GameBoard;

public enum GameState {
        WAITING_FOR_PLAYERS, // Waiting for more players to join
        STARTING,            // Countdown or initial setup before the game starts
        IN_PROGRESS,         // The game is currently active
        ROUND_END,           // A round just ended
        GAME_OVER            // The game has ended
}
