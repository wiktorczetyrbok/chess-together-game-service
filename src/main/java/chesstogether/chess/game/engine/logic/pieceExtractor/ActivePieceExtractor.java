package chesstogether.chess.game.engine.logic.pieceExtractor;

import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.enums.Player;

import java.util.List;

public interface ActivePieceExtractor {
    List<Square> extractSquaresWithActivePieces(Player activePlayer, List<Square> squares);
}
