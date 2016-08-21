package ru.belyaev.four;

public class Cell {
    public enum CellType {
        NUMBER, EMPTY, BLOCK
    }

    private CellType mType;
    private int mNumber;

    public Cell(CellType type, int number) {
        mType = type;
        mNumber = number;
    }

    public Cell(CellType type) {
        this(type, 0);
    }

    public CellType getType() {
        return mType;
    }

    public void setType(CellType type) {
        mType = type;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    public void add(int n) {
        mNumber += n;
    }

    public void inc() {
        mNumber++;
    }

    public void dec() {
        mNumber--;
    }
}
