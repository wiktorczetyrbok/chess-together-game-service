package chesstogether.chess.game.engine.logic.movement.impl;

import chesstogether.chess.game.engine.Board;
import chesstogether.chess.game.Move;
import chesstogether.chess.game.engine.logic.check.CheckDetector;
import chesstogether.chess.game.engine.logic.movement.BoardMovementGenerator;
import chesstogether.chess.game.engine.enums.BoardStatus;

import java.util.ArrayList;
import java.util.List;

import static chesstogether.chess.game.engine.utils.PlayerUtils.toggleActivePlayer;


public class BoardMovementWithCheckNoPromotion extends BoardMovementNoCheckNoPromotion {
    private final CheckDetector checkDetector;

    public BoardMovementWithCheckNoPromotion(BoardMovementGenerator boardMoveGenerator, CheckDetector checkDetector) {
        super(boardMoveGenerator);
        this.checkDetector = checkDetector;
    }

    @Override
    public Board makeMoveOnBoard(Board board, Move move) {
        Board newBoard = super.makeMoveOnBoard(board, move);
        boolean inCheck = checkDetector.detectCheck(newBoard);

        newBoard.setMoves(pruneMovesForCheck(newBoard));
        if (newBoard.getMoves().isEmpty()) {
            if (inCheck) {
                newBoard.setStatus(BoardStatus.CHECKMATE);
            } else {
                newBoard.setStatus(BoardStatus.STALEMATE);
            }
        } else if (inCheck) {
            newBoard.setStatus(BoardStatus.IN_CHECK);
        }
        return newBoard;
    }

    private List<Move> pruneMovesForCheck(Board board) {
        List<Move> legalMoves = new ArrayList<>();
        for (Move move : board.getMoves()) {
            Board boardAfterMove = super.makeMoveOnBoard(board, move);

            boardAfterMove.setActivePlayer(toggleActivePlayer(boardAfterMove.getActivePlayer()));
            boolean inCheck = checkDetector.detectCheck(boardAfterMove);
            if (!inCheck) {
                legalMoves.add(move);
            }
        }
        return legalMoves;
    }
}
