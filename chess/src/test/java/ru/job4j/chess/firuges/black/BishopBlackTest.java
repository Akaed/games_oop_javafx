package ru.job4j.chess.firuges.black;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {
    @Test
    public void whenPositionTest() {
        Cell cell = Cell.F8;
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position(), is(cell));
    }

    @Test
    public void whenCopyTest() {
        Cell cellend = Cell.D6;
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(cellend, is(bishopBlack.copy(Cell.D6).position()));
    }

    @Test
    public void whenWayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopDiagonal = bishopBlack.way(Cell.G5);
        Cell[] bishopEnd = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopEnd, is(bishopDiagonal));
    }


}