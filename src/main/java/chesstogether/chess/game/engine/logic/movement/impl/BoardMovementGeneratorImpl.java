package chesstogether.chess.game.engine.logic.movement.impl;

import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.Piece;
import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.logic.location.SquareLocationFactory;
import chesstogether.chess.game.engine.logic.moveCalc.MoveCalc;
import chesstogether.chess.game.engine.logic.moveCalc.MoveCalcFactory;
import chesstogether.chess.game.engine.logic.status.StatusMapFactory;
import chesstogether.chess.game.engine.logic.movement.BoardMovementGenerator;
import chesstogether.chess.game.engine.logic.pieceExtractor.ActivePieceExtractor;
import chesstogether.chess.game.engine.physics.SquareLocation;
import chesstogether.chess.game.engine.enums.Player;
import chesstogether.chess.game.engine.enums.SquareStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("boardMoveGeneratorImpl")
public class BoardMovementGeneratorImpl implements BoardMovementGenerator {
    private final StatusMapFactory statusMapFactory;
    private final ActivePieceExtractor activePieceExtractor;
    private final SquareLocationFactory squareLocationFactory;
    private final MoveCalcFactory moveCalculatorFactory;

    public BoardMovementGeneratorImpl(StatusMapFactory statusMapFactory,
                                      ActivePieceExtractor activePieceExtractor,
                                      SquareLocationFactory squareLocationFactory,
                                      MoveCalcFactory moveCalculatorFactory) {
        this.statusMapFactory = statusMapFactory;
        this.activePieceExtractor = activePieceExtractor;
        this.squareLocationFactory = squareLocationFactory;
        this.moveCalculatorFactory = moveCalculatorFactory;
    }

    @Override
    public List<Move> generatePossibleMoves(Player activePlayer, List<Square> squares) {
        Map<SquareLocation, SquareStatus> locationStatusMap = statusMapFactory.buildStatusMap(activePlayer, squares);
        List<Move> moves = new ArrayList<>();
        List<Square> squaresWithActivePieces = activePieceExtractor.extractSquaresWithActivePieces(activePlayer, squares);
        for (Square square : squaresWithActivePieces) {
            SquareLocation pieceLocation = squareLocationFactory.buildSquareLocation(square);
            Piece piece = square.getPiece();
            MoveCalc moveCalculator = moveCalculatorFactory.buildMoveCalculator(piece);
            List<Move> movesWithPiece = moveCalculator.getPossibleMoves(pieceLocation, locationStatusMap);
            moves.addAll(movesWithPiece);
        }
        return moves;

    }
}