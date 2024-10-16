package cleancode.minesweeper.tobe.minesweeper.board.position;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CellPositionsTest {

    @DisplayName("주어진 개수만큼 임의로 위치를 추출한다")
    @Test
    void extractRandomPositions() {

        // Given
        List<CellPosition> positions = Arrays.asList(
            new CellPosition(0, 0),
            new CellPosition(0, 1),
            new CellPosition(1, 0),
            new CellPosition(1, 1),
            new CellPosition(2, 2)
        );
        CellPositions cellPositions = new CellPositions(positions);

        int count = 3;

        // When
        List<CellPosition> result = cellPositions.extractRandomPositions(count);

        // Then
        assertThat(result).hasSize(3);
        assertThat(positions).containsAll(result);
    }

    @DisplayName("특정 위치를 제외하고 뽑아낸다.")
    @Test
    void subtract() {
        // Given
        List<CellPosition> positions = Arrays.asList(
            new CellPosition(0, 0),
            new CellPosition(0, 1),
            new CellPosition(1, 0),
            new CellPosition(1, 1),
            new CellPosition(2, 2)
        );
        CellPositions cellPositions = new CellPositions(positions);

        List<CellPosition> subtractCellPositions = Arrays.asList(
            new CellPosition(1, 0),
            new CellPosition(2, 2)
        );

        // When
        List<CellPosition> result = cellPositions.subtract(subtractCellPositions);

        // Then
        assertThat(result).hasSize(3);
        assertThat(result).doesNotContain(
            new CellPosition(1, 0),
            new CellPosition(2, 2)
        );
    }
}
