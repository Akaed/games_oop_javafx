package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPositionTest() {
        Cell cell = Cell.F8;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell currentPosition = bishopBlack.position();
        assertThat(currentPosition).isEqualTo(cell);
    }

    @Test
    public void whenCopyTest() {
        Cell firstPosition = Cell.C8;
        Cell secondPosition = Cell.G8;
        BishopBlack firstBishop = new BishopBlack(firstPosition);
        Figure secondBishop = firstBishop.copy(secondPosition);
        Cell currentPosition = secondBishop.position();
        assertThat(currentPosition).isEqualTo(secondPosition);
    }

    @Test
    public void whenWayTest() {
        Cell startPosition = Cell.C1;
        Cell endPosition = Cell.G5;
        Cell[] expectedCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack firstBishop = new BishopBlack(startPosition);
        firstBishop.way(endPosition);
        assertThat(firstBishop.way(endPosition)).isEqualTo(expectedCells);
    }
}