package chesstogether.chess.game.engine.logic.movement.impl;

import chesstogether.chess.game.engine.Board;
import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.Piece;
import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.logic.location.SquareLocationFactory;
import chesstogether.chess.game.engine.logic.moveCalc.pieces.PawnMoveCalc;
import chesstogether.chess.game.engine.logic.status.StatusMapFactory;
import chesstogether.chess.game.engine.logic.check.CheckDetector;
import chesstogether.chess.game.engine.logic.movement.BoardMovementGenerator;
import chesstogether.chess.game.engine.physics.SquareLocation;
import chesstogether.chess.game.engine.enums.SquareStatus;
import chesstogether.chess.game.engine.enums.Type;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("boardMovementWithCheckWithPromotion")
public class BoardMovementWithCheckWithPromotion extends BoardMovementWithCheckNoPromotion {
    private final StatusMapFactory statusMapFactory;
    private final SquareLocationFactory squareLocationFactory;

    public BoardMovementWithCheckWithPromotion(BoardMovementGenerator boardMovementGenerator,
                                               CheckDetector checkDetector,
                                               StatusMapFactory statusMapFactory,
                                               SquareLocationFactory squareLocationFactory) {
        super(boardMovementGenerator, checkDetector);
        this.statusMapFactory = statusMapFactory;
        this.squareLocationFactory = squareLocationFactory;
    }

    @Override
    public Board makeMoveOnBoard(Board board, Move move) {

        Board newBoard = super.makeMoveOnBoard(board, move);

        Map<SquareLocation, SquareStatus> locationStatusMap
                = statusMapFactory.buildStatusMap(board.getActivePlayer(), board.getSquares());
        for (Square square : newBoard.getSquares()) {
            Piece piece = square.getPiece();
            if (piece != null && piece.getType().equals(Type.PAWN)) {
                SquareLocation pieceLocation = squareLocationFactory.buildSquareLocation(square);

                PawnMoveCalc pawnMoveCalc = new PawnMoveCalc(piece.getOwner(), piece.isHasMoved());
                if (pawnMoveCalc.pawnCanBePromoted(pieceLocation, locationStatusMap)) {
                    square.setPiece(new Piece(piece.getOwner(), Type.QUEEN, false, piece.isHasMoved()));
                }
            }
        }
        return newBoard;
    }
}
