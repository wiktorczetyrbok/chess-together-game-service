package chesstogether.chess.game.engine.logic.location;

import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.physics.SquareLocation;

public interface SquareLocationFactory {
    SquareLocation buildSquareLocation(Square square);
}
