package chesstogether.chess.game.engine.logic.movement;

import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.enums.Player;

import java.util.List;

public interface BoardMovementGenerator {
    List<Move> generatePossibleMoves(Player activePlayer, List<Square> squares);

}
