package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.GameBoard;
import cleancode.minesweeper.tobe.GameException;


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