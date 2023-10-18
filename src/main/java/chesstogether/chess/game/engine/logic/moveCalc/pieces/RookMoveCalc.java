package chesstogether.chess.game.engine.logic.moveCalc.pieces;

import chesstogether.chess.game.engine.logic.moveCalc.MultipleMoveCalc;
import chesstogether.chess.game.engine.physics.Vector;

import java.util.ArrayList;
import java.util.List;

public class RookMoveCalc extends MultipleMoveCalc {
    @Override
    public List<Vector> getVectors() {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1, 0));
        vectors.add(new Vector(0, 1));
        vectors.add(new Vector(-1, 0));
        vectors.add(new Vector(0, -1));
        return vectors;
    }
}