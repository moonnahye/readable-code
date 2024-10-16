package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellPositionTest {

    @DisplayName("행 인덱스가 주어진 값 이상인지 확인한다.")
    @Test
    void isRowIndexMoreThanOrEqual() {

        //given
        CellPosition cellPosition = new CellPosition(5, 1);

        //when & then
        assertTrue(cellPosition.isRowIndexMoreThanOrEqual(3));
        assertTrue(cellPosition.isRowIndexMoreThanOrEqual(0));
        assertFalse(cellPosition.isRowIndexMoreThanOrEqual(6));
    }


    @DisplayName("새로운 위치는 현재 위치와 변화량을 더했을때 0보다 커야 계산할 수 있다.")
    @Test
    void canCalculatePositionBy() {
        // given
        CellPosition cellPosition = new CellPosition(5, 5);
        RelativePosition relativePosition = new RelativePosition(1, 1);

        // when
        boolean result = cellPosition.canCalculatePositionBy(relativePosition);

        // then
        assertTrue(result);
    }

    @DisplayName("새로운 위치는 현재 위치와 변화량을 더했을때 0보다 작으면 계산 할 수 없다.")
    @Test
    void canCalculatePositionBy2() {
        // given
        RelativePosition relativePosition = new RelativePosition(-1, -1);
        CellPosition cellPosition = new CellPosition(0, 0);

        // when
        boolean result = cellPosition.canCalculatePositionBy(relativePosition);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("유효한 상대 위치로 새로운 셀 위치를 계산한다.")
    @Test
    void calculatePositionBy() {
        //given
        CellPosition cellPosition = new CellPosition(5, 5);
        RelativePosition relativePosition = new RelativePosition(1, 1);

        //when
        CellPosition newPosition = cellPosition.calculatePositionBy(relativePosition);

        // then
        assertThat(newPosition.getRowIndex()).isEqualTo(6);
        assertThat(newPosition.getColIndex()).isEqualTo(6);
    }

    @DisplayName("유효하지 않은 상대 위치로 셀 위치를 계산 시 예외가 발생한다.")
    @Test
    void calculatePositionBy2() {
        //given
        CellPosition cellPosition = new CellPosition(0, 0);
        RelativePosition relativePosition = new RelativePosition(-1, -1);

        // when & then
        assertThatThrownBy(
            () -> cellPosition.calculatePositionBy(relativePosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("움질일 수 있는 좌표가 아닙니다.");
    }

}
