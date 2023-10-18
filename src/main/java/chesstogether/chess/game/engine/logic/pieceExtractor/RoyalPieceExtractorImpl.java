package chesstogether.chess.game.engine.logic.pieceExtractor;

import chesstogether.chess.game.engine.Board;
import chesstogether.chess.game.engine.Piece;
import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.enums.Player;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component("royalPieceExtractor")
public class RoyalPieceExtractorImpl implements RoyalPieceExtractor {
    @Override
    public Set<Square> extractRoyalPieces(Board board, Player targetPlayer) {
        Set<Square> squaresWithRoyalPieces = new HashSet<>();
        for (Square square : board.getSquares()) {
            Piece piece = square.getPiece();
            if (piece != null && piece.getOwner().equals(targetPlayer) && piece.isRoyal()) {
                squaresWithRoyalPieces.add(square);
            }
        }
        return squaresWithRoyalPieces;
    }
}
