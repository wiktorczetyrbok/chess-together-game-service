package chesstogether.chess.game.engine.logic.location;

import chesstogether.chess.game.engine.Square;
import chesstogether.chess.game.engine.physics.SquareLocation;
import org.springframework.stereotype.Component;


@Component("squareLocationFactoryImpl")
public class SquareLocationFactoryImpl implements SquareLocationFactory {
    @Override
    public SquareLocation buildSquareLocation(Square square) {
        SquareLocation squareLocation = new SquareLocation();
        squareLocation.setX(square.getX());
        squareLocation.setY(square.getY());
        return squareLocation;
    }
}
