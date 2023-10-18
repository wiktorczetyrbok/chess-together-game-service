package chesstogether.chess.game.engine;

import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.enums.BoardStatus;
import chesstogether.chess.game.engine.enums.Player;
import chesstogether.chess.game.engine.enums.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private Player activePlayer;
    private BoardStatus status;
    private List<Square> squares;
    private List<Move> moves;
    private List<Type> promotionPieces;
}

