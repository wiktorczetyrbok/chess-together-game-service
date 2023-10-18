package chesstogether.chess.game.engine.logic.moveCalc;

import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.physics.SquareLocation;
import chesstogether.chess.game.engine.enums.SquareStatus;

import java.util.List;
import java.util.Map;

public interface MoveCalc {
    List<Move> getPossibleMoves(SquareLocation pieceLocation, Map<SquareLocation, SquareStatus> locationStatusMap);
}
