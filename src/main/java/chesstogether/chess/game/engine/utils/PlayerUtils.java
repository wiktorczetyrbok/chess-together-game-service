package chesstogether.chess.game.engine.utils;

import chesstogether.chess.game.engine.enums.Player;

public class PlayerUtils {
    public static Player toggleActivePlayer(Player activePlayer) {
        return (activePlayer.equals(Player.BLACK)) ? Player.WHITE : Player.BLACK;
    }
}
