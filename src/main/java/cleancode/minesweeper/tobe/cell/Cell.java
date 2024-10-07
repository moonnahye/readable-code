package cleancode.minesweeper.tobe.cell;

public interface Cell {


     boolean isLandMine();
    boolean hasLandMineCount();

    CellSnapshot getSnapshot();

    public void flag();

    public void open();
    public boolean isChecked();

    public boolean isOpened();
}
