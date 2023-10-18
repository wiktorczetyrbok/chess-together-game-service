package chesstogether.chess.game.engine.logic.status;

import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.physics.SquareLocation;
import chesstogether.chess.game.engine.enums.Player;
import chesstogether.chess.game.engine.enums.SquareStatus;

import java.util.List;
import java.util.Map;

public interface StatusMapFactory {
    Map<SquareLocation, SquareStatus> buildStatusMap(Player activePlayer, List<Square> squareList);
}
