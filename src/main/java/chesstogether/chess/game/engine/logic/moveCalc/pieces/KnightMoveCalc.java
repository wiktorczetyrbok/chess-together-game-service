package chesstogether.chess.game.engine.logic.moveCalc.pieces;

import chesstogether.chess.game.engine.logic.moveCalc.SingleMoveCalc;
import chesstogether.chess.game.engine.physics.Vector;

import java.util.ArrayList;
import java.util.List;

public class KnightMoveCalc extends SingleMoveCalc {
    @Override
    public List<Vector> getVectors() {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1, 2));
        vectors.add(new Vector(-1, 2));
        vectors.add(new Vector(1, -2));
        vectors.add(new Vector(-1, -2));
        vectors.add(new Vector(2, 1));
        vectors.add(new Vector(-2, 1));
        vectors.add(new Vector(2, -1));
        vectors.add(new Vector(-2, -1));
        return vectors;
    }
}
