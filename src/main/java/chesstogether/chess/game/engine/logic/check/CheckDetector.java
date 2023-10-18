package chesstogether.chess.game.engine.logic.check;

import chesstogether.chess.game.engine.Board;

public interface CheckDetector {
    boolean detectCheck(Board board);
}
