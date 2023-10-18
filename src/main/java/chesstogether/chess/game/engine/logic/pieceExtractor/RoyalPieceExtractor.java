package chesstogether.chess.game.engine.logic.pieceExtractor;

import chesstogether.chess.game.engine.Board;
import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.enums.Player;

import java.util.Set;

public interface RoyalPieceExtractor {
    Set<Square> extractRoyalPieces(Board board, Player targetPlayer);
}
