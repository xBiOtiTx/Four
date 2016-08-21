package ru.belyaev.four;

public class WorldController {
    private final World mWorld;

    public WorldController(World world) {
        mWorld = world;
    }

    public void update(float deltaTime) {
    }

    public void setCell(Cell.CellType type, int number, int column, int line) {
        final Cell[][] field = mWorld.getField();
        if (column >= 0 && column < World.FIELD_SIZE && line>=0 && line < World.FIELD_SIZE) {
            field[column][line].setType(type);
            // field[column][line].add(number);
            field[column][line].setNumber(number);
        }
    }

    public void click(int x, int y) {
        final int space = 5;
        final int w = mWorld.getWidth() - space * (World.FIELD_SIZE - 1);
        final int h = mWorld.getHeight() - space * (World.FIELD_SIZE - 1);
        final int cellSize = Math.min(w, h) / World.FIELD_SIZE;

        final int column = x / cellSize;
        final int line = y / cellSize;

        System.out.println("x=" + x + ", y=" + y + ", line=" + line + ", column=" + column);

        final Cell[][] field = mWorld.getField();
        final Cell cell = field[column][line];
        if (cell.getType() == Cell.CellType.NUMBER) {
            final int number = cell.getNumber() - 1;
            setCell(Cell.CellType.EMPTY, 0, column, line);
            setCell(Cell.CellType.NUMBER, number, column, line + 1);
            setCell(Cell.CellType.NUMBER, number, column + 1, line);
            setCell(Cell.CellType.NUMBER, number, column, line - 1);
            setCell(Cell.CellType.NUMBER, number, column - 1, line);
        }
    }
}
