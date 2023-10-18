package chesstogether.chess.game.engine.logic.movement;

import chesstogether.chess.game.engine.Board;
import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.Piece;
import chesstogether.chess.game.engine.Square;

public interface BoardMovement {
    Board makeMoveOnBoard(Board board, Move move);

    default Piece clonePiece(Piece piece) {
        if (piece == null) {
            return null;
        }

        return new Piece(piece.getOwner(), piece.getType(), piece.isRoyal(), piece.isHasMoved());
    }

    default Piece getPieceToBeMoved(Board board, Move move) {
        for (Square square : board.getSquares()) {
            if (move.getX1() == square.getX() && move.getY1() == square.getY()) {
                return square.getPiece();
            }
        }
        return null;
    }
}
