package chesstogether.chess.game.engine;

import chesstogether.chess.game.engine.enums.Player;
import chesstogether.chess.game.engine.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Piece {
    private Player owner;
    private Type type;
    private boolean royal;
    private boolean hasMoved;
}