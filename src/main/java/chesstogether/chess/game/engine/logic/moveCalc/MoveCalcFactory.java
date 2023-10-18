package chesstogether.chess.game.engine.logic.moveCalc;

import chesstogether.chess.game.engine.Piece;

public interface MoveCalcFactory {
    MoveCalc buildMoveCalculator(Piece piece);
}
