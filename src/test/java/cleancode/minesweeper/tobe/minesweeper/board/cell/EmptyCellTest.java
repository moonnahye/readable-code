package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmptyCellTest {

    @DisplayName("EmptyCell은 지뢰가 아니어야한다.")
    @Test
    void isLandMine() {
        // Given
        Cell cell = new EmptyCell();

        // When
        boolean result = cell.isLandMine();

        // Then
        assertThat(result).isFalse();
    }

    @DisplayName("EmptyCell은 가진 지뢰의 개수가 없다.")
    @Test
    void hasLandMineCount() {
        // Given
        Cell cell = new EmptyCell();

        // When
        boolean result = cell.hasLandMineCount();

        // Then
        assertThat(result).isFalse();
    }

    @DisplayName("EmptyCell의 초기 스냅샷은 'UnChecked'이다.")
    @Test
    void getSnapshot_initialState() {
        // Given
        Cell cell = new EmptyCell();

        // When
        CellSnapshot snapshot1 = cell.getSnapshot();

        // Then
        assertThat(snapshot1).isEqualTo(CellSnapshot.ofUnChecked());
    }

    @DisplayName("EmptyCell이 열리면 스냅샷은 'Empty'이어야 한다")
    @Test
    void getSnapshot_afterOpened() {
        // Given
        Cell cell = new EmptyCell();

        // When
        cell.open();
        CellSnapshot snapshot = cell.getSnapshot();

        // Then
        assertThat(snapshot).isEqualTo(CellSnapshot.ofEmpty());
    }


    @DisplayName("깃발 꽂힌 EmptyCell의 스냅샷은 'Flag'이다.")
    @Test
    void getSnapshot_afterFlagged() {
        // Given
        Cell cell = new EmptyCell();

        // When
        cell.flag();
        CellSnapshot snapshot = cell.getSnapshot();

        // Then
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
    }


}
