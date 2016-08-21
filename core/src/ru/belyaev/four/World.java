package ru.belyaev.four;

public class World {
    public static final int FIELD_SIZE = 5;

    private final int mWidth;
    private final int mHeight;
    private final Cell[][] mField = new Cell[FIELD_SIZE][FIELD_SIZE];

    private WorldState mWorldState = WorldState.READY;

    public World(int width, int height) {
        mWidth = width;
        mHeight = height;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                mField[i][j] = new Cell(Cell.CellType.EMPTY);
            }
        }
//        mField[0][0] = new Cell(Cell.CellType.NUMBER, 0);
//        mField[1][1] = new Cell(Cell.CellType.NUMBER, 1);
//        mField[2][2] = new Cell(Cell.CellType.NUMBER, 2);
//        mField[3][3] = new Cell(Cell.CellType.NUMBER, 3);
//        mField[4][4] = new Cell(Cell.CellType.NUMBER, 4);
        mField[2][2] = new Cell(Cell.CellType.NUMBER, 4);
    }

    public WorldState getWorldState() {
        return mWorldState;
    }

    public void setWorldState(WorldState worldState) {
        mWorldState = worldState;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public Cell[][] getField() {
        return mField;
    }

    public enum WorldState {
        READY,
        RUNNING,
        GAME_OVER
    }

    public interface WorldListener {
    }
}
