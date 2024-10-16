package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellStateTest {

    @DisplayName("open()는 셀의 상태를 열린 상태로 바꾼다.")
    @Test
    void open() {
        // Given
        CellState cellState = CellState.initialize();
        assertThat(cellState.isOpened()).isFalse();

        // When
        cellState.open();

        // then
        assertThat(cellState.isOpened()).isTrue();
    }

    @DisplayName("flag()는 셀의 상태를 깃발 꽂힌 상태로 바꾼다.")
    @Test
    void flag() {
        // Given
        CellState cellState = CellState.initialize();
        assertThat(cellState.isFlagged()).isFalse();

        // When
        cellState.flag();

        // then
        assertThat(cellState.isFlagged()).isTrue();
    }
}
