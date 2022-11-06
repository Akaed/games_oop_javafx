package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void figureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        logic.move(Cell.E5, Cell.F4);
    }

    @Test(expected = OccupiedCellException.class)
    public void occupiedCells()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B6));
        logic.add(new KingBlack(Cell.C5));
        logic.move(Cell.B6, Cell.D4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void impossibleMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E1));
        logic.move(Cell.E1, Cell.E2);
    }
}