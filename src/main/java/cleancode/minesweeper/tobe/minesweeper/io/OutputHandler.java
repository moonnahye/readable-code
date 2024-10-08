package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.board.GameBoard;
import cleancode.minesweeper.tobe.minesweeper.exception.GameException;


public interface OutputHandler {

    void showGameStartComment();

    void showBoard(GameBoard board);

    String generateColAlphabets(GameBoard board);

    void showGameWinningComment();

    void showGameLosingComment();

    void showCommentForSelectionCell();

    void showCommentForUserAction();

    void showExceptionMessage(GameException e);

    void showSimpleMessage(String message);
}