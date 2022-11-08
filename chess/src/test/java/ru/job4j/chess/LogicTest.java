package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void figureNotFound()
            throws  ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () ->
            logic.move(Cell.E5, Cell.F4));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }


    @Test
    public void occupiedCells()
            throws  ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack firstBishop = new BishopBlack(Cell.B6);
        BishopBlack secondBishop = new BishopBlack(Cell.C5);
        logic.add(firstBishop);
        logic.add(secondBishop);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () ->
            logic.move(Cell.B6, Cell.D4));
        assertThat(exception.getMessage()).isEqualTo("There is others figures on the way.");
    }

    @Test
    public void impossibleMove()
            throws  ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack firstBishop = new BishopBlack(Cell.E1);
        logic.add(firstBishop);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () ->
            logic.move(Cell.E1, Cell.E2));
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from E1 to E2");
    }

}